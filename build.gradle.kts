plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}
/*application -> tells gradle this is runnable app
* the other thing auto downloads and configs JavaFX*/

repositories {
    mavenCentral()
}
/*tells where to download libs from*/

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
/*Java proj version = 21*/

javafx {
    version = "21"
    modules = listOf("javafx.controls")
}
/*downloads JavaFX and includes javafx.controls [provides UI ctrls] and necessary mods for GUI app*/

application {
    mainClass.set("com.eshanvd.monstermaze.MonsterMazeApplication")
}
/*tells gradle which class to start*/