plugins {
    id("java")
}

group = "it.cs.unicam"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.apache.jena:jena-core:4.3.0")

    // https://mvnrepository.com/artifact/org.apache.jena/jena-core
    implementation("org.apache.jena:jena-core:4.8.0")
    implementation("org.apache.jena:jena-arq:4.8.0")

    // https://github.com/Galigator/openllet
    implementation("com.github.galigator.openllet:openllet-jena:2.6.5")
    implementation("com.github.galigator.openllet:openllet-owlapi:2.6.5")
}

tasks.test {
    useJUnitPlatform()
}