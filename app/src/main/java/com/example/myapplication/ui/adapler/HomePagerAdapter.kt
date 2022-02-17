package com.example.myapplication.ui.adapler

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ui.activities.home.newsfeed.NewsFeedFragment
import com.example.myapplication.ui.activities.home.sport.SportFragment

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> NewsFeedFragment.newInstance()
            1 -> SportFragment.newInstance()
            else -> throw IllegalArgumentException()
        }
    }
}