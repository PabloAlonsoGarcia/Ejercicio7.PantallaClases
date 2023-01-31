package com.example.ejercicio7pantallaclases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7pantallaclases.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var clase=intent.getStringExtra("clase").toString()
        var raza=""


        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.humano)
            raza="Humano"

        }
        binding.button2.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.elfo)
            raza="Elfo"
        }
        binding.button3.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.ogro)
            raza="Ogro"
        }
        binding.button4.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.gnomo)
            raza="Gnomo"
        }
        binding.button5.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("clase",clase)
            intent.putExtra("raza",raza)
            startActivity(intent)
        }





    }
     }




