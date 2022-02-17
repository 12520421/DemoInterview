package com.example.domain.model

data class NewsFeed(
    val document_id: String? = null,
    val title: String? = null,
    val description: String? = null,
    val content_type: String? = null,
    val published_date: String? = null,
    val publisher: Publisher? = null,
)

data class Publisher(
    val id: String? = null,
    val name: String? = null,
    val icon: String? = null
)