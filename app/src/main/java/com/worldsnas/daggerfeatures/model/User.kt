package com.worldsnas.daggerfeatures.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(
    tableName = "user"
)
data class User(
    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    val id: Long,
    @ColumnInfo(name = "first_name")
    @Json(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    @Json(name = "last_name")
    val lastName: String
)