package com.example.tic_tac_toe.Model

import androidx.room.*

//Data Access Object
@Dao
interface PlayerDao {
    @Query("INSERT INTO Player(name, points) values(:n,:p)")
    fun insertPlayer(n: String, p: Int)


    @Query("UPDATE Player SET points = :p where name == :n")
    fun updatePlayerPoints(n: String, p: Int)

    @Query("SELECT name FROM Player WHERE name == :name")
    fun getPlayerByName(name: String): String

    @Query("SELECT points FROM Player WHERE name == :name")
    fun getPlayersPoint(name: String): Int
}