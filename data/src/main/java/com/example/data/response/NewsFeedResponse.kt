package com.example.data.response

data class NewsFeedResponse(val items: List<NewsFeedDto>)

data class NewsFeedDto(
    val document_id: String? = null,
    val title: String? = null,
    val description: String? = null,
    val content_type: String? = null,
    val published_date: String? = null,
    val publisher: PublisherDto? = null,
    val origin_url: String? = null,
    val avatar: String? = null,
    val images: String? = null,
    val content: String? = null,
)

data class PublisherDto(
    val id: String? = null,
    val name: String? = null,
    val icon: String? = null
)

