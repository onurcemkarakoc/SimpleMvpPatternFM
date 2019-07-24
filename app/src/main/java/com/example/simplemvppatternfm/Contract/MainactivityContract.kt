package com.example.simplemvppatternfm.Contract

interface MainactivityContract {

    interface View {
        fun bindViews()
        fun initClicks()
        fun afterControl(succesGuess: Boolean)

    }

    interface Presenter {
        fun setView(view: View)
        fun created()
        fun onBtnGuessClick(t: Int)


    }
}