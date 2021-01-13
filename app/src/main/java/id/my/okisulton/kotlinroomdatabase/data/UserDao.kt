package id.my.okisulton.kotlinroomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import id.my.okisulton.kotlinroomdatabase.model.User

/**
 *Created by osalimi on 12-01-2021.
 **/
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUser()

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun  readAllData(): LiveData<List<User>>
}