package com.example.cmv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valordoEstoqueInicial: EditText = findViewById(R.id.editTextText)
        val valordasCompras: EditText = findViewById(R.id.editTextText2)
        val valordoEstoqueFinal: EditText = findViewById(R.id.editTextText3)
        val valordoResultado: EditText = findViewById(R.id.editTextText4)

        val textoInicial = valordoEstoqueInicial.text.toString()
        val textoCompras = valordasCompras.text.toString()
        val textoFinal = valordoEstoqueFinal.text.toString()

        if (textoInicial.isNotEmpty() && textoCompras.isNotEmpty() && textoFinal.isNotEmpty()) {
            try {
                val valorInicial = textoInicial.toDouble()
                val valorCompras = textoCompras.toDouble()
                val valorFinal = textoFinal.toDouble()

                val resultado = valorInicial + valorCompras - valorFinal
                valordoResultado.setText(resultado.toString())
            } catch (e: NumberFormatException) {
                // Lidar com a exceção, por exemplo, exibir uma mensagem de erro
                valordoResultado.setText("Erro: Verifique os valores inseridos")
            }
        } else {
            // Lidar com o caso em que algum dos campos está vazio
            valordoResultado.setText("Preencha todos os campos")
        }
    }
}
