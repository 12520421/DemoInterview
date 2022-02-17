package com.example.myapplication.domain.model

import com.example.myapplication.model.ItemDifferent
import com.example.myapplication.model.SimpleItem

data class NewsFeed(
    val document_id: String? = null,
    val title: String? = null,
    val description: String? = null,
    val content_type: String? = null,
    val published_date: String? = null,
    val publisher: Publisher? = null,
    val avatar: Avatar? = null,
    val images: List<Image>? = null,
    override val type: Int,
) : ItemDifferent

data class Publisher(
    val id: String? = null,
    val name: String? = null,
    val icon: String? = null
)


data class Avatar(
    val href: String? = null,
    val main_color: String? = null,
    val width: String? = null,
    val height: String? = null,
)

data class Image(
    val href: String? = null,
    val main_color: String? = null,
    val width: String? = null,
    val height: String? = null,
) : SimpleItem()