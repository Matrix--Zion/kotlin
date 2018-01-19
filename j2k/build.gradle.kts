
apply { plugin("kotlin") }

dependencies {
    testRuntime(intellijDep())

    compile(projectDist(":kotlin-stdlib"))
    compile(project(":compiler:frontend"))
    compile(project(":compiler:frontend.java"))
    compile(project(":compiler:light-classes"))
    compile(project(":compiler:util"))
    compileOnly(intellijCoreDep()) { includeJars("intellij-core") }

    testCompile(project(":idea"))
    testCompile(project(":idea:idea-test-framework"))
    testCompile(project(":compiler:light-classes"))
    testCompile(projectDist(":kotlin-test:kotlin-test-junit"))
    testCompile(commonDep("junit:junit"))

    testRuntime(project(":plugins:kapt3-idea")) { isTransitive = false }
    testRuntime(projectDist(":kotlin-compiler"))
    testRuntime(project(":idea:idea-jvm"))
    testRuntime(project(":idea:idea-android"))
    testRuntime(project(":plugins:android-extensions-ide"))
    testRuntime(project(":sam-with-receiver-ide-plugin"))
    testRuntime(project(":allopen-ide-plugin"))
    testRuntime(project(":noarg-ide-plugin"))
    testRuntime(intellijPluginDep("properties"))
    testRuntime(intellijPluginDep("gradle"))
    testRuntime(intellijPluginDep("Groovy"))
    testRuntime(intellijPluginDep("coverage"))
    //testRuntime(intellijPluginDep("maven"))
    testRuntime(intellijPluginDep("android"))
    testRuntime(intellijPluginDep("junit"))
    testRuntime(intellijPluginDep("testng"))
    testRuntime(intellijPluginDep("IntelliLang"))
    testRuntime(intellijPluginDep("testng"))
    testRuntime(intellijPluginDep("copyright"))
    testRuntime(intellijPluginDep("properties"))
    testRuntime(intellijPluginDep("java-i18n"))
    testRuntime(intellijPluginDep("java-decompiler"))
}

sourceSets {
    "main" { projectDefault() }
    "test" { projectDefault() }
}

projectTest {
    shouldRunAfter(":dist")
    workingDir = rootDir
    doFirst {
        systemProperty("idea.home.path", intellijRootDir().canonicalPath)
    }
}

testsJar()


val testForWebDemo by task<Test> {
    include("**/*JavaToKotlinConverterForWebDemoTestGenerated*")
    classpath = the<JavaPluginConvention>().sourceSets["test"].runtimeClasspath
    workingDir = rootDir
}
val cleanTestForWebDemo by tasks

val test: Test by tasks
test.apply {
    exclude("**/*JavaToKotlinConverterForWebDemoTestGenerated*")
    dependsOn(testForWebDemo)
}
val cleanTest by tasks
cleanTest.dependsOn(cleanTestForWebDemo)

