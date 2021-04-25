package com.example.tic_tac_toe.Model

import androidx.room.Database
import androidx.room.RoomDatabase

//receives a list of entities where annotated with @Entity
@Database(entities = [Player::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun playerDao(): PlayerDao
}