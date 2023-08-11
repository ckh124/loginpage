package com.example.myapp

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.LauncherActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts


class SigninActivity : AppCompatActivity() {//프로젝트 생성 후 MainActivity > SigninActivity로 수정
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var inputID : EditText
    private lateinit var inputPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var loginBtn =findViewById<Button>(R.id.loginBtn)
        var regiBtn = findViewById<Button>(R.id.regiBtn)
        inputID = findViewById(R.id.inputID)
        inputPassword = findViewById(R.id.inputPassword)

        setResultNext()


    loginBtn.setOnClickListener{
        Log.d(TAG, "로그인 버튼 클릭")

        val id = inputID.text.toString()
        var pw = inputPassword.text.toString()

        if(id.isEmpty()){
            Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
        }else if(pw.isEmpty()){
            Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()


            var intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id",id)
            startActivity(intent)
        }



    }


    regiBtn.setOnClickListener{
        var intent = Intent(this, SignUpActivity::class.java)
        resultLauncher.launch(intent)
    }



    }
    fun setResultNext(){
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->

            if(result.resultCode == RESULT_OK){

                val id = result.data?.getStringExtra("id") ?: ""
                val pw = result.data?.getStringExtra("pw") ?: ""

                inputID.text = Editable.Factory.getInstance().newEditable(id)
                inputPassword.text =Editable.Factory.getInstance().newEditable(pw)



            }

        }

    }



}