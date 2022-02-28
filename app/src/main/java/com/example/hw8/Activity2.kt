package com.example.hw8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw8.databinding.Activity1Binding
import com.example.hw8.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    lateinit var binding:Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_2)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewName.text = pref.getString("Name","")
        binding.textViewNationalCode.text = pref.getString("NationalCode","")
        binding.textViewBirthPlace.text = pref.getString("BirthPlace","")
        binding.textViewAddress.text = pref.getString("Address","")
        binding.textViewGender.text = pref.getString("Gender","")

    }

}