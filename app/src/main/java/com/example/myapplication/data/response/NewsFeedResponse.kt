package com.example.myapplication.data.response

data class NewsFeedResponse(val items: List<NewsFeedDto>)

data class NewsFeedDto(
    val document_id: String? = null,
    val title: String? = null,
    val description: String? = null,
    val content_type: String? = null,
    val published_date: String? = null,
    val publisher: PublisherDto? = null,
    val origin_url: String? = null,
    val avatar: AvatarDto? = null,
    val images: List<ImageDto>? = null,
    val content: ContentDto? = null,
)

data class PublisherDto(
    val id: String? = null,
    val name: String? = null,
    val icon: String? = null
)

data class AvatarDto(
    val href: String? = null,
    val main_color: String? = null,
    val width: String? = null,
    val height: String? = null,
)

data class ImageDto(
    val href: String? = null,
    val main_color: String? = null,
    val width: String? = null,
    val height: String? = null,
)

data class ContentDto(
    val href: String? = null,
    val preview_image: ImageDto? = null,
    val duration: Long? = null,
    val caption: String? = null,
    )

