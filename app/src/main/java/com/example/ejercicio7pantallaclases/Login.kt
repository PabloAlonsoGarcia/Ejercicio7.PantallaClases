package com.example.ejercicio7pantallaclases

import android.annotation.SuppressLint
import android.content.Intent
import android.location.GnssAntennaInfo.Listener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.ejercicio7pantallaclases.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val db = DataBaseHelper(Login@this)

        var listaPj=db.everyone2 as ArrayList<String>
        val spinnerPj = findViewById<Spinner>(R.id.spinnerPj)
        val adaptadorPJ = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaPj)
        adaptadorPJ.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPj.adapter = adaptadorPJ

        binding.crearPJ.setOnClickListener{
            val intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }
        binding.Acceso.setOnClickListener(){
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }






    }
}