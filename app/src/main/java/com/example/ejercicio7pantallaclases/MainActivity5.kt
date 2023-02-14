package com.example.ejercicio7pantallaclases

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.ejercicio7pantallaclases.databinding.ActivityMain5Binding
import com.google.gson.Gson

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val numero = intent.getIntExtra("numero",0)
        binding.Aviso.isVisible=false

        val sharedPref = getSharedPreferences("Personaje", MODE_PRIVATE)
        var gson = Gson()

        var json = sharedPref.getString("Personaje", "")

        var p1 = gson.fromJson(json, Personaje::class.java)



        when(numero){
            1->{
                binding.imagenP.setImageResource(R.drawable.objeto)
                var tamanoMochila=p1.mochila
                var peso=5
                var valor=10
                var durabilidad=20
                var al=0
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
                    p1.mochila=tamanoMochila
                    var editor = sharedPref.edit()
                    json= gson.toJson(p1)
                    editor.putString("Personaje", json)
                    editor.apply()
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
                var cantidad=0

                binding.boton1.setOnClickListener(){
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                }
                binding.boton2.setOnClickListener(){
                    binding.cantidad.text=cantidad.toString()
                    binding.Comprar.isVisible=true
                    binding.Vender.isVisible=true
                    binding.Continuar.isVisible=true
                    binding.boton1.isVisible=false
                    binding.boton2.isVisible=false
                    binding.cantidad.isVisible=true
                    binding.plus.isVisible=true
                    binding.less.isVisible=true
                    binding.Aviso.isVisible=true
                    binding.imagenP.setImageResource(R.drawable.objeto)
                    //val intent = Intent(this, MainActivity6::class.java)
                    //startActivity(intent)
                    binding.plus.setOnClickListener(){
                        cantidad++
                        binding.cantidad.text=cantidad.toString()
                    }
                    binding.less.setOnClickListener(){
                        if(cantidad>0){
                            cantidad--
                            binding.cantidad.text=cantidad.toString()
                        }
                    }
                    binding.Comprar.setOnClickListener(){
                        if(cantidad==0){
                            binding.Aviso.text="Debes de comprar al menos un objeto para poder continuar"
                        }else{
                            binding.Aviso.text="Compra realizada"
                        }
                    }



                }

                binding.Continuar.setOnClickListener(){
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