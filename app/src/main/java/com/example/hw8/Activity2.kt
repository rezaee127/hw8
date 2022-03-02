package com.example.hw8

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw8.databinding.Activity1Binding
import com.example.hw8.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    lateinit var binding:Activity2Binding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_2)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //var share=getSharedPreferences(resources.getString(R.string.app_name),MODE_PRIVATE)

        setText()

        editButtonOnClick()


    }

    private fun editButtonOnClick() {
        binding.buttonEdit.setOnClickListener {
            editFlag=true
            var intent= Intent(this,Activity1::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setText() {
        binding.textViewName.text = "${binding.textViewName.text} ${intent.getStringExtra("Name")}"
        binding.textViewNationalCode.text = "${binding.textViewNationalCode.text} ${intent.getStringExtra("NationalCode")}"
        binding.textViewBirthPlace.text = "${binding.textViewBirthPlace.text} ${intent.getStringExtra("BirthPlace")}"
        binding.textViewAddress.text = "${binding.textViewAddress.text} ${intent.getStringExtra("Address")}"
        binding.textViewPostCode.text="${binding.textViewPostCode.text} ${intent.getStringExtra("PostCode")}"
        binding.textViewGender.text = "${binding.textViewGender.text} ${intent.getStringExtra("Gender")}"
    }

}