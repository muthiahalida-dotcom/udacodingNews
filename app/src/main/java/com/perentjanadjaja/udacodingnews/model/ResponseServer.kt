package com.perentjanadjaja.udacodingnews.model

data class ResponseServer (
    var status : String? = null,
    var totalResults : Int? = null,
    var articles : ArrayList<News>? = null
)