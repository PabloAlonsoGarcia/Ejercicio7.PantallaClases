package com.example.ejercicio7pantallaclases

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.ejercicio7pantallaclases.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val numero = intent.getIntExtra("numero",0)
        binding.Aviso.isVisible=false

        when(numero){
            1->{
                binding.imagenP.setImageResource(R.drawable.objeto)
                var tamanoMochila=intent.getIntExtra("mochila",0)
                var peso=5
                var valor=10
                var durabilidad=20
                binding.boton1.text="Continuar"
                binding.boton2.text="Recoger"

                if(tamanoMochila<=0){
                    binding.boton2.isEnabled=false
                    binding.Aviso.isVisible=true
                    binding.Aviso.text="No tienes espacio en la mochila"
                }
                binding.boton1.setOnClickListener(){
                    val intent = Intent(this, MainActivity4::class.java)

                    startActivity(intent)
                }
                binding.boton2.setOnClickListener(){
                    val intent = Intent(this, MainActivity4::class.java)
                    tamanoMochila=tamanoMochila-peso
                    intent.putExtra("mochila",tamanoMochila)
                    startActivity(intent)
                }




            }
            2->{
                binding.imagenP.setImageResource(R.drawable.ciudad)
                binding.boton1.text="Continuar"
                binding.boton2.text="Entrar"

                binding.boton1.setOnClickListener(){
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                }
                binding.boton2.setOnClickListener(){
                    val intent = Intent(this, MainActivity6::class.java)
                    startActivity(intent)
                }
            }
            3->{
                binding.imagenP.setImageResource(R.drawable.mercader)
                binding.boton1.text="Continuar"
                binding.boton2.text="Comerciar"

                binding.boton1.setOnClickListener(){
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                }
                binding.boton2.setOnClickListener(){
                    val intent = Intent(this, MainActivity6::class.java)
                    startActivity(intent)
                }
            }
            4->{
                binding.imagenP.setImageResource(R.drawable.enemigo)
                binding.boton1.text="Continuar"
                binding.boton2.text="Pelear"

                binding.boton1.setOnClickListener(){
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                }
                binding.boton2.setOnClickListener(){
                    val intent = Intent(this, MainActivity6::class.java)
                    startActivity(intent)
                }
            }
        }


    }
}