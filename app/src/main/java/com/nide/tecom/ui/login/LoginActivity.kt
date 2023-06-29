package com.nide.tecom.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.nide.tecom.core.ViewPagerAdapter
import com.nide.tecom.databinding.ActivityLoginBinding
import com.nide.tecom.ui.login.login.LoginFragment
import com.nide.tecom.ui.login.register.RegisterFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {


    lateinit var binding: ActivityLoginBinding

    private val fragments by lazy {
        listOf(
            "Login" to LoginFragment(),
            "Register" to RegisterFragment()
        )
    }


    private val viewPagerAdapter by lazy {
        ViewPagerAdapter(
            fragments.map { it.second },
            supportFragmentManager,
            lifecycle
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewPager.adapter = viewPagerAdapter
        }
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = fragments[position].first
        }.attach()


    }
}