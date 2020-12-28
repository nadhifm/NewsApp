package com.nadhif.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nadhif.core.R
import com.nadhif.core.databinding.ItemArticleBinding
import com.nadhif.core.domain.model.Article

class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private var listData = ArrayList<Article>()
    var onItemClick: ((Article) -> Unit)? = null

    fun setData(newListData: List<Article>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder = ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false))

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemArticleBinding.bind(itemView)
        fun bind(data: Article) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.urlToImage)
                    .into(ivArticleImage)
                tvTitle.text = data.title
                tvPublishedAt.text = data.publishedAt
                tvSource.text = data.source.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}