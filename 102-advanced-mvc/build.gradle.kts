plugins {
    application
    java
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.DrawNumberApp")
}

dependencies {
    implementation("com.github.spotbugs:spotbugs-annotations:4.8.3")
}
