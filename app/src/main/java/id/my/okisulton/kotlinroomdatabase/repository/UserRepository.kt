package id.my.okisulton.kotlinroomdatabase.repository

import androidx.lifecycle.LiveData
import id.my.okisulton.kotlinroomdatabase.data.UserDao
import id.my.okisulton.kotlinroomdatabase.model.User

/**
 *Created by osalimi on 12-01-2021.
 **/
class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun adduser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateuser(user: User){
        userDao.updateUser(user)
    }

    suspend fun deleteusr(user: User){
        userDao.deleteUser(user)
    }

    suspend fun deletealluser(){
        userDao.deleteAllUser()
    }
}