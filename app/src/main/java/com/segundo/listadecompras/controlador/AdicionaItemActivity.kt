package com.segundo.listadecompras.controlador

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.segundo.listadecompras.R
import com.segundo.listadecompras.modelo.ItemLista
import com.segundo.listadecompras.modelo.ListaDeCompras

class AdicionaItemActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adiciona_item)
        defineBotaoSalvar()
    }

    private fun defineBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.salvarButton)
        botaoSalvar.setOnClickListener {
            val item = criaItemLista()
            ListaDeCompras.adicionarItemNaLista(item)
            finish()
        }
    }

    private fun criaItemLista(): ItemLista {
        val itemNomeTextView = findViewById<EditText>(R.id.itemNomeEditText)
        val itemQtdTextView = findViewById<EditText>(R.id.itemQtdEditText)
        val itemNome = itemNomeTextView.text.toString()
        val itemQtd = itemQtdTextView.text.toString().toInt()
        return ItemLista(itemQtd, itemNome, false)
    }
}