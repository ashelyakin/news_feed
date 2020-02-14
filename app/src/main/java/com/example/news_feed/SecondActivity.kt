package com.example.news_feed

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_activity)

        val vEdit = findViewById<EditText>(R.id.act2_edit)
        findViewById<Button>(R.id.act2_button).setOnClickListener {
            val newStr = vEdit.text.toString()
            val i = Intent()
            i.putExtra("tag2", newStr)
            setResult(0, i)
            finish()
        }

        val str = intent.getStringExtra("tag1")
        vEdit.setText(str)
    }
}