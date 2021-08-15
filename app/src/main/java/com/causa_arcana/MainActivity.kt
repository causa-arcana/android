package com.causa_arcana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val articlesListRecyclerView: RecyclerView =
            findViewById(R.id.activity_main__articles_list_rv)
        articlesListRecyclerView.layoutManager = LinearLayoutManager(this)
        articlesListRecyclerView.adapter = ArticlesListRecyclerViewAdapter {
            onArticlesListItemClick()
        }
    }

    private fun onArticlesListItemClick() {
        val intent = Intent(this, ArticleActivity::class.java)
        startActivity(intent)
    }
}
