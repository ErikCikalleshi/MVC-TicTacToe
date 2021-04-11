package com.example.tic_tac_toe.View

interface Interface {

    interface AddListener{
        fun onPlayerClicked(index: Int)
    }

    interface WinnerShowListener{
        fun onWinShow(player : String);
    }

}