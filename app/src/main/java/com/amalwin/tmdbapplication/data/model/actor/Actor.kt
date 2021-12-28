package com.amalwin.tmdbapplication.data.model.actor

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "actor_table")
data class Actor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "actor_id")
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    @ColumnInfo(name = "actor_name")
    val name: String?,

    @SerializedName("popularity")
    @ColumnInfo(name = "actor_popularity")
    val popularity: Double?,

    @SerializedName("profile_path")
    @ColumnInfo(name = "actor_profile_path")
    val profilePath: String?
)