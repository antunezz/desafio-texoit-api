plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.apache.poi:poi-ooxml:4.0.0")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.11.0")
    testImplementation("io.rest-assured:json-schema-validator:4.3.1")
    testImplementation("io.rest-assured:rest-assured:4.3.1")
    testImplementation("org.json:json:20200518")
    testImplementation("org.ini4j:ini4j:0.5.4")
    testImplementation("com.google.code.gson:gson:2.10.1")
}
