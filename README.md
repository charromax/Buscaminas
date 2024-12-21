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

## Screenshots
<img width="333" alt="image" src="https://github.com/user-attachments/assets/955eb915-2628-4352-812c-af36189c2c96" />
