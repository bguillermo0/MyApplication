package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.exp
import kotlin.math.pow

class MainActivity : AppCompatActivity(), OnClickListener{
    private lateinit var binding: ActivityMainBinding
    var operandoPrimero: Int = 0;
    var operandoSegundo: Int = 0;
    var operacion: Int = 0;
    var operando: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonAC.setOnClickListener(this)
        binding.botonMasMenos.setOnClickListener(this)
        binding.botonPorcentaje.setOnClickListener(this)
        binding.botonDividir.setOnClickListener(this)
        binding.botonSiete.setOnClickListener(this)
        binding.botonOcho.setOnClickListener(this)
        binding.botonNueve.setOnClickListener(this)
        binding.botonMultiplicar.setOnClickListener(this)
        binding.botonCuatro.setOnClickListener(this)
        binding.botonCinco.setOnClickListener(this)
        binding.botonSeis.setOnClickListener(this)
        binding.botonMenos.setOnClickListener(this)
        binding.botonUno.setOnClickListener(this)
        binding.botonDos.setOnClickListener(this)
        binding.botonTres.setOnClickListener(this)
        binding.botonMas.setOnClickListener(this)
        binding.botonCero.setOnClickListener(this)
        binding.botonIgual.setOnClickListener(this)
        binding.botonDiezElevadoX?.setOnClickListener(this)
        binding.botonEElevadoX?.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("calculatorScreenText", binding.calculatorScreen.text.toString())
        outState.putInt("operandoPrimero", operandoPrimero)
        outState.putInt("operandoSegundo", operandoSegundo)
        outState.putInt("operacion", operacion)
        outState.putBoolean("operando", operando)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.calculatorScreen.text = savedInstanceState.getString("calculatorScreenText", "0")
        operandoPrimero = savedInstanceState.getInt("operandoPrimero", 0)
        operandoSegundo = savedInstanceState.getInt("operandoSegundo", 0)
        operacion = savedInstanceState.getInt("operacion", 0)
        operando = savedInstanceState.getBoolean("operando", true)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.boton_AC -> ca(v as Button)
            R.id.boton_mas_menos -> operacion(v as Button)
            R.id.boton_porcentaje -> operacion(v as Button)
            R.id.boton_dividir -> operacion(v as Button)
            R.id.boton_siete -> addNumero(v as Button)
            R.id.boton_ocho -> addNumero(v as Button)
            R.id.boton_nueve -> addNumero(v as Button)
            R.id.boton_multiplicar -> operacion(v as Button)
            R.id.boton_cuatro -> addNumero(v as Button)
            R.id.boton_cinco -> addNumero(v as Button)
            R.id.boton_seis -> addNumero(v as Button)
            R.id.boton_menos -> operacion(v as Button)
            R.id.boton_uno -> addNumero(v as Button)
            R.id.boton_dos -> addNumero(v as Button)
            R.id.boton_tres -> addNumero(v as Button)
            R.id.boton_mas -> operacion(v as Button)
            R.id.boton_cero -> addNumero(v as Button)
            R.id.boton_igual -> igual(v as Button)
            R.id.boton_diez_elevadoX -> operacion(v as Button)
            R.id.boton_e_elevadoX -> operacion(v as Button)
        }
    }

    fun addNumero(button: Button){
        if (!operando){
            binding.calculatorScreen.append(button.text)
        }else{
            binding.calculatorScreen.text = (button.text)
            operando = false
        }
    }

    fun operacion(button: Button){
        operandoPrimero = binding.calculatorScreen.text.toString().toInt()
        when(button){
            binding.botonMas->{operacion = 0}
            binding.botonMenos->{operacion = 1}
            binding.botonMultiplicar->{operacion = 2}
            binding.botonDividir->{operacion = 3}
            binding.botonPorcentaje->{operacion = 4}
            binding.botonMasMenos->{operacion = 5}
            binding.botonDiezElevadoX->{operacion = 6}
            binding.botonEElevadoX->{operacion = 7}
        }
        operando = true
    }

    fun igual(button: Button){
        operandoSegundo = binding.calculatorScreen.text.toString().toInt()
        var resultado: Number = 0;
        when(operacion){
            0->{
                resultado = operandoPrimero.toInt() + operandoSegundo.toInt()
            }
            1->{
                resultado = operandoPrimero.toInt() - operandoSegundo.toInt()
            }
            2->{
                resultado = operandoPrimero.toInt() * operandoSegundo.toInt()
            }
            3->{
                resultado = operandoPrimero.toInt() / operandoSegundo.toInt()
            }
            4->{
                resultado = operandoPrimero.toDouble() * (operandoSegundo.toDouble()/100.0)
            }
            5->{
                resultado = -operandoSegundo.toInt()
            }
            6->{
                resultado = 10.0.pow(operandoSegundo.toDouble())
            }
            7->{
                resultado = exp(operandoSegundo.toDouble())
            }
        }
        binding.calculatorScreen.text = resultado.toString()
        operando = true
    }

    fun ca(button: Button){
        binding.calculatorScreen.text = "0"
        operando = true
    }
}