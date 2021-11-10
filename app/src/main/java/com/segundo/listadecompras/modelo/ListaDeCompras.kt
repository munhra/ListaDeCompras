package com.segundo.listadecompras.modelo

object ListaDeCompras {

    var listaItens = mutableListOf<ItemLista>()

    fun adicionarItemNaLista(item: ItemLista) {
        listaItens.add(item)
    }

    fun removerTodosItens() {
        listaItens.clear()
    }
}