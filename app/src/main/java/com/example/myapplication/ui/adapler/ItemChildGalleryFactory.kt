package com.example.myapplication.ui.adapler

import android.view.ViewGroup
import com.example.myapplication.databinding.ItemChildRowGelleryBinding
import com.example.myapplication.domain.model.Image
import com.example.myapplication.utils.bindImage
import com.example.myapplication.utils.get

class ItemChildGalleryFactory {
    fun create(parent: ViewGroup, viewType: Int): ChildGalleryViewHolder {
        return ChildGalleryViewHolder(
            binding = parent[ItemChildRowGelleryBinding::inflate]
        )
    }

    inner class ChildGalleryViewHolder(private val binding: ItemChildRowGelleryBinding) :
        BaseViewHolder<Image>(binding.root) {
        override fun bind(data: Image, position: Int) {
            binding.imgChildItem.bindImage(data.href)
        }
    }
}