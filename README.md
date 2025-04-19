# Android Multi-Module Template

A scalable Android starter project using **Kotlin**, **Jetpack Compose**, and **Gradle Kotlin DSL**, with a clean multi-module architecture.

---

## Features

- Modular architecture with separation of concerns
- Jetpack Compose for UI
- Gradle Kotlin DSL with version catalog (`libs.versions.toml`)
- Shared plugin logic via `build-logic`
- Kotlin 2.1.x + AGP 8.2.x+

---

## Project Structure
```
root/
├── app/ # Application entry point
├── common/ # Shared code (design system, utils, etc.)
    └── core/
    └── ui/
├── domain/ # Business logic, use cases 
├── data/ # Repositories, data sources 
├── feature/ # Example feature module 
├── build-logic/ # Shared Gradle plugin configs 
├── gradle/ # Version catalog 
├── settings.gradle.kts 
└── build.gradle.kts
```

---

## Getting Started

### 1. Clone the Project

```bash
git clone https://github.com/agungkurn/Multi-Module-Template.git
cd Multi-Module-Template
```

### 2. Open in Android Studio
Open the folder and sync the Gradle project.

## Refactor & Rename
### Step 1: Change Package Name
- Decide your new package (e.g., com.example.myapp)
- Replace all id.ak.multimoduletemplate with your new package
- Use Refactor > Rename in Android Studio for safety

### Step 2: Rename Modules (optional)
- To rename a module like feature-home: Right-click the module > Refactor > Rename
- Update settings.gradle.kts:
```kotlin
include(":feature-dashboard")
```

### Step 3: Update App Namespace
- In app/build.gradle.kts:
```kotlin
namespace = "com.example.myapp"
```

## Gradle Setup
- Shared plugins in build-logic
- Version catalog in gradle/libs.versions.toml:

```toml
[versions]
coil = "2.4.0"

[libraries]
coil = { module = "io.coil-kt:coil-compose", version.ref = "coil" }
```

## Requirements
- Android Studio Meerkat or later
- JDK 21
- Kotlin 2.1.x
- AGP 8.9.x+
- Min SDK: 24 / Target SDK: 34

## TODO
- Rename package and modules
- Replace placeholder UI
- Update app name/icon
- Add your own README section
- Configure CI/CD (optional)
