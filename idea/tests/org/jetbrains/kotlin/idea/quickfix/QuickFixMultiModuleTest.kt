/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.quickfix

import org.jetbrains.kotlin.config.JvmTarget
import org.jetbrains.kotlin.config.TargetPlatformKind
import org.jetbrains.kotlin.idea.stubs.createFacet
import org.junit.Test

class QuickFixMultiModuleTest : AbstractQuickFixMultiModuleTest() {
    private fun doMultiPlatformTest(
            expectName: String = "header", // todo: change dir name
            vararg impls: Pair<String, TargetPlatformKind<*>> = arrayOf("jvm" to TargetPlatformKind.Jvm[JvmTarget.JVM_1_6]),
            withTests: Boolean = false
    ) {
        val commonModule = module(expectName, hasTestRoot = withTests)
        commonModule.createFacet(TargetPlatformKind.Common, false)

        impls.forEach { (implName, implKind) ->
            val implModule = module(implName, hasTestRoot = withTests)
            implModule.createFacet(implKind, implementedModuleName = expectName)
            implModule.enableMultiPlatform()
            implModule.addDependency(commonModule)
        }

        doQuickFixTest()
    }

    private fun doTestHeaderWithJvmAndJs(expectName: String = "header") {
        doMultiPlatformTest(impls = *arrayOf("jvm" to TargetPlatformKind.Jvm[JvmTarget.JVM_1_6], "js" to TargetPlatformKind.JavaScript))
    }

    @Test
    fun testAbstract() {
        doMultiPlatformTest(impls = *arrayOf("js" to TargetPlatformKind.JavaScript))
    }

    @Test
    fun testAnnotation() {
        doMultiPlatformTest()
    }

    @Test
    fun testClass() {
        doMultiPlatformTest()
    }

    @Test
    fun testClassFunction() {
        doMultiPlatformTest()
    }

    @Test
    fun testClassOverloadedFunction() {
        doMultiPlatformTest()
    }

    @Test
    fun testClassSomeProperties() {
        doMultiPlatformTest()
    }

    @Test
    fun testDeprecatedHeader() {
        doMultiPlatformTest()
    }

    @Test
    fun testDeprecatedHeaderImpl() {
        doMultiPlatformTest()
    }

    @Test
    fun testDeprecatedImpl() {
        doMultiPlatformTest()
    }

    @Test
    fun testDeprecatedImplHeader() {
        doMultiPlatformTest()
    }

    @Test
    fun testEnum() {
        doMultiPlatformTest(impls = *arrayOf("js" to TargetPlatformKind.JavaScript))
    }

    @Test
    fun testFunction() {
        doMultiPlatformTest()
    }

    @Test
    fun testInterface() {
        doMultiPlatformTest()
    }

    @Test
    fun testNested() {
        doMultiPlatformTest()
    }

    @Test
    fun testObject() {
        doMultiPlatformTest()
    }

    @Test
    fun testOrderHeader() {
        doMultiPlatformTest()
    }

    @Test
    fun testOrderImpl() {
        doMultiPlatformTest()
    }

    @Test
    fun testPackage() {
        doMultiPlatformTest()
    }

    @Test
    fun testPackageIncorrect() {
        doMultiPlatformTest()
    }

    @Test
    fun testPackageIncorrectEmpty() {
        doMultiPlatformTest()
    }

    @Test
    fun testPrimaryConstructor() {
        doMultiPlatformTest()
    }

    @Test
    fun testPrimaryConstructorAbsence() {
        doMultiPlatformTest()
    }

    @Test
    fun testProperty() {
        doMultiPlatformTest()
    }

    @Test
    fun testSealed() {
        doMultiPlatformTest(impls = *arrayOf("js" to TargetPlatformKind.JavaScript))
    }

    @Test
    fun testSecondaryConstructorAbsence() {
        doMultiPlatformTest()
    }

    @Test
    fun testWithFakeJvm() {
        val commonModule = module("header")
        commonModule.createFacet(TargetPlatformKind.Common, false)
        val jvmKind = TargetPlatformKind.Jvm[JvmTarget.JVM_1_6]
        arrayOf("fake_jvm" to jvmKind, "jvm" to jvmKind).forEach { (implName, implKind) ->
            val implModule = module(implName)
            implModule.createFacet(implKind, implementedModuleName = "header".takeIf { implName == "jvm" })
            implModule.enableMultiPlatform()
            implModule.addDependency(commonModule)
        }
        doQuickFixTest()
    }

    @Test
    fun testWithTest() {
        doMultiPlatformTest(expectName = "common", withTests = true)
    }

    @Test
    fun testWithTestDummy() {
        doMultiPlatformTest(expectName = "common", withTests = true)
    }

    @Test
    fun testMemberFunToExtensionByHeader() = doTestHeaderWithJvmAndJs()

    @Test
    fun testMemberFunToExtensionByImpl() = doTestHeaderWithJvmAndJs()

    @Test
    fun testMemberValToExtensionByHeader() = doTestHeaderWithJvmAndJs()

    @Test
    fun testMemberValToExtensionByHeaderWithInapplicableImpl() = doTestHeaderWithJvmAndJs()

    @Test
    fun testMemberValToExtensionByImpl() = doTestHeaderWithJvmAndJs()

    @Test
    fun testAddOperatorByHeader() = doTestHeaderWithJvmAndJs()

    @Test
    fun testAddOperatorByImpl() = doTestHeaderWithJvmAndJs()

    @Test
    fun testMemberFunReceiverToParameterByHeader() = doTestHeaderWithJvmAndJs()

    @Test
    fun testMemberFunReceiverToParameterByImpl() = doTestHeaderWithJvmAndJs()

    @Test
    fun testMemberFunParameterToReceiverByHeader() = doTestHeaderWithJvmAndJs()

    @Test
    fun testMemberFunParameterToReceiverByImpl() = doTestHeaderWithJvmAndJs()

    @Test
    fun testFunctionTypeParameterToReceiverByHeader() = doTestHeaderWithJvmAndJs()

    @Test
    fun testFunctionTypeParameterToReceiverByImpl() = doTestHeaderWithJvmAndJs()

    @Test
    fun testFunctionTypeReceiverToParameterByHeader() = doTestHeaderWithJvmAndJs()

    @Test
    fun testFunctionTypeReceiverToParameterByImpl() = doTestHeaderWithJvmAndJs()

    @Test
    fun testImplementMembersInImplClassNonImplInheritor() = doMultiPlatformTest()

    @Test
    fun testAddActualToClass() = doMultiPlatformTest()

    @Test
    fun testAddActualToClassMember() = doMultiPlatformTest()

    @Test
    fun testAddActualToTopLevelMember() = doMultiPlatformTest()

    @Test
    fun testCreateFunInExpectClass() = doMultiPlatformTest()

    @Test
    fun testCreateValInExpectClass() = doMultiPlatformTest()

    @Test
    fun testCreateVarInExpectClass() = doMultiPlatformTest()

    @Test
    fun testConvertExpectSealedClassToEnum() = doTestHeaderWithJvmAndJs("header")

    @Test
    fun testConvertActualSealedClassToEnum() = doTestHeaderWithJvmAndJs("js")

    @Test
    fun testConvertExpectEnumToSealedClass() = doTestHeaderWithJvmAndJs("header")

    @Test
    fun testConvertActualEnumToSealedClass() = doTestHeaderWithJvmAndJs("js")
}
