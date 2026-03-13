package com.example.rickandmorty.data.remote

import com.example.rickandmorty.domain.model.CharacterDto
import com.example.rickandmorty.domain.model.CharacterListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(): CharacterListResponse

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterDto
}