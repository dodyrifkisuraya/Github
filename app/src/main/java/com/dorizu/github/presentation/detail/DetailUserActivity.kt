package com.dorizu.github.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.dorizu.github.core.data.ResultState
import com.dorizu.github.databinding.ActivityDetailUserBinding
import com.dorizu.github.domain.model.DetailUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding
    private val detailUserViewModel: DetailUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra(USERNAME)?.let {
            detailUserViewModel.setSelectedUser(it)
        }

        detailUserViewModel.selectedUser.observe(this){
            setDetailUser(it)
        }
    }

    private fun setDetailUser(it: ResultState<DetailUser>?) {
        binding.apply {
            when(it){
                is ResultState.Success -> {
                    val data = it.data
                    data?.let { user ->
                        Glide.with(baseContext)
                            .load(user.avatarUrl)
                            .into(ivProfileUser)
                        tvNameUser.text = user.name
                        tvUname.text = user.username
                        tvMotto.text = user.bio
                    }
                }
                is ResultState.Loading -> {

                }
            }
        }
    }

    companion object{
        const val USERNAME = "uname"
    }
}