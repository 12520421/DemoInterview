package com.example.data.mapper

import com.example.data.response.NewsFeedDto
import com.example.domain.model.NewsFeed
import com.example.domain.model.Publisher

interface NewsFeedMapper {
    fun toNewsFeed(items: List<NewsFeedDto>): List<NewsFeed>
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
                )
            )
        }
    }

}