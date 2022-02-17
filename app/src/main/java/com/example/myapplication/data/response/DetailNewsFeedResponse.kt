package com.example.myapplication.data.response

data class DetailNewsFeedResponse(
    val document_id: String? = null,
    val title: String? = null,
    val description: String? = null,
    val published_date: String? = null,
    val origin_url: String? = null,
    val publisher: PublisherDto? = null,
    val template_type: String? = null,
    val sections: List<SectionDto>? = null,
)

data class SectionDto(
    val section_type: String? = null,
    val content: ContentDto? = null,
)

