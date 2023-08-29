package com.example.vacation_project

import android.content.DialogInterface

class retire_2_b {
}
import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*


class retire_2_b : AppCompatActivity() {
    private var textView: TextView? = null
    private var editText: EditText? = null
    private var button: Button? = null
    var mRootRef = FirebaseDatabase.getInstance().reference
    var conditionRef = mRootRef.child("Data")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.retire_1_b)
        editText = findViewById<View>(R.id.d_reason) as EditText
        button = findViewById<View>(R.id.issue) as Button
    }

    override fun onStart() {
        super.onStart()
        conditionRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val text = dataSnapshot.getValue(String::class.java)
                textView!!.text = text
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        button!!.setOnClickListener(object : DialogInterface.OnClickListener() {
            fun onClick(v: View?) {
                conditionRef.setValue(editText!!.text.toString())
            }
        })
    }
}

public class retire_2_b : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.retire_2)

        database = FirebaseDatabase.getInstance()
        databaseReference = database.reference

        saveButton.setOnClickListener {
            val inputText = inputEditText.text.toString()
            saveDataToFirebase(inputText)
        }

        readButton.setOnClickListener {
            readDataFromFirebase()
        }
    }

    private fun saveDataToFirebase(data: String) {
        val newDataRef = databaseReference.child("user_data").push()
        newDataRef.setValue(data)
    }

    private fun readDataFromFirebase() {
        databaseReference.child("user_data").get().addOnSuccessListener { snapshot ->
            val data = StringBuilder()
            for (childSnapshot in snapshot.children) {
                val value = childSnapshot.getValue(String::class.java)
                data.append("$value\n")
            }
            outputTextView.text = data.toString()
        }
    }
}


val myAdapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, items)

spinner.adapter = myAdapter
spinner.prompt = "사유를 선택해주세요"
spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

        when(position) {
            0   ->  {

            }
            1   ->  {

            }
            //...
            else -> {

            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {

    }
}
}
}
