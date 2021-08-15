package com.causa_arcana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticlesListRecyclerViewAdapter:
    RecyclerView.Adapter<ArticlesListRecyclerViewAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rvitem_article_card, parent, false),
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView?.text = when (position) {
            0 -> "Foo"
            1 -> "Bar"
            2 -> "Car"
            else -> null
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView? = null

        init {
            titleTextView = itemView.findViewById(R.id.rvitem_article_card__title_text_view)
        }
    }
}
