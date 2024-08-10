plugins {
    id("java")
    id("application") // Add this line
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.11.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("capyblappy.Main") // Set the main class
}

tasks.test {
    useJUnitPlatform()
}
