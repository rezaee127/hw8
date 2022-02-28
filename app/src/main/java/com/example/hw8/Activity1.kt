package com.example.hw8

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.NonNull
import com.example.hw8.databinding.Activity1Binding
import org.jetbrains.annotations.NotNull
lateinit var pref: SharedPreferences

class Activity1 : AppCompatActivity() {
    lateinit var binding: Activity1Binding

    lateinit var edit: SharedPreferences.Editor
    var gender = ""
    var name = ""
    var address = ""
    var postCode = ""
    var nationalCode = ""
    var birthPlace = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_1)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if(name.isNullOrBlank()) {
            register()
        } else
            goToActivity2()

    }

    private fun goToActivity2() {
       var intent=Intent(this,Activity2::class.java)

        startActivity(intent)
    }


    private fun register() {

        binding.register.setOnClickListener {

            if (binding.editTextFullName.text.isBlank())
                binding.editTextFullName.error = "همه فیلدها را پر کنید"
            else if (binding.editTextNationalCode.text.isBlank())
                binding.editTextNationalCode.error = "همه فیلدها را پر کنید"
            else if (binding.editTextBirthPlace.text.isNullOrBlank())
                binding.editTextBirthPlace.error = "همه فیلدها را پر کنید"
            else if (binding.editTextAddress.text.isBlank())
                binding.editTextAddress.error = "همه فیلدها را پر کنید"
            else if (binding.editTextPostCode.text.isBlank())
                binding.editTextPostCode.error = "همه فیلدها را پر کنید"
            else if (binding.editTextPostCode.length() != 10)
                binding.editTextPostCode.error = "کدپستی اشتباه است"
            else if (binding.editTextNationalCode.length() != 10)
                binding.editTextNationalCode.error = "کدملی اشتباه است"
            else if (!binding.Female.isChecked && !binding.Male.isChecked) {
                binding.Female.error = "یک گزینه را انتخاب کنید"
            } else {
                if (binding.Female.isChecked)
                    gender = "مونث"
                else if (binding.Male.isChecked)
                    gender = "مذکر"

                sharedPref()
            }
        }
    }

    private fun sharedPref(){
        name = binding.editTextFullName.text.toString()
        nationalCode = binding.editTextNationalCode.text.toString()
        birthPlace = binding.editTextBirthPlace.text.toString()
        address = binding.editTextAddress.text.toString()
        postCode = binding.editTextPostCode.text.toString()


        pref = getPreferences(Context.MODE_PRIVATE)

        edit = pref.edit()
        edit.putString("Name", name)
        edit.putString("NationalCode", nationalCode)
        edit.putString("BirthPlace", birthPlace)
        edit.putString("Address", address)
        edit.putString("Gender", gender)
        edit.apply()
        Toast.makeText(this, "ذخیره اطلاعات انجام شد", Toast.LENGTH_LONG).show()

    }

}