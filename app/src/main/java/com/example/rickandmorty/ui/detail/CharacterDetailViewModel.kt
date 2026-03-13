package com.example.rickandmorty.ui.detail

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
class CharacterDetailViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    var uiState by mutableStateOf<UiState<Character>>(UiState.Loading)
        private set

    fun getCharacter(id: Int) {
        viewModelScope.launch {
            uiState = UiState.Loading
            repository.getCharacter(id)
                .onSuccess { uiState = UiState.Success(it) }
                .onFailure { uiState = UiState.Error(it.message ?: "Something went wrong") }
        }
    }
}