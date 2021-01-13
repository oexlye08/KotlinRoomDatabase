package id.my.okisulton.kotlinroomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import id.my.okisulton.kotlinroomdatabase.data.UserDatabase
import id.my.okisulton.kotlinroomdatabase.repository.UserRepository
import id.my.okisulton.kotlinroomdatabase.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *Created by osalimi on 12-01-2021.
 **/
class UserViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun adduser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.adduser(user)
        }
    }

    fun updateuser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateuser(user)
        }
    }

    fun deleteuser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteusr(user)
        }
    }

    fun deletealluser(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deletealluser()
        }
    }
}