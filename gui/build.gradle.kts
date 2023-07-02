plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.13"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")

    implementation(project(":api"))
}

javafx {
    version = "20"
    modules("javafx.controls", "javafx.fxml")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("it.unicam.cs.storyscape.App")
}