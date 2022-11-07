# spring-boot-vs-webflux

### University project  
Comparison between classic MVC and reactive Spring stack. Talking about asynchronous and reactive programming and comparing Spring MVC, Spring WebFlux on Java and Spring WebFlux on Kotlin coroutines.  
Bonus: async app using Python and FastAPI.

## Applications
```GET /api/anime/{id}``` - get one anime by id from Jikan API and one random movie from Mflix database  
```GET /api/movies?count={n}``` - get N (0 < N ≤ 25) random movies

## Docker Compose
To start all these apps I use Docker Compose. There is common MongoDB image for all these apps and mongo-import image to preload data

## Slides
[Click](https://github.com/bee-joo/spring-boot-vs-webflux/blob/main/slides.pdf) (RUS)
