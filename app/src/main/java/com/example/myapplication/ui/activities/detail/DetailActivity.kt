package com.example.myapplication.ui.activities.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.domain.model.NewsFeed
import com.example.myapplication.utils.bindImage
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.myapplication.R.layout.activity_detail)

        bindView()
        observer()
        viewModel.getNewsFeed()
    }


    private fun observer() {
        viewModel.newsFeed.observe(this) {
            loadData(it)
        }
    }

    private fun loadData(item: NewsFeed) {
        imgBanner.bindImage(item.publisher?.icon, R.drawable.img_newsfeed_top_banner)
        tvTitle.text = item.title
        tvDesc.text = item.description
    }


    private fun bindView() {
        setupToolbar()
        imgBanner.bindImage()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}