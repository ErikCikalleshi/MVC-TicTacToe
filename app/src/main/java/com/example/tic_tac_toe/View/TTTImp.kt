package com.example.tic_tac_toe.View

import android.view.LayoutInflater

class TTTImp (layoutInflater: LayoutInflater): Interface.AddListener, Interface.WinnerShowListener {
    private var myRootView = layoutInflater


    override fun onPlayerClicked(index: Int) {
        TODO("Not yet implemented")
    }

    override fun onWinShow(player: String) {
        TODO("Not yet implemented")
    }
}