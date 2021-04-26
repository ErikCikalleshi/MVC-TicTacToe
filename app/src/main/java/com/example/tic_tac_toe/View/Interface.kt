package com.example.tic_tac_toe.View

interface Interface {

    interface OnClickedListener{
        fun onClicked(v: android.view.View)
    }

    interface OnRestartListener{
        fun restartView()
    }

    interface LoadBoard{
        fun loadBoard()
    }

}