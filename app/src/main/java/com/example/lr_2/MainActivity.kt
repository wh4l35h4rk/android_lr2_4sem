package com.example.lr_2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val data = it.data?.getStringExtra("registered email")
            findViewById<TextView>(R.id.email_login_edit_text).text = data
        } else if (it.resultCode == Activity.RESULT_CANCELED) {
            findViewById<TextView>(R.id.message).text = "неправильно введены почта или пароль.\nрегистрация не завершена :)"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        findViewById<Button>(R.id.login_btn).setOnClickListener{
//            launcher.launch(RegisterActivity.getIntent(this, " "))
//        }
        findViewById<Button>(R.id.reg_btn).setOnClickListener{
            launcher.launch(RegisterActivity.getIntent(this, ""))
        }
    }
}