package com.example.simplemvppatternfm.Model

class GuessManagement() {

    private var chosenNumber:Int = 0
    private lateinit var allNumber:ArrayList<Int>

    fun initGuessData() {
        allNumber=arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        chosenNumber = allNumber.random()
        println("chosenNumber  : $chosenNumber")
    }
    fun isSuccessGuess(guess:Int):Boolean{
        return guess == chosenNumber
    }
}