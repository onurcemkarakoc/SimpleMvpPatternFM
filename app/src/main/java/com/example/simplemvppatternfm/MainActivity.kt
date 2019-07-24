package com.example.simplemvppatternfm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.simplemvppatternfm.Contract.MainactivityContract
import com.example.simplemvppatternfm.Model.GuessManagement
import com.example.simplemvppatternfm.Presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainactivityContract.View {


    private lateinit var edt_guess: EditText
    private lateinit var btn_guess: Button
    private lateinit var img_guess: ImageView

    private lateinit var mPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessManagement = GuessManagement()

        mPresenter= MainActivityPresenter(guessManagement)
        mPresenter.setView(this)
        mPresenter.created()

    }

    override fun bindViews() {
        edt_guess=findViewById(R.id.edt_guess)
        btn_guess=findViewById(R.id.btn_guess)
        img_guess=findViewById(R.id.img_guess)
    }

    override fun initClicks() {
        btn_guess.setOnClickListener {
            mPresenter.onBtnGuessClick(edt_guess.text.toString().toInt())
        }
    }

    override fun afterControl(succesGuess: Boolean) {
        val imgResource: Int = if (succesGuess) R.drawable.ic_check else R.drawable.ic_false

        img_guess.setImageResource(imgResource)
    }
}
