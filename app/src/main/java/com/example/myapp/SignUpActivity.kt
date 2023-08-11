package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var signUpBtn = findViewById<Button>(R.id.signUpBtn)
        var inputName = findViewById<EditText>(R.id.nameEditText)
        var inputId = findViewById<EditText>(R.id.idEditText)
        var inputPw = findViewById<EditText>(R.id.pwEditText)



        signUpBtn.setOnClickListener{
            var name = inputName.text.toString()
            var id = inputId.text.toString()
            var pw = inputPw.text.toString()
            if(name.isEmpty()){
                Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            }else if(id.isEmpty()){
                Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
            }else if(pw.isEmpty()){
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "회원가입을 완료하였습니다!", Toast.LENGTH_SHORT).show()

                intent.putExtra("id",inputId.text.toString())
                intent.putExtra("pw",inputPw.text.toString())
                setResult(RESULT_OK,intent)
                finish()
            }

        }
    }
}