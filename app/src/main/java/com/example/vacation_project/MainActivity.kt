package com.example.vacation_project

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class MainActivity : AppCompatActivity() {

    //Tab
    class MainActivity : AppCompatActivity() {
        var retire1: retire_1? = null
        var retire2: retire_2? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            retire1 = retire_1() // retire_1 클래스의 생성자 호출
            retire2 = retire_2() // retire_2 클래스의 생성자 호출

            supportFragmentManager.beginTransaction().replace(R.id.container, retire1).commit()
            val tabs = findViewById<TabLayout>(R.id.tabs)

            tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    val position = tab.position
                    Log.d("MainActivity", "선택된 탭: $position")
                    var selected: Fragment? = null
                    selected = when (position) {
                        0 -> retire1
                        1 -> retire2
                    }
                    if (selected != null) {
                        supportFragmentManager.beginTransaction().replace(R.id.container, selected).commit()
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }
    }


    //메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 레이아웃과 연결
        setContentView(R.layout.activity_main)

        time_button.setOnClickListener {
            val intent = Intent(this, ::class.java)   //경로 추가
        }
        meal_button.setOnClickListener {
            val intent = Intent(this, ::class.java)   //경로 추가
        }
        Rating_button.setOnClickListener {
            val intent = Intent(this, ::class.java)   //경로 추가
        }
        rating_button1.setOnClickListener {
            val intent = Intent(this, ::class.java)   //경로 추가
        }
        rating_button2.setOnClickListener {
            val intent = Intent(this, ::class.java)   //경로 추가
        }
        correspondence_button.setOnClickListener {
            val intent = Intent(this, ::class.java)   //경로 추가
        }
        agreement_button1.setOnClickListener {
            val intent = Intent(this, ::class.java)   //경로 추가
        }
        agreement_button2.setOnClickListener {
            val intent = Intent(this, ::class.java)   //경로 추가
        }
        retire_button.setOnClickListener {
            val intent = Intent(this, retire_1::class.java)   //경로 추가
        }
        announce_button.setOnClickListener {
            val intent = Intent(this, ::class.java)   //경로 추가
        }
        evaluation_button.setOnClickListener {
            val intent = Intent(this, ::class.java)   //경로 추가
        }

    }
}


