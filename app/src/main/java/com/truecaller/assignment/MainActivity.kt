package com.truecaller.assignment

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.truecaller.assignment.viewmodel.TrueCallerViewModel
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var movieDetailViewModel: TrueCallerViewModel
    private lateinit var util: Utility

    private lateinit var tenthCharTV: TextView
    private lateinit var everyTenthCharTV: TextView
    private lateinit var wordCounterTV: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        tenthCharTV = findViewById(R.id.tenthCharTV)
        everyTenthCharTV = findViewById(R.id.everyTenthCharTV)
        wordCounterTV = findViewById(R.id.wordCounterTV)
        movieDetailViewModel = ViewModelProviders.of(this).get(TrueCallerViewModel::class.java)
        movieDetailViewModel.init()

        util = Utility();

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            truecaller10thCharacterRequest()
            truecallerEvery10thCharacterRequest()
            truecallerWordCounterRequest()

        }

    }


    private fun truecaller10thCharacterRequest() {


        movieDetailViewModel.truecaller10thCharacterRequest?.observe(this, Observer<StringBuilder> { stringBuilder ->
            if (stringBuilder != null) {

                tenthCharTV.text = "10Character:" + util.truecaller10thCharacterRequest(stringBuilder).toString()


            }
        })
    }

    private fun truecallerEvery10thCharacterRequest() {


        movieDetailViewModel.truecallerEvery10thCharacterRequest?.observe(this, Observer<StringBuilder> { stringBuilder ->
            if (stringBuilder != null) {

                everyTenthCharTV.text = "Every10thCharacter:" + util.truecallerEvery10thCharacterRequest(stringBuilder).toString()


            }
        })
    }

    private fun truecallerWordCounterRequest() {


        movieDetailViewModel.truecallerWordCounterRequest?.observe(this, Observer<StringBuilder> { stringBuilder ->
            if (stringBuilder != null) {


                wordCounterTV.text = "WordCounter:" + util.calculateWordCount(stringBuilder).toString()

            }
        })
    }


}
