plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.threeten:threeten-extra:1.3.2")
}

tasks.test {
    useJUnitPlatform()
}