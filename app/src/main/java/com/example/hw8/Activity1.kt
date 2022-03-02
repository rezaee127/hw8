package com.example.hw8

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hw8.databinding.Activity1Binding


class Activity1 : AppCompatActivity() {
    lateinit var binding: Activity1Binding
    lateinit var pref: SharedPreferences
    lateinit var edit: SharedPreferences.Editor
    var editFlag=false
    var clearFlag=false
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
        pref = getPreferences(Context.MODE_PRIVATE)
        clearFlag=intent.getBooleanExtra("ClearFlag",false)
        editFlag=intent.getBooleanExtra("EditFlag",false)

        if (clearFlag) {
            pref.edit().clear().commit()
        }

        if (pref.getString("Name","").isNullOrBlank()) {
            register()
        }else if(editFlag){
            editProfile()
        }else {
            goToActivity2()
        }



    }

    private fun editProfile() {
        binding.editTextFullName.setText( pref.getString("Name",""))
        binding.editTextNationalCode.setText(pref.getString("NationalCode",""))
        binding.editTextBirthPlace.setText(  pref.getString("BirthPlace",""))
        binding.editTextAddress.setText( pref.getString("Address",""))
        binding.editTextPostCode.setText(pref.getString("PostCode",""))
        if(pref.getString("Gender","")=="مونث"){
            binding.Female.isChecked=true
        }else{
            binding.Male.isChecked=true
        }
        register()
    }

    private fun goToActivity2() {
       var intent=Intent(this,Activity2::class.java)
       intent.putExtra("Name", pref.getString("Name",""))
        intent.putExtra("NationalCode", pref.getString("NationalCode",""))
        intent.putExtra("BirthPlace",  pref.getString("BirthPlace",""))
        intent.putExtra("Address", pref.getString("Address",""))
        intent.putExtra("PostCode", pref.getString("PostCode",""))
        intent.putExtra("Gender",  pref.getString("Gender",""))
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



        edit = pref.edit()
        edit.putString("Name", name)
        edit.putString("NationalCode", nationalCode)
        edit.putString("BirthPlace", birthPlace)
        edit.putString("Address", address)
        edit.putString("PostCode", postCode)
        edit.putString("Gender", gender)
        edit.apply()
        Toast.makeText(this, "ذخیره اطلاعات انجام شد", Toast.LENGTH_LONG).show()

    }

}