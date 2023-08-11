package com.example.myapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var textView1 =findViewById<TextView>(R.id.homeIdTextView)
        var imageView1 =findViewById<ImageView>(R.id.homeImageView)
        var exitBtn = findViewById<Button>(R.id.exitBtn)
        textView1.text = "아이디 : " + intent.getStringExtra("id")



        var num1= Random.nextInt(5)
        var imgnum : Int = when(num1){
            0 ->R.drawable.test1
            1 ->R.drawable.test2
            2 ->R.drawable.test3
            3 ->R.drawable.test4
            else -> R.drawable.test5
        }
        imageView1.setImageResource(imgnum)




        exitBtn.setOnClickListener{
            finish()
        }
    }
}