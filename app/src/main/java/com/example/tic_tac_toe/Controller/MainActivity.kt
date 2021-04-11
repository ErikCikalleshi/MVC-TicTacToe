package com.example.tic_tac_toe.Controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.View.Interface

class MainActivity : AppCompatActivity(), Interface.AddListener, Interface.WinnerShowListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPlayerClicked(index: Int) {
        TODO("Not yet implemented")
    }

    override fun onWinShow(player: String) {
        TODO("Not yet implemented")
    }

}