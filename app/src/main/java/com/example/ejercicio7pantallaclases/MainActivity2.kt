package com.example.ejercicio7pantallaclases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7pantallaclases.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.humano)
        }
        binding.button2.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.elfo)
        }
        binding.button3.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.ogro)
        }
        binding.button4.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.gnomo)
        }
        binding.button5.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }





    }
     }




