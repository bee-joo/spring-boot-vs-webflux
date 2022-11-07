# Spring WebFlux - get anime and movies
## Application
```GET /api/anime/{id}``` - get one anime by id from Jikan API and one random movie from Mflix database  
```GET /api/movies?count={n}``` - get N (0 < N ≤ 25) random movies
## Stack
* Java 17
* Spring WebFlux
* Spring Data Reactive MongoDB
* Lombok
* Gradle
