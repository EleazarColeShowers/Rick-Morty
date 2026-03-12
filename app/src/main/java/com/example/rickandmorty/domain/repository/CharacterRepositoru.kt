package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.domain.model.CharacterDto

interface CharacterRepository {
    suspend fun getCharacters(): Result<List<CharacterDto>>
    suspend fun getCharacter(id: Int): Result<CharacterDto>
}