package com.dorizu.github.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.dorizu.github.core.data.ResultState
import com.dorizu.github.databinding.ActivityMainBinding
import com.dorizu.github.presentation.adapter.UserAdapter
import com.dorizu.github.presentation.detail.DetailUserActivity
import com.dorizu.github.presentation.detail.DetailUserActivity.Companion.USERNAME
import com.dorizu.github.utils.toGone
import com.dorizu.github.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    private val userAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter.onItemClick = {
            val intent = Intent(this, DetailUserActivity::class.java)
            intent.putExtra(USERNAME, it.login)
            startActivity(intent)
        }

        mainViewModel.resultSearchUser.observe(this){
            when(it){
                is ResultState.Success -> {
                    userAdapter.submitList(it.data)
                    binding.pbSearch.toGone()
                }
                is ResultState.Loading -> {
                    binding.pbSearch.toVisible()
                }
            }
        }

        setViewFunction()
    }

    private fun setViewFunction() {
        binding.apply {
            svUser.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    mainViewModel.searchUser(query)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })

            with(rvUser){
                layoutManager = LinearLayoutManager(context)
                adapter = userAdapter
            }
        }
    }
}