plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")

    // https://mvnrepository.com/artifact/org.apache.jena/
    implementation("org.apache.jena:jena-core:4.8.0")
    implementation("org.apache.jena:jena-arq:4.8.0")

    // https://github.com/Galigator/openllet
    implementation("com.github.galigator.openllet:openllet-jena:2.6.5")
    implementation("com.github.galigator.openllet:openllet-owlapi:2.6.5")

    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")

}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}