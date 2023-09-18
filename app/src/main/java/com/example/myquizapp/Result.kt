package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView




class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_name:TextView=findViewById(R.id.tv_name)
        val tv_score:TextView=findViewById(R.id.tv_score)
        val submit_btn:Button=findViewById(R.id.submit_btn)

        tv_name.text=intent.getStringExtra(Constants.user_name)

        val tot_que= intent.getIntExtra(Constants.tot_que,0)
        val correct_que=intent.getIntExtra(Constants.correct_que,0)

        tv_score.text="Your score is $correct_que / $tot_que"

        submit_btn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}