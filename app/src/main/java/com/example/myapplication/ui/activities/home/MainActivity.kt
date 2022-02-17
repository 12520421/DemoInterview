package com.example.myapplication.ui.activities.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.ui.activities.home.account.AccountFragment
import com.example.myapplication.ui.activities.home.hometab.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView() {
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val homeFragment = HomeFragment.newInstance()
        val accountFragment = AccountFragment.newInstance()

        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.account -> setCurrentFragment(accountFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }


}