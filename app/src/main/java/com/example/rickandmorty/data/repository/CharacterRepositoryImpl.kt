package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.remote.RickAndMortyApi
import com.example.rickandmorty.domain.model.Character
import com.example.rickandmorty.domain.model.toDomain
import com.example.rickandmorty.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : CharacterRepository {

    override suspend fun getCharacters(): Result<List<Character>> = runCatching {
        api.getCharacters().results.map { it.toDomain() }
    }

    override suspend fun getCharacter(id: Int): Result<Character> = runCatching {
        api.getCharacter(id).toDomain()
    }
}