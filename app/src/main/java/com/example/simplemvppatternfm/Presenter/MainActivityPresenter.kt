package com.example.simplemvppatternfm.Presenter

import com.example.simplemvppatternfm.Model.GuessManagement
import com.example.simplemvppatternfm.Contract.MainactivityContract

class MainActivityPresenter(guessManagement: GuessManagement) :
    MainactivityContract.Presenter {

    lateinit var mView : MainactivityContract.View
    private var mGuessManagement =guessManagement



    override fun setView(view: MainactivityContract.View) {
        this.mView = view
    }

    override fun created() {
        this.mView.bindViews()
        this.mView.initClicks()

        this.prepareInitGuess()
    }

    private fun prepareInitGuess() {
        this.mGuessManagement.initGuessData()
    }

    override fun onBtnGuessClick(t: Int) {
        this.mView.afterControl(mGuessManagement.isSuccessGuess(t))
    }
}
