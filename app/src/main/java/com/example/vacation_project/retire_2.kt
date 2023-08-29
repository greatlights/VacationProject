package com.example.vacation_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class retire_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.retire_2)

        button_a.setOnClickListener {
            val intent = Intent(this, retire_2_a::class.java)
        }
        button_a.setOnClickListener {
            val intent = Intent(this, retire_2_b::class.java)
        }

    }
}