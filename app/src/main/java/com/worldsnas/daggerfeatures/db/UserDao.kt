package com.worldsnas.daggerfeatures.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.worldsnas.daggerfeatures.model.User

@Dao
interface UserDao{

    @Insert
    fun insert(user : User)

    @Query("SELECT * FROM user")
    fun allUsers() : LiveData<List<User>>
}