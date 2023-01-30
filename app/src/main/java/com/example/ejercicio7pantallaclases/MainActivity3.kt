package com.example.ejercicio7pantallaclases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7pantallaclases.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.editTextTextPersonName2.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.editTextTextPersonName2.setText("")
            }
        }

        binding.Aceptar.setOnClickListener(){
            val intent = Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }

        binding.Reiniciar.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}