/*
 * Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.codeInsight.moveUpDown;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/testData/codeInsight/moveLeftRight")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class MoveLeftRightTestGenerated extends AbstractMoveLeftRightTest {
    public void testAllFilesPresentInMoveLeftRight() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/codeInsight/moveLeftRight"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
    }

    @TestMetadata("annotationParams.kt")
    public void testAnnotationParams() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/annotationParams.kt");
        doTest(fileName);
    }

    @TestMetadata("basesList.kt")
    public void testBasesList() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/basesList.kt");
        doTest(fileName);
    }

    @TestMetadata("callArgs1.kt")
    public void testCallArgs1() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/callArgs1.kt");
        doTest(fileName);
    }

    @TestMetadata("callArgs2.kt")
    public void testCallArgs2() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/callArgs2.kt");
        doTest(fileName);
    }

    @TestMetadata("callArgs3.kt")
    public void testCallArgs3() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/callArgs3.kt");
        doTest(fileName);
    }

    @TestMetadata("callArgs4.kt")
    public void testCallArgs4() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/callArgs4.kt");
        doTest(fileName);
    }

    @TestMetadata("callArgs5.kt")
    public void testCallArgs5() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/callArgs5.kt");
        doTest(fileName);
    }

    @TestMetadata("funParams1.kt")
    public void testFunParams1() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/funParams1.kt");
        doTest(fileName);
    }

    @TestMetadata("funParams2.kt")
    public void testFunParams2() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/funParams2.kt");
        doTest(fileName);
    }

    @TestMetadata("funParams3.kt")
    public void testFunParams3() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/funParams3.kt");
        doTest(fileName);
    }

    @TestMetadata("funParams4.kt")
    public void testFunParams4() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/funParams4.kt");
        doTest(fileName);
    }

    @TestMetadata("indexArgs.kt")
    public void testIndexArgs() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/indexArgs.kt");
        doTest(fileName);
    }

    @TestMetadata("lambdaParams.kt")
    public void testLambdaParams() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/lambdaParams.kt");
        doTest(fileName);
    }

    @TestMetadata("typeArgs.kt")
    public void testTypeArgs() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/codeInsight/moveLeftRight/typeArgs.kt");
        doTest(fileName);
    }
}
