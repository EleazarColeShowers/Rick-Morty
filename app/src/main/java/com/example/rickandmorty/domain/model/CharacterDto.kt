package com.example.rickandmorty.domain.model

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val origin: LocationDto,
    val location: LocationDto
)

data class LocationDto(val name: String)

data class CharacterListResponse(val results: List<CharacterDto>)

fun CharacterDto.toDomain() = CharacterDto(
    id = id,
    name = name,
    status = status,
    species = species,
    gender = gender,
    image = image,
    origin = origin,
    location = location,
    type = TODO()
)