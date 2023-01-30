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
        var flag1=0
        var flag2=0
        var flag3=0
        var flag4=0


        binding.button.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.arquero)
            flag1 += 1

        }
        binding.button2.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.guerrero)
            flag2 += 1
        }
        binding.button3.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.ladron)
            flag3 += 1
        }
        binding.button4.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.asesino)
            flag4 += 1
        }


        binding.button5.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            if(flag1>flag2){
                if(flag1>flag3){
                    if(flag1>flag4){
                        intent.putExtra("Imagen1","arquero")
                    }
                }
            }


            startActivity(intent)
        }


    }





}