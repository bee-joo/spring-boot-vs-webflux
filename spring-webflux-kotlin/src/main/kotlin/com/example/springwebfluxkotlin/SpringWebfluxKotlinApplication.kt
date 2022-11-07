package com.example.springwebfluxkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
class SpringWebfluxKotlinApplication {

    @Bean
    fun webClient() = WebClient.create()
}

fun main(args: Array<String>) {
    runApplication<SpringWebfluxKotlinApplication>(*args)
}

