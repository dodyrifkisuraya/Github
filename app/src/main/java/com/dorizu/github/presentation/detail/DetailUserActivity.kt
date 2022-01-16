package com.dorizu.github.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dorizu.github.core.data.ResultState
import com.dorizu.github.databinding.ActivityDetailUserBinding
import com.dorizu.github.domain.model.DetailUser
import com.dorizu.github.domain.model.RepositoryUser
import com.dorizu.github.presentation.adapter.RepoAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding
    private val detailUserViewModel: DetailUserViewModel by viewModels()

    private val repoAdapter = RepoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent.getStringExtra(USERNAME)?.let {
            detailUserViewModel.setSelectedUser(it)
        }

        detailUserViewModel.selectedUser.observe(this){
            showDetailUser(it)
        }
        detailUserViewModel.listRepoUser.observe(this){
            showRepoUser(it)
        }

        with(binding.rvRepository){
            layoutManager = LinearLayoutManager(context)
            adapter = repoAdapter
        }
    }

    private fun showRepoUser(it: ResultState<List<RepositoryUser>>?) {
        binding.apply {
            when(it){
                is ResultState.Success -> {
                    val data = it.data
                    repoAdapter.submitList(data)
                }
                is ResultState.Loading -> {

                }
            }
        }
    }

    private fun showDetailUser(it: ResultState<DetailUser>?) {
        binding.apply {
            when(it){
                is ResultState.Success -> {
                    val data = it.data
                    data?.let { user ->
                        Glide.with(baseContext)
                            .load(user.avatarUrl)
                            .into(ivProfileUser)
                        tvNameUser.text = user.name
                        tvUname.text = "@${user.username}"
                        tvMotto.text = user.bio
                    }
                }
                is ResultState.Loading -> {

                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        const val USERNAME = "uname"
    }
}