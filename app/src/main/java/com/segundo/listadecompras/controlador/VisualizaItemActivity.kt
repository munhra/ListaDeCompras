package com.segundo.listadecompras.controlador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.segundo.listadecompras.R
import com.segundo.listadecompras.modelo.ListaDeCompras

class VisualizaItemActivity : AppCompatActivity() {
    var itemIndice: Int? = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualiza_item)
        itemIndice = intent.extras?.getInt("itemIndice",0)
        pegaNomeDoItem()
        defineBotaoComprado()
    }

    private fun pegaNomeDoItem() {
        val nomeItemTextView = findViewById<TextView>(R.id.itemNomeTextView)
        nomeItemTextView.text = ListaDeCompras.listaItens[itemIndice ?: 0].nome
    }

    private fun defineBotaoComprado() {
        val botaoComprado = findViewById<Button>(R.id.compradoButton)
        val itemComprado = ListaDeCompras.listaItens[itemIndice ?: 0].comprado
        val tituloBotao = if(itemComprado) "Desfazer" else "Comprado"

        botaoComprado.text = tituloBotao
        botaoComprado.setOnClickListener {
            ListaDeCompras.listaItens[itemIndice ?: 0].comprado = !itemComprado
            finish()
        }
    }
}