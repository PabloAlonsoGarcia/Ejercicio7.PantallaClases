package com.example.ejercicio7pantallaclases

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7pantallaclases.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageButton2.setOnClickListener(){
            aleatorio()
        }



    }
    @SuppressLint("SetTextI18n")
    fun aleatorio(){
        var aux=0

        aux=(1..4).random()

        when(aux){
            1->{
                binding.texto2.text="Has encontrado un objeto"

            }
            2->{
                binding.texto2.text="Has encontrado una ciudad"
            }
            3->{
                binding.texto2.text="Has encontrado un mercader"
            }
            4->{
                binding.texto2.text="Has encontrado un enemigo"
            }
        }
    }

}