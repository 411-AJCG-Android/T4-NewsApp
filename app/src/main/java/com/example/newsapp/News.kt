package com.example.newsapp

data class News(
    val title: String,
    val image: Int
)

val newsList = listOf(
    News("El presidente de EE.UU. no muestra signos de arrepentimiento...", R.drawable.trump),
    News("Bañarse en la piscina del desierto de Cleopatra", R.drawable.cleopatra),
    News("Gigantes tecnológicos", R.drawable.ia),
    News("El rover de Marte envía", R.drawable.marte)
)


