# Configure Gradle

This guide explains how to set up Gradle for a Java project.

---

# Option 1 - Create a New Gradle Project

When creating a new project in IntelliJ:

```
File
↓
New
↓
Project
↓
Gradle
```

Choose:

- Language: Java
- Build Script: Kotlin DSL
- JDK: 21

Finish creating the project.

Gradle will automatically generate the required files.

---

# Option 2 - Convert an Existing Java Project

This project was originally created as a standard Java project and later converted to Gradle.

---

## Step 1 - Check if Gradle is installed

Open a terminal.

Run:

```bash
gradle -v
```

If Gradle is installed, you should see something similar to:

```text
------------------------------------------------------------
Gradle 8.x.x
------------------------------------------------------------
```

If you get:

```text
Command 'gradle' not found
```

install Gradle.

---

## Step 2 - Install Gradle

Run:

```bash
sudo snap install gradle --classic
```

After installation, verify it:

```bash
gradle -v
```

Expected output:

```text
Gradle 8.14.4
```

---

## Step 3 - Initialize Gradle

Navigate to your project folder.

Run:

```bash
gradle init
```

Since the project already exists, Gradle will ask:

```text
Found existing files in the project directory.
Directory will be modified and existing files may be overwritten.
Continue?
```

Choose:

```text
yes
```

---

## Step 4 - Select Project Type

Choose:

```text
4
```

```
Basic (build structure only)
```

Reason:

The project already exists.

We only want Gradle to manage the build.

We do **not** want Gradle to create an example application.

---

## Step 5 - Project Name

Press Enter to keep the current project name.

Example:

```text
Monster_Maze_2.0
```

---

## Step 6 - Build Script

Choose:

```text
1
```

```
Kotlin DSL
```

Reason:

- Better IntelliJ support
- Modern Gradle projects
- Better autocomplete

---

## Step 7 - New Gradle APIs

Gradle asks:

```text
Generate build using new APIs and behavior?
```

Choose:

```text
yes
```

---

## Step 8 - Wait for Gradle

Expected output:

```text
BUILD SUCCESSFUL
```

---

## Step 9 - Verify Project Files

Your project should now contain:

```text
build.gradle.kts
settings.gradle.kts

gradlew
gradlew.bat

gradle/
```

The Gradle folder should contain:

```text
gradle
└── wrapper
```

---

## Step 10 - Test the Build

Run:

```bash
./gradlew build
```

Expected output:

```text
BUILD SUCCESSFUL
```

This confirms Gradle is configured correctly.

---

# Understanding the Generated Files

## build.gradle.kts

The main Gradle configuration file.

This tells Gradle:

- which plugins to use
- which libraries to download
- which Java version to use
- how to run the application

---

## settings.gradle.kts

Contains the project name.

Example:

```kotlin
rootProject.name = "Monster_Maze_2.0"
```

---

## gradlew

Gradle Wrapper for Linux and macOS.

Instead of running:

```bash
gradle build
```

run:

```bash
./gradlew build
```

This ensures everyone uses the same Gradle version.

---

## gradlew.bat

Gradle Wrapper for Windows.

---

## gradle/

Contains files used by the Gradle Wrapper.

Normally this folder should not be modified manually.

---

## gradle.properties

Stores Gradle configuration.

Usually no changes are required.

---

# Configuring build.gradle.kts

Replace the generated contents with:

```kotlin
plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

javafx {
    version = "21"
    modules = listOf("javafx.controls")
}

application {
    mainClass.set("com.eshanvd.monstermaze.MonsterMazeApplication")
}
```

---

# What Each Section Does

## plugins

```kotlin
plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}
```

- Marks this as a Java application.
- Downloads and configures JavaFX automatically.

---

## repositories

```kotlin
repositories {
    mavenCentral()
}
```

Tells Gradle where to download libraries.

---

## java

```kotlin
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
```

Sets the project to use Java 21.

---

## javafx

```kotlin
javafx {
    version = "21"
    modules = listOf("javafx.controls")
}
```

Downloads JavaFX and includes the Controls module.

---

## application

```kotlin
application {
    mainClass.set("com.eshanvd.monstermaze.MonsterMazeApplication")
}
```

Specifies which class Gradle should run when executing:

```bash
./gradlew run
```

---

# Common Problems

## Problem

```text
Command 'gradle' not found
```

### Solution

Install Gradle:

```bash
sudo snap install gradle --classic
```

---

## Problem

Gradle creates an `app/` folder.

### Solution

This happens if you choose:

```
Application
```

during `gradle init`.

For an existing project, use:

```
Basic (build structure only)
```

If the `app/` folder is created accidentally and contains only generated example files, it can be removed.

---

## Problem

No `build.gradle.kts` file appears.

### Solution

Run:

```bash
gradle init
```

again and choose:

```
Basic
```

with

```
Kotlin DSL
```

---

## Useful Commands

Check Gradle version:

```bash
gradle -v
```

Initialize Gradle:

```bash
gradle init
```

Build the project:

```bash
./gradlew build
```

Run the application:

```bash
./gradlew run
```
