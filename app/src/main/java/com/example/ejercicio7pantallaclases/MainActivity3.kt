package com.example.ejercicio7pantallaclases

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio7pantallaclases.databinding.ActivityMain3Binding
import com.google.gson.Gson

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var clase=intent.getStringExtra("clase").toString()
        var raza=intent.getStringExtra("raza").toString()





        var nombre=""
        var fuerza=0
        var defensa=0
        var mochila=10
        var vida=200
        var monedero=0



        fuerza=(10..15).random()

        defensa=(1..5).random()


        var p1 = Personaje(nombre,raza,clase,fuerza,defensa,mochila,vida,monedero)


        when(p1.clase){

            "Arquero"->{
                binding.imageView2.setImageResource(R.drawable.arquero)
            }
            "Guerrero"->{
                binding.imageView2.setImageResource(R.drawable.guerrero)
            }
            "Ladron"->{
                binding.imageView2.setImageResource(R.drawable.ladron)
            }
            "Asesino"->{
                binding.imageView2.setImageResource(R.drawable.asesino)
            }

        }

        when(p1.raza){

                "Humano"->{
                    binding.imageView3.setImageResource(R.drawable.humano)
                }
                "Elfo"->{
                    binding.imageView3.setImageResource(R.drawable.elfo)
                }
                "Ogro"->{
                    binding.imageView3.setImageResource(R.drawable.ogro)
                }
                "Gnomo"->{
                    binding.imageView3.setImageResource(R.drawable.gnomo)
                }

        }


        binding.Fuerza2.text="Fuerza: "+p1.fuerza
        binding.Defensa.text="Defensa:"+p1.defensa
        binding.TamanoMochila.text="Tamaño mochila"+p1.mochila.toString()
        binding.Vida.text="Vida: "+p1.vida.toString()
        binding.Monedero.text="Monedero: "+p1.monedero.toString()





        binding.editTextTextPersonName2.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.editTextTextPersonName2.setText("")
            }
        }
        binding.Aceptar.setOnClickListener(){
            val intent = Intent(this, MainActivity4::class.java)
            val sharedPref = getSharedPreferences("Personaje", MODE_PRIVATE)
            val gson = Gson()
            val editor = sharedPref.edit()

            val jsonS = gson.toJson(p1)
            editor.putString("Personaje", jsonS)
            editor.apply()


            startActivity(intent)
        }
        binding.Reiniciar.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}