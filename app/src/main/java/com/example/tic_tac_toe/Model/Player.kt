package com.example.tic_tac_toe.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity
data class Player(
        @PrimaryKey(autoGenerate = true)
        val id: Int? = null,
        @ColumnInfo(name = "name")
        val name: String ,
        val points: Int
)
