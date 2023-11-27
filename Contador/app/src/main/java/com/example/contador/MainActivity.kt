package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    //elementos
    /*private lateinit var botonIncremento: Button
    private lateinit var botonDecremento: Button
    private lateinit var textoContador: TextView*/

    //fichero
    private lateinit var binding: ActivityMainBinding
    private var contador = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //pegados parte logica (this) con parte grafica (xml)
        //rellenar el fichero
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*botonIncremento = findViewById(R.id.boton_incremento)
        botonDecremento = findViewById(R.id.boton_incremento)
        textoContador = findViewById(R.id.texto_contador)*/
        //funcionalidad = cuando pulso + suma 1
        //funcionalidad = cuando pulso - resta 1
        binding.botonIncremento.setOnClickListener(this)
        binding.botonDecremento.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //diferenciar cual he pulsado
        when(v?.id){
            binding.botonIncremento.id->{
                //Sumar 1
                contador++;
            }
            binding.botonDecremento.id->{
                //Sumar 2
                contador--;
            }
        }
        //Mostrar resultado en texto
        binding.textoContador.text = contador.toString();
    }
}