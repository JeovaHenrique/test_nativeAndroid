package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloword.models.Repo
import com.example.helloword.reposlist.ReposAdapter


class MainActivity : AppCompatActivity() {

    private val adapter = ReposAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: RecyclerView = findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        val sampleData = listOf(
            Repo("Repo 1"),
            Repo("Repo 2"),
            Repo("Repo 3"),
            Repo("Repo 4"),
            Repo("Repo 5"),
            Repo("Repo 6"),
            Repo("Repo 7"),
            Repo("Repo 8"),
            Repo("Repo 9"),
            Repo("Repo 10")
        )

        adapter.submitList(sampleData)
    }
}