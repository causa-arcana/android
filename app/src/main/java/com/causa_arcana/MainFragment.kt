package com.causa_arcana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articlesListRecyclerView: RecyclerView =
            view.findViewById(R.id.fragment_main__articles_list_rv)
        articlesListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        articlesListRecyclerView.adapter = ArticlesListRecyclerViewAdapter {
            onArticleCardsListItemClick()
        }
    }

    private fun onArticleCardsListItemClick() {
        findNavController().navigate(R.id.action_open_article)
    }
}
