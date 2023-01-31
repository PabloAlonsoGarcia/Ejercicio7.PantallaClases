package com.example.ejercicio7pantallaclases

import android.annotation.SuppressLint
import android.content.Intent
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

        var aux=0

        binding.imageButton2.setOnClickListener(){
            aux=aleatorio()
        }
        binding.Avanzar.setOnClickListener(){
            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("numero",aux)
            startActivity(intent)
        }



    }
    @SuppressLint("SetTextI18n")
    fun aleatorio(): Int {
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
        return aux

    }

}