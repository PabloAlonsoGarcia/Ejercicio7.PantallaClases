package com.example.ejercicio7pantallaclases

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.ejercicio7pantallaclases.databinding.ActivityMain5Binding
import com.google.gson.Gson

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val numero = intent.getIntExtra("numero", 0)
        binding.Aviso.isVisible = false

        val sharedPref = getSharedPreferences("Personaje", MODE_PRIVATE)
        var gson = Gson()


        var json = sharedPref.getString("Personaje", "")
        var jsonO = sharedPref.getString("Objetos", "")


        var p1 = gson.fromJson(json, Personaje::class.java)
        var listaObjetos = gson.fromJson(jsonO, arrayListOf<Objeto>()::class.java)


        var precioO = 0


        when (numero) {
            1 -> {
                binding.imagenP.setImageResource(R.drawable.objeto)
                var tamanoMochila = p1.mochila
                var peso = 5
                var valor = 10
                var durabilidad = 20
                binding.boton1.text = "Continuar"
                binding.boton2.text = "Recoger"

                if (tamanoMochila <= 0) {
                    binding.boton2.isEnabled = false
                    binding.Aviso.isVisible = true
                    binding.Aviso.text = "No tienes espacio en la mochila"
                }
                binding.boton1.setOnClickListener() {
                    val intent = Intent(this, MainActivity4::class.java)

                    startActivity(intent)
                }
                binding.boton2.setOnClickListener() {
                    val intent = Intent(this, MainActivity4::class.java)
                    tamanoMochila = tamanoMochila - peso
                    p1.mochila = tamanoMochila
                    val editor = sharedPref.edit()
                    json = gson.toJson(p1)
                    editor.putString("Personaje", json)
                    editor.apply()
                    startActivity(intent)
                }


            }
            2 -> {
                binding.imagenP.setImageResource(R.drawable.ciudad)
                binding.boton1.text = "Continuar"
                binding.boton2.text = "Entrar"

                binding.boton1.setOnClickListener {
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                }
                binding.boton2.setOnClickListener {
                    val intent = Intent(this, MainActivity6::class.java)
                    startActivity(intent)
                }
            }
            3 -> {

                binding.imagenP.setImageResource(R.drawable.mercader)
                binding.boton1.text = "Continuar"
                binding.boton2.text = "Comerciar"
                var cantidad = 0



                binding.boton1.setOnClickListener {
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                }
                binding.boton2.setOnClickListener {
                    var valAl = 0

                    binding.cantidad.text = cantidad.toString()
                    binding.Comprar.isVisible = true
                    binding.Vender.isVisible = true
                    binding.Continuar.isVisible = true
                    binding.boton1.isVisible = false
                    binding.boton2.isVisible = false
                    binding.cantidad.isVisible = true
                    binding.plus.isVisible = true
                    binding.less.isVisible = true
                    binding.Aviso.isVisible = true
                    binding.Coste.isVisible = true

                    valAl = (1..3).random()

                    when (valAl) {
                        1 -> binding.imagenP.setImageResource(R.drawable.objeto)
                        2 -> binding.imagenP.setImageResource(R.drawable.objeto2)
                        3 -> binding.imagenP.setImageResource(R.drawable.objeto3)
                    }


                    /*for(i in listaObjetos){
                        if(valAl== i.id){
                            binding.imagenP.setImageResource(i.imagen)
                        }
                    }
                    */
                    //val intent = Intent(this, MainActivity6::class.java)
                    //startActivity(intent)
                    binding.plus.setOnClickListener {
                        cantidad++
                        precioO = precioO + 5
                        binding.cantidad.text = cantidad.toString()
                    }
                    binding.less.setOnClickListener {
                        if (cantidad > 0) {
                            cantidad--
                            if (precioO > 0)
                                precioO = precioO - 5
                            binding.cantidad.text = cantidad.toString()
                        }
                    }
                    binding.Comprar.setOnClickListener {
                        if (cantidad == 0) {
                            binding.Aviso.text =
                                "Debes de comprar al menos un objeto para poder continuar"
                        } else {
                            if (p1.monedero < precioO) {
                                binding.Aviso.text = "No tienes suficiente dinero"
                            } else {
                                binding.Aviso.text = "Compra realizada"
                                p1.monedero = p1.monedero - precioO
                            }
                        }
                    }
                    binding.Vender.setOnClickListener {


                        binding.Aviso.text = "Vendido"

                        /*
                        var contiene=false
                        for(i in listaObjetos){
                            if(i.id==valAl){
                                binding.Aviso.text="Vendido"
                                p1.monedero=p1.monedero+5
                            }else{
                                binding.Aviso.text="No tienes ese objeto"
                            }
                        }
                        */

                    }


                }

                binding.Continuar.setOnClickListener {
                    val intent = Intent(this, MainActivity6::class.java)
                    startActivity(intent)
                }


            }
            4 -> {
                binding.imagenP.setImageResource(R.drawable.enemigo)
                binding.boton1.text = "Continuar"
                binding.boton2.text = "Pelear"

                binding.boton1.setOnClickListener {
                    val intent = Intent(this, MainActivity4::class.java)
                    startActivity(intent)
                }
                binding.boton2.setOnClickListener {
                    var valAl = 0
                    var vidaJefe = 100

                    binding.Comprar.isVisible = true
                    binding.Vender.isVisible = true
                    binding.Continuar.isVisible = true
                    binding.boton1.isVisible = false
                    binding.boton2.isVisible = false


                    binding.Continuar.text = "Atacar"
                    binding.Comprar.text = "Curar"
                    binding.Vender.text = "Huir"


                    binding.Continuar.setOnClickListener() {
                        valAl = (1..6).random()
                        if (valAl >= 4) {
                            vidaJefe = vidaJefe - p1.fuerza
                            Toast.makeText(
                                this,
                                "Has hecho " + p1.fuerza + " de daño",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {
                            Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
                            p1.vida = p1.vida - 10
                        }
                        if (vidaJefe <= 0) {
                            binding.Aviso.text = "Has ganado"
                            binding.Continuar.isVisible = false
                            binding.Comprar.isVisible = false
                            binding.Vender.isVisible = false
                            binding.Aviso.isVisible = true
                            binding.Trato.isVisible = true
                            binding.Trato.text = "Continuar"
                        }
                        if (p1.vida <= 0) {
                            binding.Aviso.text = "Has perdido"
                            binding.Continuar.isVisible = false
                            binding.Comprar.isVisible = false
                            binding.Vender.isVisible = false
                            binding.Aviso.isVisible = true
                            binding.Trato.isVisible = true
                            binding.Trato.text = "Continuar"
                        }


                    }
                    binding.Comprar.setOnClickListener() {
                        val vaAL2 = 0
                        valAl = (1..6).random()
                        if (valAl >= 4) {
                            p1.vida = p1.vida + 10
                            Toast.makeText(this, "Has curado 10 de vida", Toast.LENGTH_SHORT).show()
                        }

                        binding.Vender.setOnClickListener() {
                            val intent = Intent(this, MainActivity4::class.java)
                            startActivity(intent)
                        }
                        binding.Trato.setOnClickListener() {
                            val intent = Intent(this, MainActivity4::class.java)
                            startActivity(intent)
                        }


                    }

                }
            }


        }
    }
}