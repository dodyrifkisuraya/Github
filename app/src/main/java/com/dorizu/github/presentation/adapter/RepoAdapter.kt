package com.dorizu.github.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dorizu.github.databinding.ListRepositoryBinding
import com.dorizu.github.domain.model.RepositoryUser

class RepoAdapter: ListAdapter<RepositoryUser, RepoAdapter.ViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: ListRepositoryBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(item: RepositoryUser){
            binding.apply {
                tvNameRepository.text = item.name
                tvDescRepository.text = item.description
                tvStarSum.text = item.stargazersCount.toString()
                tvLatestUpdateRepository.text = item.updatedAt
            }
        }
    }

    object DiffUtilCallback:DiffUtil.ItemCallback<RepositoryUser>() {
        override fun areItemsTheSame(oldItem: RepositoryUser, newItem: RepositoryUser): Boolean {
            return oldItem.name == newItem.name
        }
        override fun areContentsTheSame(oldItem: RepositoryUser, newItem: RepositoryUser): Boolean {
            return oldItem == newItem
        }
    }
}