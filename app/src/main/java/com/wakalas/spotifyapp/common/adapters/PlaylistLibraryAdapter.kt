package com.wakalas.spotifyapp.common.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.wakalas.spotifyapp.Application
import com.wakalas.spotifyapp.R
import com.wakalas.spotifyapp.common.entities.PlaylistEntity
import com.wakalas.spotifyapp.common.listeners.PlaylistListener
import com.wakalas.spotifyapp.databinding.ItemVerticalBinding

class PlaylistLibraryAdapter(private val listener: PlaylistListener):
    ListAdapter<PlaylistEntity, RecyclerView.ViewHolder>(PlaylistDiffCallback())
{
    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val binding = ItemVerticalBinding.bind(view)

        fun setListener(playlistEntity: PlaylistEntity)
        {
            binding.root.setOnClickListener {
                listener.onClick(playlistEntity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        context = parent.context

        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.item_vertical, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
    {
        val playlist = getItem(position)
        val images = Application.images

        with(holder as ViewHolder)
        {
            setListener(playlist)

            with(binding)
            {
                tvName.text = playlist.titulo
                tvNumeroCanciones.text = "${playlist.numeroCanciones} canciones"

                Glide.with(context)
                    .load(images[(images.indices).random()])
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(binding.ivImage)
            }
        }
    }

    class PlaylistDiffCallback(): DiffUtil.ItemCallback<PlaylistEntity>()
    {
        override fun areItemsTheSame(oldItem: PlaylistEntity, newItem: PlaylistEntity): Boolean
        {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PlaylistEntity, newItem: PlaylistEntity): Boolean
        {
            return oldItem == newItem
        }
    }
}
