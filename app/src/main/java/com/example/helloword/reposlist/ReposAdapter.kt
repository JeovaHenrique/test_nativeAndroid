package com.example.helloword.reposlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.helloword.R
import com.example.helloword.models.Repo

class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val name : TextView = view.findViewById(R.id.name1)

    fun bind(repo: Repo) {
        name.text = repo.name
    }
}

val diffCallBack = object : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem.equals(newItem)
    }

}

class ReposAdapter(private val repoClickHandler: (Repo) -> Unit) : ListAdapter<Repo, RepoViewHolder>(diffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            repoClickHandler(getItem(position))
        }
    }

}