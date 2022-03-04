package com.example.hw8

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

fun Activity.sharedPref(name:String,nationalCode:String,birthPlace:String,
                        address:String,postCode:String,gender:String,pref:SharedPreferences,
                        context:Context,Activity2:Activity){



    val edit = pref.edit()
    edit.putString("Name", name)
    edit.putString("NationalCode", nationalCode)
    edit.putString("BirthPlace", birthPlace)
    edit.putString("Address", address)
    edit.putString("PostCode", postCode)
    edit.putString("Gender", gender)
    edit.apply()
    Toast.makeText(this, "ذخیره اطلاعات انجام شد", Toast.LENGTH_LONG).show()
    goToActivity2(context,Activity2)
}

 fun Activity.goToActivity2(context:Context,Activity2:Activity) {
    var intent= Intent(context,Activity2::class.java)
    startActivity(intent)
}