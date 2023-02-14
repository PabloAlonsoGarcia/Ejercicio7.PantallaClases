package com.example.ejercicio7pantallaclases

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7pantallaclases.databinding.ActivityMain4Binding
import com.google.gson.Gson

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var aux=0

        val sharedPref = getSharedPreferences("Personaje", MODE_PRIVATE)
        var gson = Gson()
        var json = sharedPref.getString("Personaje", "")
        var p1 = gson.fromJson(json, Personaje::class.java)


        var tamMochila=p1.mochila


        binding.imageButton2.setOnClickListener(){
            aux=aleatorio()
        }
        if(aux==0){
            binding.Avanzar.isEnabled=false
        }
        binding.Avanzar.setOnClickListener(){
            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("numero",aux)

                if (aux == 1) {
                    intent.putExtra("mochila", tamMochila)
                }
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
                binding.Avanzar.isEnabled=true

            }
            2->{
                binding.texto2.text="Has encontrado una ciudad"
                binding.Avanzar.isEnabled=true
            }
            3->{
                binding.texto2.text="Has encontrado un mercader"
                binding.Avanzar.isEnabled=true
            }
            4->{
                binding.texto2.text="Has encontrado un enemigo"
                binding.Avanzar.isEnabled=true
            }
        }
        return aux

    }

}