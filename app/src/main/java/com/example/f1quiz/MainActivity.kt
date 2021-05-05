package com.example.f1quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Edit text has to be checked if it is empty the user has to be informed,
        however if it is not empty it has to be intent which move us over to other activity.and finish this one
         */


        button.setOnClickListener {
            if(textView.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else{
                val intent = Intent(this,QuestionsActivity::class.java)

                intent.putExtra(Constants.USER_NAME,textView.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}