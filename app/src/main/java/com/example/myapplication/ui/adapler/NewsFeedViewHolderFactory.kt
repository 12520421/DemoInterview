package com.example.myapplication.ui.adapler

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemRowGalleryBinding
import com.example.myapplication.databinding.ItemRowNewsfeedOverviewBinding
import com.example.myapplication.databinding.ItemRowNewsfeedStoryBinding
import com.example.myapplication.domain.model.NewsFeed
import com.example.myapplication.utils.addDecorationItem
import com.example.myapplication.utils.bindImage
import com.example.myapplication.utils.get

class NewsFeedViewHolderFactory(
    private val onClickItem: (NewsFeed) -> Unit,
) {
    fun create(parent: ViewGroup, viewType: Int): ItemViewHolder<NewsFeed> {
        return when (viewType) {
            VIEW_TYPE_OVERVIEW -> OverviewViewHolder(
                binding = parent[ItemRowNewsfeedOverviewBinding::inflate]
            )
            VIEW_TYPE_STORY -> StoryViewHolder(
                binding = parent[ItemRowNewsfeedStoryBinding::inflate]
            )
            VIEW_TYPE_GALLERY -> GalleryViewHolder(
                binding = parent[ItemRowGalleryBinding::inflate]
            )
            VIEW_TYPE_VIDEO -> GalleryViewHolder(
                binding = parent[ItemRowGalleryBinding::inflate]
            )
            VIEW_TYPE_ARTICLE -> GalleryViewHolder(
                binding = parent[ItemRowGalleryBinding::inflate]
            )
            VIEW_TYPE_LONG_FORM -> GalleryViewHolder(
                binding = parent[ItemRowGalleryBinding::inflate]
            )


            else -> error("Does not support type $viewType")
        }
    }

    abstract class ItemViewHolder<D : NewsFeed>(itemView: View) : BaseViewHolder<D>(itemView)

    inner class OverviewViewHolder(private val binding: ItemRowNewsfeedOverviewBinding) :
        ItemViewHolder<NewsFeed>(binding.root) {
        override fun bind(data: NewsFeed, position: Int) {
            binding.imgContent.bindImage(data.publisher?.icon, R.drawable.img_newsfeed_top_banner)
            binding.tvDate.text = data.published_date
            itemView.setOnClickListener {
                onClickItem.invoke(data)
            }
        }
    }

    inner class StoryViewHolder(private val binding: ItemRowNewsfeedStoryBinding) :
        ItemViewHolder<NewsFeed>(binding.root) {
        override fun bind(data: NewsFeed, position: Int) {
            binding.ivContent.bindImage(data.avatar?.href)
            binding.tvDate.text = data.published_date
            binding.tvTitle.text = data.title
            itemView.setOnClickListener {
                onClickItem.invoke(data)
            }
        }
    }

    inner class GalleryViewHolder(private val binding: ItemRowGalleryBinding) :
        ItemViewHolder<NewsFeed>(binding.root) {
        override fun bind(data: NewsFeed, position: Int) {
            binding.tvDate.text = data.published_date
            binding.tvTitle.text = data.title

            if (data.images.isNullOrEmpty()) {
                binding.rvItem.visibility = View.GONE
            } else {
                binding.rvItem.visibility = View.VISIBLE

                val adapter = DifferentAdapter(
                    viewHolderFactory = ItemChildGalleryFactory()::create
                )
                binding.rvItem.adapter = adapter
                binding.rvItem.layoutManager = GridLayoutManager(
                    binding.rvItem.context,
                    3,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                binding.rvItem.addDecorationItem(8)

                adapter.submitList(data.images.take(3))
            }

            itemView.setOnClickListener {
                onClickItem.invoke(data)
            }
        }
    }

    companion object {
        const val VIEW_TYPE_OVERVIEW = 1
        const val VIEW_TYPE_STORY = 2
        const val VIEW_TYPE_GALLERY = 3
        const val VIEW_TYPE_VIDEO = 4
        const val VIEW_TYPE_ARTICLE = 5
        const val VIEW_TYPE_LONG_FORM = 6
    }
}