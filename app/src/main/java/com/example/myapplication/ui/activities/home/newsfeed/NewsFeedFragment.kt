package com.example.myapplication.ui.activities.home.newsfeed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.ui.activities.detail.DetailActivity
import com.example.myapplication.ui.adapler.DifferentAdapter
import com.example.myapplication.ui.adapler.NewsFeedViewHolderFactory
import kotlinx.android.synthetic.main.item_row_gallery.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewsFeedFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFeedFragment()
    }

    private val adapter = DifferentAdapter(
        viewHolderFactory = NewsFeedViewHolderFactory(
            onClickItem = {
                val intent = Intent(requireContext(), DetailActivity::class.java)
                startActivity(intent)
            },
            onClickDeleteItem = {
                viewModel.deleteItem(it)
            }

        )::create
    )

    private val viewModel: NewsFeedViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_feed_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observer()
        bindView()
        viewModel.getNewsFeeds()
    }

    private fun bindView() {
        rvItem.adapter = adapter
        rvItem.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val dividerItemDecoration = DividerItemDecoration(
            rvItem.context,
            LinearLayoutManager.VERTICAL
        )
        rvItem.addItemDecoration(dividerItemDecoration)
    }

    private fun observer() {
        viewModel.newsFeeds.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

}