package com.example.myapplication.data.mapper

import com.example.myapplication.data.response.DetailNewsFeedResponse
import com.example.myapplication.data.response.NewsFeedDto
import com.example.myapplication.domain.model.Avatar
import com.example.myapplication.domain.model.Image
import com.example.myapplication.domain.model.NewsFeed
import com.example.myapplication.domain.model.Publisher

interface NewsFeedMapper {
    fun toNewsFeed(items: List<NewsFeedDto>): List<NewsFeed>
    fun toDetailNewsFeed(item: DetailNewsFeedResponse): NewsFeed
}

open class NewsFeedMapperImpl() : NewsFeedMapper {
    override fun toNewsFeed(items: List<NewsFeedDto>): List<NewsFeed> {
        return items.map {
            NewsFeed(
                document_id = it.document_id,
                title = it.title,
                description = it.description,
                content_type = it.content_type,
                published_date = it.published_date,
                publisher = Publisher(
                    id = it.publisher?.id,
                    name = it.publisher?.name,
                    icon = it.publisher?.icon
                ),
                avatar = Avatar(
                    href = it.avatar?.href,
                    main_color = it.avatar?.main_color,
                    width = it.avatar?.width,
                    height = it.avatar?.height,
                ),
                images = it.images?.map { imageDto ->
                    Image(
                        href = imageDto.href,
                        main_color = imageDto.main_color,
                        width = imageDto.width,
                        height = imageDto.height,
                    )
                },
                type = when (it.content_type) {
                    TYPE_OVERVIEW -> 1
                    TYPE_STORY -> 2
                    TYPE_GALLERY -> 3
                    TYPE_VIDEO -> 4
                    TYPE_ARTICLE -> 5
                    TYPE_LONG_FORM -> 6
                    else -> 0
                }
            )
        }
    }

    override fun toDetailNewsFeed(item: DetailNewsFeedResponse): NewsFeed {
        return NewsFeed(
            document_id = item.document_id,
            title = item.title,
            description = item.description,
            content_type = item.template_type,
            published_date = item.published_date,
            publisher = Publisher(
                id = item.publisher?.id,
                name = item.publisher?.name,
                icon = item.publisher?.icon,
            ),
            avatar = null,
            images = null,
            type = 0
        )
    }

    companion object {
        const val TYPE_OVERVIEW = "overview"
        const val TYPE_STORY = "story"
        const val TYPE_GALLERY = "gallery"
        const val TYPE_VIDEO = "video"
        const val TYPE_ARTICLE = "article"
        const val TYPE_LONG_FORM = "long_form"
    }

}