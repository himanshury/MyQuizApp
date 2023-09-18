package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button =findViewById(R.id.start_btn)
        val name:EditText=findViewById(R.id.input_name)

        btn.setOnClickListener {

            if(name.text.isEmpty())
            {
                Toast.makeText(this,"Please enter name.",Toast.LENGTH_SHORT).show()
            }
            else
            {
                //Toast.makeText(this,"Name entered!!",Toast.LENGTH_SHORT).show()
                val intent= Intent(this,Questions::class.java)
                intent.putExtra(Constants.user_name,name.text.toString())

                startActivity(intent)
                finish()
            }
        }
    }
}