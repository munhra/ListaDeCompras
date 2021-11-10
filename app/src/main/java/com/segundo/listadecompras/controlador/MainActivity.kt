package com.segundo.listadecompras.controlador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.segundo.listadecompras.R
import com.segundo.listadecompras.adaptador.ListaDeComprasAdapter
import com.segundo.listadecompras.modelo.ListaDeCompras

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var listaDeComprasAdapter: ListaDeComprasAdapter
    lateinit var listaDecomprasRecycleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listaDecomprasRecycleView = findViewById<RecyclerView>(R.id.listaDeComprasRecyclerView)
        defineBotaoAdicionaItem()
        defineBotaoRemoverTodos()
    }

    override fun onResume() {
        super.onResume()
        atualizaListaDeCompra()
    }

    private fun defineBotaoAdicionaItem() {
        val adicionaItemFloatButton = findViewById<FloatingActionButton>(R.id.adicionaItemFloatButton)
        adicionaItemFloatButton.setOnClickListener {
            val adcionaItemIntent = Intent(this, AdicionaItemActivity::class.java)
            startActivity(adcionaItemIntent)
        }
    }

    private fun defineBotaoRemoverTodos() {
        val removeTodosFloatButton = findViewById<FloatingActionButton>(R.id.removerTodosFloatButton)
        removeTodosFloatButton.setOnClickListener {
            ListaDeCompras.removerTodosItens()
            atualizaListaDeCompra()
        }
    }

    private fun atualizaListaDeCompra() {
        layoutManager = LinearLayoutManager(this)
        listaDeComprasAdapter = ListaDeComprasAdapter(ListaDeCompras.listaItens)
        listaDecomprasRecycleView.layoutManager = layoutManager
        listaDecomprasRecycleView.adapter = listaDeComprasAdapter
    }
}