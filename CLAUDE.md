# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

MokuMokuSolo（もくもくソロ）is a Kotlin Multiplatform Mobile (KMM) application designed to help indie developers track revenue and expenses for their apps, maintaining motivation by visualizing progress toward realistic revenue goals (¥10,000, ¥50,000, ¥100,000/month).

## Technology Stack

- **Kotlin**: 2.2.0
- **Compose Multiplatform**: 1.8.2 (shared UI across platforms)
- **Kotlin Multiplatform**: Shared business logic for Android and iOS
- **Room Database**: 2.8.2 (with KSP 2.2.0-2.0.2 for multiplatform)
- **Koin**: 4.1.0 (dependency injection)
- **Navigation Compose**: Type-safe navigation with kotlinx.serialization
- **Target Platforms**: Android (minSdk 24, targetSdk 35), iOS (x64, arm64, simulator arm64)

## Build Commands

### Android
```bash
# Build Android app
./gradlew :composeApp:assembleDebug

# Run on Android device/emulator
./gradlew :composeApp:installDebug
```

### iOS
```bash
# Build iOS framework
./gradlew :composeApp:linkDebugFrameworkIosSimulatorArm64

# Open Xcode project (run from root)
open iosApp/iosApp.xcodeproj
```

### Testing
```bash
# Run common tests
./gradlew :composeApp:cleanTestDebugUnitTest :composeApp:testDebugUnitTest

# Run Android tests
./gradlew :composeApp:connectedAndroidTest
```

### Database Schema Management
```bash
# Room schema exports are in composeApp/schemas/
# KSP generates Room code for all platforms (Android, iosX64, iosArm64, iosSimulatorArm64)
```

## Architecture

### Code Organization

```
composeApp/src/
├── commonMain/kotlin/          # Shared code for all platforms
│   ├── ui/                     # Compose UI components
│   │   ├── home/              # Home screen with revenue/expense lists
│   │   ├── addItem/           # Add revenue/expense form
│   │   ├── main/              # Main screen with navigation
│   │   └── theme/             # Theme, colors, typography
│   ├── data/
│   │   ├── database/          # Room database, DAOs, entities
│   │   └── repository/        # Repository pattern for data access
│   ├── model/                 # UI models
│   ├── navigation/            # Type-safe navigation definitions
│   └── di/                    # Koin DI modules
├── androidMain/               # Android-specific code
│   └── di/                    # Android database initialization
└── iosMain/                   # iOS-specific code
    └── di/                    # iOS database initialization (initKoinIos)

iosApp/                        # iOS native app wrapper
└── iosApp/
    └── iOSApp.swift          # iOS entry point, calls initKoinIos()
```

### Dependency Injection (Koin)

The app uses a multi-module Koin setup:

1. **commonAppModule** (commonMain): Provides DAOs, repositories, and ViewModels
2. **Platform-specific modules**:
   - `androidModule`: Android Room database builder (requires Context)
   - `iosModule`: iOS Room database builder

**iOS initialization**: Koin is initialized in Swift via `PlatformModule_iosKt.doInitKoinIos()` in `iOSApp.swift`

**Android initialization**: Koin is initialized in the Android Application class (not shown in common code)

### Data Layer

- **Room Database**: Multiplatform database with `BundledSQLiteDriver`
- **Entities**: `App` (user's apps with revenue), `Expenditure` (expenses)
- **DAOs**: `AppDao`, `ExpenditureDao`
- **Repositories**: Interface-based repositories (`AppRepository`, `ExpenditureRepository`) with implementations
- **Database construction**: Platform-specific builders via `expect`/`actual` pattern

### UI Layer

- **Navigation**: Type-safe Compose Navigation with sealed interface `AppDestination`
- **Bottom Navigation**: `Home` and `Calendar` destinations (Calendar not yet implemented)
- **ViewModels**: Koin-injected ViewModels (e.g., `MainViewModel`, `AddItemViewModel`)
- **Theme**: Material3 theme in `ui/theme/`

## Key Conventions

### File Naming & Structure
- Platform-specific files use `.android.kt` and `.ios.kt` suffixes
- UI components are in `ui/` with screen-specific subdirectories
- Database entities are separate from UI models (entity vs model packages)

### Dependency Injection
- Use `viewModel { }` DSL for ViewModels in Koin modules
- Use `single { }` for repositories and DAOs
- Platform modules provide platform-specific dependencies (database builders)

### Room Database
- All Room entities must be added to the `@Database` annotation in `AppDatabase.kt`
- KSP runs for all platforms: `kspAndroid`, `kspIosSimulatorArm64`, `kspIosX64`, `kspIosArm64`
- Database version is tracked; migrations required for schema changes

### Navigation
- Use `@Serializable` data objects for type-safe navigation
- Bottom navigation items defined in `bottomNavItems` list

## Current Feature Set

- Revenue and expense registration
- Revenue and expense list display
- Progress bar showing the most achievable revenue goal
- Bottom navigation (Home screen active, Calendar placeholder)

## Planned Features (from README)

- Edit/delete revenue and expenses
- Calendar view for revenue/expense trends
- Detailed analytics with AI-powered advice