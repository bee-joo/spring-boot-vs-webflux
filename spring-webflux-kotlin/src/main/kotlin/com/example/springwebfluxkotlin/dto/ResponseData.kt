package com.example.springwebfluxkotlin.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ResponseData(@JsonProperty("data") var data: AnimeDto) {

    companion object AnimeDto {
        @get:JsonProperty("mal_id")
        var id: Int = 0

        @get:JsonProperty("title_english")
        var titleEnglish: String? = null

        @get:JsonProperty("title_japanese")
        var titleJapanese: String? = null

        @get:JsonProperty("title_synonyms")
        var titleSynonyms: List<String>? = null

        var title: String? = null
        var type: String? = null
        var source: String? = null
        var status: String? = null
        var duration: String? = null
        var synopsis: String? = null
        var url: String? = null
        var episodes: Int = 0
        var year: String = ""
        var airing = false
    }
}