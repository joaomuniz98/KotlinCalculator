package com.example.projetotreino

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetotreino.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var calculo =  binding.calculo
        var resultado = binding.resultado


        var numbersCalculator = arrayOf("0","1", "2","3","4","5","6","7","8","9","/","*","+","-")
        val buttons = arrayOf(binding.zero,binding.um,binding.dois,binding.tres,binding.quatro,binding.cinco,binding.seis,binding.sete,binding.oito,binding.nove, binding.divisao,binding.multiplicacao,binding.soma,binding.subtracao)

        for ((indice, button) in buttons.withIndex()) {
            buttons[indice].setOnClickListener({
                calculo.text = "${calculo.text}${numbersCalculator[indice]}"
            })
        }

        binding.igual.setOnClickListener({
            val resultadoCalculadora = Expression(calculo.text.toString()).calculate()

            resultado.text =  resultadoCalculadora.toString()
        })

    }
}