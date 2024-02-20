package com.wakalas.spotifyapp.common.database

import com.wakalas.spotifyapp.common.entities.UserEntity
import com.wakalas.spotifyapp.common.utils.Constants
import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService
{
    @Headers("Content-Type: application/json")
    @POST(Constants.USUARIOS_PATH)
    suspend fun postUser(): Response<UserEntity>
}