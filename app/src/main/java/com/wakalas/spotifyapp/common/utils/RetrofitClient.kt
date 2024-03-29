package com.wakalas.spotifyapp.common.utils

import com.wakalas.spotifyapp.common.database.AlbumService
import com.wakalas.spotifyapp.common.database.PlaylistService
import com.wakalas.spotifyapp.common.database.PodcastService
import com.wakalas.spotifyapp.common.database.SongService
import com.wakalas.spotifyapp.common.database.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient
{
    val albumService: AlbumService by lazy {
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AlbumService::class.java)
    }
    
    val playlistService: PlaylistService by lazy {
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlaylistService::class.java)
    }

    val podcastService: PodcastService by lazy {
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PodcastService::class.java)
    }

    val songService: SongService by lazy {
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SongService::class.java)
    }

    val userService: UserService by lazy {
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserService::class.java)
    }
}
