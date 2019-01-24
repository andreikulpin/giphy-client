package com.example.giphy_client.trending.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.giphy_client.R
import com.example.giphy_client.trending.presenter.GifListItem
import kotlinx.android.synthetic.main.item_gif.view.*

class GifsAdapter : RecyclerView.Adapter<GifsAdapter.GifViewHolder>() {
    private val items: MutableList<GifListItem> = ArrayList()
    private var listener: IEventListener? = null

    fun setItems(items: List<GifListItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<GifListItem>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setListener(listener: IEventListener) {
        this.listener = listener
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GifViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_gif, parent, false)
    )

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class GifViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(gif: GifListItem) {
            itemView.apply {
                titleView.text = gif.title

                Glide.with(context)
                    .asBitmap()
                    .load(gif.url)
                    .into(imageView)

                setOnClickListener {

                }
            }
        }
    }

    interface IEventListener {
        fun onItemClick(id: String)
    }
}