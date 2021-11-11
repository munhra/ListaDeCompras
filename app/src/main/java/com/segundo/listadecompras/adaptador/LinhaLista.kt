package com.segundo.listadecompras.adaptador

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.segundo.listadecompras.R
import com.segundo.listadecompras.controlador.VisualizaItemActivity
import com.segundo.listadecompras.modelo.Item

class LinhaLista(view: View) : RecyclerView.ViewHolder(view) {
    val linhaListaView = view

    init {
        linhaListaView.setOnClickListener {
            visualizaItem()
        }
    }

    private fun visualizaItem() {
        val itemIndice = this.adapterPosition
        val visualizaItemIntent = Intent(linhaListaView.context,
                                         VisualizaItemActivity::class.java)

        visualizaItemIntent.putExtra("itemIndice",itemIndice)
        ContextCompat.startActivity(linhaListaView.context,
                                    visualizaItemIntent,
                                   null)
    }

    fun configuraLinhaLista(itemLista: Item) {
        val itemTextView = linhaListaView.findViewById<TextView>(R.id.itemTextView)
        val qtdTextView = linhaListaView.findViewById<TextView>(R.id.qtdTextView)
        val marcaCompradoImageView = linhaListaView.findViewById<ImageView>(R.id.marcaCompradoImageView)
        itemTextView.text = itemLista.nome
        qtdTextView.text = itemLista.qtd.toString()
        if (itemLista.comprado) {
            marcaCompradoImageView.setImageResource(android.R.drawable.btn_star_big_on)
        } else {
            marcaCompradoImageView.setImageResource(android.R.drawable.btn_star_big_off)
        }
    }
}