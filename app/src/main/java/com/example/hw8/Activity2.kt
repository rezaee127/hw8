package com.example.hw8

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hw8.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    lateinit var binding:Activity2Binding
    lateinit var share: SharedPreferences
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_2)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
         share = getSharedPreferences("shared",MODE_PRIVATE)

        setText()

        editButtonOnClick()

        newUserButtonOnClick()

    }

    private fun newUserButtonOnClick() {
       binding.buttonNewUser.setOnClickListener {
           share.edit().clear().commit()
           var intent= Intent(this,Activity1::class.java)
           Log.d("tag1","before start Activity")
           startActivity(intent)
           Log.d("tag1","after start Activity")
           finish()
           Log.d("tag1","after finish")
       }
    }

    private fun editButtonOnClick() {
        binding.buttonEdit.setOnClickListener {
            var intent= Intent(this,Activity1::class.java)
            intent.putExtra("EditFlag",true)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setText() {
        binding.textViewName.text = "${binding.textViewName.text} ${share.getString("Name","")}"
        binding.textViewNationalCode.text = "${binding.textViewNationalCode.text} ${share.getString("NationalCode","")}"
        binding.textViewBirthPlace.text = "${binding.textViewBirthPlace.text} ${share.getString("BirthPlace","")}"
        binding.textViewAddress.text = "${binding.textViewAddress.text} ${share.getString("Address","")}"
        binding.textViewPostCode.text="${binding.textViewPostCode.text} ${share.getString("PostCode","")}"
        binding.textViewGender.text = "${binding.textViewGender.text} ${share.getString("Gender","")}"
    }

}