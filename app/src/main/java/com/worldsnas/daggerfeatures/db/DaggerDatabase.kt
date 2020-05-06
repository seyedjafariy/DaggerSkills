package com.worldsnas.daggerfeatures.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.worldsnas.daggerfeatures.model.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class DaggerDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

}