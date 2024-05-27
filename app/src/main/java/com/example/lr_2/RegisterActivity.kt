package com.example.lr_2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val value = intent.getStringExtra(EXTRA_KEY)
        val emailinput = findViewById<TextInputEditText>(R.id.email_reg_edit_text)
        val pwinput = findViewById<TextInputEditText>(R.id.password_reg_edit_text)
        val pwcheckinput = findViewById<TextInputEditText>(R.id.password_check_edit_text)
        emailinput.setText(value!!)


        findViewById<Button>(R.id.btn_save).setOnClickListener {
            val res = emailinput.text.toString()
            val pw = pwinput.text.toString()
            val pw_check = pwcheckinput.text.toString()
            val intent = Intent()
            if (pw == pw_check && isValidEmail(res)) {
                intent.putExtra("registered email", res)
                setResult(Activity.RESULT_OK, intent)
            } else {
                intent.putExtra("registered email", "")
                setResult(Activity.RESULT_CANCELED)
            }
            finish()
        }
    }

    companion object {
        private const val EXTRA_KEY = "key"

        fun getIntent(context: Context, value: String) : Intent {
            val intent = Intent(context, RegisterActivity::class.java)
            intent.putExtra(EXTRA_KEY, value)
            return intent
        }

        fun isValidEmail(target: CharSequence?): Boolean {
            return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
}