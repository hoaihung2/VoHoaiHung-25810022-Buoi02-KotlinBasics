package edu.hcmute.bookshelf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BooksUiState {
    data object Loading : BooksUiState
    data class Success(val books: List<Book>) : BooksUiState
    data object Error : BooksUiState
}

class BooksViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<BooksUiState>(BooksUiState.Loading)
    val uiState: StateFlow<BooksUiState> = _uiState.asStateFlow()

    private var lastQuery = "jazz"

    init { search(lastQuery) }

    fun search(query: String) {
        if (query.isBlank()) return
        lastQuery = query.trim()
        viewModelScope.launch {
            _uiState.value = BooksUiState.Loading
            _uiState.value = try {
                BooksUiState.Success(booksRepository.searchBooks(lastQuery))
            } catch (e: IOException) {
                android.util.Log.e("Bookshelf", "Network error", e)
                BooksUiState.Error
            } catch (e: HttpException) {
                android.util.Log.e("Bookshelf", "HTTP error ${e.code()}", e)
                BooksUiState.Error
            }
        }
    }

    fun retry() = search(lastQuery)

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as BookshelfApplication
                BooksViewModel(application.container.booksRepository)
            }
        }
    }
}