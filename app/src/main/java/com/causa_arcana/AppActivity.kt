package com.causa_arcana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.activity_main__frame, MainFragment() {
            onArticlesListItemClick()
        })
        fragmentTransaction.commit()
    }

    fun onArticlesListItemClick() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.activity_main__frame, ArticleFragment())
        fragmentTransaction.commit()
    }
}
