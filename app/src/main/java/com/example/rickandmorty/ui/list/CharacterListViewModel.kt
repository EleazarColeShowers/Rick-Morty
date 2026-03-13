package com.example.rickandmorty.ui.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.model.Character
import com.example.rickandmorty.domain.repository.CharacterRepository
import com.example.rickandmorty.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    var uiState by mutableStateOf<UiState<List<Character>>>(UiState.Loading)
        private set

    var searchQuery by mutableStateOf("")
        private set

    private var allCharacters: List<Character> = emptyList()

    init { getCharacters() }

    fun getCharacters() {
        viewModelScope.launch {
            uiState = UiState.Loading
            repository.getCharacters()
                .onSuccess {
                    allCharacters = it
                    uiState = UiState.Success(it)
                }
                .onFailure {
                    uiState = UiState.Error(it.message ?: "Something went wrong")
                }
        }
    }

    fun onSearchQueryChange(query: String) {
        searchQuery = query
        uiState = if (query.isBlank()) {
            UiState.Success(allCharacters)
        } else {
            UiState.Success(
                allCharacters.filter { it.name.contains(query, ignoreCase = true) }
            )
        }
    }
}