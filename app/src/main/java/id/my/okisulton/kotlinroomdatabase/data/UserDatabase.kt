package id.my.okisulton.kotlinroomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.my.okisulton.kotlinroomdatabase.model.User

/**
 *Created by osalimi on 12-01-2021.
 **/
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun  getDatabase(context: Context): UserDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java, "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}