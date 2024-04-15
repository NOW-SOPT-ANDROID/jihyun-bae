package com.sopt.now.feature.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.sopt.now.coreui.base.BindingActivity
import com.sopt.now.feature.R
import com.sopt.now.feature.databinding.ActivityMainBinding
import com.sopt.now.feature.ui.main.home.HomeFragment
import com.sopt.now.feature.ui.main.list.ListFragment
import com.sopt.now.feature.ui.main.mypage.MyPageFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        initBnvMainItemSelectedListener()
    }

    private fun initLayout() {
        supportFragmentManager.findFragmentById(R.id.fcv_main) ?: navigateToFragment<HomeFragment>()
    }

    private fun initBnvMainItemSelectedListener() {
        binding.bnvMain.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                org.sopt.now.designsystem.R.id.menu_home -> navigateToFragment<HomeFragment>()
                org.sopt.now.designsystem.R.id.menu_list -> navigateToFragment<ListFragment>()
                org.sopt.now.designsystem.R.id.menu_my_page -> navigateToFragment<MyPageFragment>()
            }
            true
        }
    }

    private inline fun <reified T : Fragment> navigateToFragment() {
        if (supportFragmentManager.findFragmentById(R.id.fcv_main) !is T) {
            supportFragmentManager.commit {
                replace<T>(R.id.fcv_main, T::class.java.canonicalName)
            }
        }
    }
}