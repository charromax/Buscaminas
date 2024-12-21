# KBuscaminas

KBuscaminas is a Compose Multiplatform app targeting *Android*, *IOS* and *Desktop*;  
inspired by the classic Minesweeper game. 
The project is modularized by feature and follows Clean Architecture principles to ensure 
scalability and maintainability. Credits to [KotLearn](https://www.youtube.com/@Kotlearn) for this
amazing course.

## Project Structure

The app is divided into modules to promote separation of concerns:

- **App Layer**: `:composeApp`
- **UI Layer**: `:ui:core`
- **Data Layer**: `:data:core`, `:data:game`, `:data:settings`
- **Domain Layer**: `:domain:game`, `:domain:settings`
- **Feature Modules**: `:feature:settings`, `:feature:play`, `:feature:menu`, `:feature:highscore`

## Tech Stack

- **Compose Multiplatform**: Modern UI development for Android and other platforms.
- **Kotlin Multiplatform**: Shared logic and models.
- **Dependency Injection**: [Koin](https://insert-koin.io/)
- **Database**: Room and SQLite.
- **State Management**: Jetpack Compose and AndroidX Lifecycle.
- **Testing**: MockK and Kotest.

## Key Versions

- Kotlin: `2.0.21`
- Compose: `1.7.0`
- Koin: `4.0.0`
- Room: `2.7.0-alpha11`
- MockK: `1.13.13`
- Kotest: `5.9.1`
- Android Compile SDK: `35`
- Minimum SDK: `24`