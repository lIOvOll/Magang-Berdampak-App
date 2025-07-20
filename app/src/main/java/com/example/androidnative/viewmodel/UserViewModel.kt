package com.example.androidnative.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidnative.model.User
import com.example.androidnative.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    private var currentPage = 1
    private var totalPages = 1

    init {
        loadPage(currentPage)
    }

    private fun loadPage(page: Int) {
        _isRefreshing.value = true
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getUsers(page = page)
                totalPages = response.total_pages

                if (response.data.isNotEmpty()) {
                    _users.value = response.data
                    currentPage = page
                } else {
                    _users.value = emptyList()
                }

            } catch (e: Exception) {
                Log.e("UserViewModel", "Load failed: ${e.message}")
                _users.value = emptyList()
            } finally {
                _isRefreshing.value = false
            }
        }
    }

    fun nextPage() {
        if (currentPage >= totalPages) {
            _users.value = emptyList()
            return
        }
        loadPage(currentPage + 1)
    }
}