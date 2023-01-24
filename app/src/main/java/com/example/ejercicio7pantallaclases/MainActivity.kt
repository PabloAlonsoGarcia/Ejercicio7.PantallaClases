package com.example.ejercicio7pantallaclases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7pantallaclases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.arquero)
        }
        binding.button2.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.guerrero)
        }
        binding.button3.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.ladron)
        }
        binding.button4.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.asesino)
        }


        binding.button5.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


    }





}