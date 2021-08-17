package com.causa_arcana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleCardsListRecyclerAdapter(private val onItemClick: () -> Unit) :
    RecyclerView.Adapter<ArticleCardsListRecyclerAdapter.ViewHolder>()
{
    private val articleCardsList = listOf(
        ArticleCard(
            ArticleId(2021u, 8u, 6u, "writing-about-it"),
            "Почему сложно писать о передовых информационных технологиях?",
            """
                Однажды мы выпустили статью “Децентрализованные сервисы против распределённых”, где
                предприняли попытку подтолкнуть читателей к более обдуманному отношению к терминам,
                таким как “централизованный”, “децентрализованный” и “распределённый”. Это имее...
            """.replace("\\s+".toRegex(), " "),
        ),
        ArticleCard(
            ArticleId(2020u, 6u, 4u, "decentralized-vs-distributed"),
            "Децентрализованные сервисы против распределённых",
            """
                Более правильная, но менее известная схема, показывающая разницу между
                централизованными, децентрализованными и распределёнными сетями. В данной статье я
                расскажу про два подхода к созданию сервисов, не зависящих от единственно...
            """.replace("\\s+".toRegex(), " "),
        ),
        ArticleCard(
            ArticleId(2021u, 7u, 28u, "yggdrasil"),
            "Заметки об Yggdrasil: качество кода, безопасность, DNS",
            """
                Сейчас сложно продвигать сеть Yggdrasil для массового использования. Она сложна для
                обычного пользователя, поскольку требует настройки. Она не даёт новых возможностей
                обхода наиболее часто применяемых механизмов государственных блокировок Интернет...
            """.replace("\\s+".toRegex(), " "),
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rvitem_article_card, parent, false),
        ) { onItemClick() }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val articleCard = articleCardsList[position]

        holder.titleTextView?.text   = articleCard.title
        holder.summaryTextView?.text = articleCard.summary
    }

    override fun getItemCount(): Int {
        return articleCardsList.size
    }

    class ViewHolder(itemView: View, private val onClick: () -> Unit):
        RecyclerView.ViewHolder(itemView)
    {
        var titleTextView: TextView? = null
        var summaryTextView: TextView? = null

        init {
            titleTextView   = itemView.findViewById(R.id.rvitem_article_card__title_text_view)
            summaryTextView = itemView.findViewById(R.id.rvitem_article_card__summary_text_view)

            itemView.setOnClickListener { onClick() }
        }
    }
}
