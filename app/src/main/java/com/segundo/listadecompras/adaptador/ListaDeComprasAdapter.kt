package com.segundo.listadecompras.adaptador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.segundo.listadecompras.R
import com.segundo.listadecompras.modelo.Item

class ListaDeComprasAdapter(val itens: List<Item>): RecyclerView.Adapter<LinhaLista>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinhaLista {
        return LinhaLista(LayoutInflater.from(parent.context).inflate(R.layout.linha_lista_compra, parent, false))
    }

    override fun onBindViewHolder(holder: LinhaLista, position: Int) {
        val itemLista = itens[position]
        holder.configuraLinhaLista(itemLista)
    }

    override fun getItemCount(): Int {
        return itens.count()
    }
}