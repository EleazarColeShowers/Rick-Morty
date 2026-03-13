# Rick-Morty
An Android app to browse Rick and Morty characters built with Jetpack Compose.

# Running the app
Clone the repo, open in Android Studio, let Gradle sync, then hit run. No API keys needed — the Rick and Morty API is public.
Minimum SDK: 26

# Stack
Jetpack Compose
Hilt (dependency injection)
Retrofit + Gson (networking)
Coil (image loading)
Coroutines + Flow
Navigation Compose

# Architecture
I went with Clean Architecture and MVVM, split into three layers:

Data — Retrofit interface, DTOs, and the repository implementation that maps API responses to domain models.

Domain — Plain Kotlin. The Character model and the CharacterRepository interface live here. No Android imports.

Ui — Composable screens, ViewModels, and navigation. ViewModels only talk to the repository interface, never to Retrofit directly.

The reason I kept the DTO and domain model separate is so an API change doesn't ripple through the whole app — only the mapper needs updating. The UiState sealed class (Loading / Success / Error) makes it impossible to show a result and an error at the same time, and the compiler forces every state to be handled in the UI.
I used Hilt because wiring dependencies manually gets messy fast, and it keeps the NetworkModule as the single place where Retrofit is configured.
