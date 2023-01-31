package com.example.ejercicio7pantallaclases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7pantallaclases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var clase=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.arquero)
            clase="Arquero"
        }
        binding.button2.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.guerrero)
            clase="Guerrero"
        }
        binding.button3.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.ladron)
            clase="Ladron"
        }
        binding.button4.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.asesino)
            clase="Asesino"
        }


        binding.button5.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("clase",clase)
            startActivity(intent)

        }




    }





}