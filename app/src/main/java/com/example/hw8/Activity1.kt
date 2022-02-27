package com.example.hw8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw8.databinding.Activity1Binding

class Activity1 : AppCompatActivity() {
    lateinit var binding: Activity1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_1)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        /*    binding.register.setOnClickListener {

            if (binding.editTextFullName.text.isBlank() || binding.editTextUserName.text.isBlank()
                || binding.editTextEmailAddress.text.isBlank() || binding.editTextPassword.text.isBlank()
                || binding.editTextReTypePassword.text.isBlank()
            ) {
                binding.editTextFullName.error = "همه فیلدها را پر کنید"
                Toast.makeText(this, "همه فیلدها را پر کنید", Toast.LENGTH_LONG).show()

            } else if (binding.editTextPassword.text.toString() != binding.editTextReTypePassword.text.toString()) {
                binding.editTextReTypePassword.error = "پسوردهای وارد شده یکی نیستند"

            } else if (!binding.Female.isChecked && !binding.Male.isChecked) {
                binding.Male.error = "یک گزینه را انتخاب کنید"
            } else {
                if (binding.Female.isChecked) {
                    gender = "Female"
                } else if (binding.Male.isChecked) {
                    gender = "Male"
                }
                fullName = binding.editTextFullName.text.toString()
                userName = binding.editTextUserName.text.toString()
                email = binding.editTextEmailAddress.text.toString()
                password = binding.editTextPassword.text.toString()


                edit = pref.edit()
                edit.putString("FullName", fullName)
                edit.putString("UserName", userName)
                edit.putString("Email", email)
                edit.putString("Password", password)
                edit.putString("Gender", gender)
                edit.apply()
                Toast.makeText(this, "ذخیره اطلاعات انجام شد", Toast.LENGTH_LONG).show()
            }


        }

        binding.showInfo.setOnClickListener {
            binding.textViewFullName.text = pref.getString("FullName", null)
            binding.textViewUserName.text = pref.getString("UserName", "")
            binding.textViewEmail.text = pref.getString("Email", "")
            binding.textViewPassword.text = pref.getString("Password", "")
            binding.textViewGender.text = pref.getString("Gender", "")
            visible()
        }
 */
    }
}