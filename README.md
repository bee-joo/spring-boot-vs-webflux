# spring-boot-vs-webflux

#### University project  
Comparison between classic MVC and reactive Spring stack. Talking about asynchronous and reactive programming and comparing Spring MVC, Spring WebFlux on Java and Spring WebFlux on Kotlin coroutines.  
Bonus: async app using Python and FastAPI.

## Application
```GET /api/anime/{id}``` - get one anime by id from Jikan API and one random movie from Mflix database  
```GET /api/movies?count={n}``` - get N (0 < N ≤ 25) random movies

## Projects
* [spring-boot-java](https://github.com/bee-joo/spring-boot-vs-webflux/tree/main/spring-boot-java) - classic servlet MVC app  
* [spring-webflux-java](https://github.com/bee-joo/spring-boot-vs-webflux/tree/main/spring-webflux-java) - reactive WebFlux app
* [spring-webflux-kotlin](https://github.com/bee-joo/spring-boot-vs-webflux/tree/main/spring-webflux-kotlin) - reactive Kotlin coroutine app
* [python-async](https://github.com/bee-joo/spring-boot-vs-webflux/tree/main/python-async) - async Python analogue

## Docker Compose
To start all these apps I use Docker Compose. There is common MongoDB image for all these apps and mongo-import image to preload data. Mongo import image uses bash script to load all the data to DB. And there is bash script to build all the Spring projects and start Docker Compose

## Slides
[Click](https://github.com/bee-joo/spring-boot-vs-webflux/blob/main/slides.pdf) (RUS)
