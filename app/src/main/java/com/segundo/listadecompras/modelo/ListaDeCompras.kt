package com.segundo.listadecompras.modelo

import android.content.Context
import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

object ListaDeCompras {

    var listaItens = mutableListOf<Item>()

    private val executor = Executors.newSingleThreadExecutor()
    private val handler = Handler(Looper.getMainLooper())

    fun adicionarItemNaLista(item: Item, context: Context, callBack: () -> Unit) {
        executor.execute {
            val dataBase = ItemDataBase.pegaInstancia(context)
            dataBase?.itemDao()?.insere(item)
            listaItens.add(item)
            handler.post {
                callBack()
            }
        }
    }

    fun pegaTodosItensDaLista(context: Context, callBack: () -> Unit) {
        executor.execute {
            val dataBase = ItemDataBase.pegaInstancia(context)
            listaItens = dataBase?.itemDao()?.pegaTodosItens()!!
            handler.post{
                callBack()
            }
        }
    }

    fun removerTodosItens(context: Context, callBack: () -> Unit) {
        executor.execute {
            val dataBase = ItemDataBase.pegaInstancia(context)
            dataBase?.itemDao()?.deleteTodos()
            listaItens.clear()
            handler.post {
                callBack()
            }
        }
    }

    fun atualizaItemComprado(item: Item, context: Context, callBack: () -> Unit) {
        executor.execute {
            val dataBase = ItemDataBase.pegaInstancia(context)
            dataBase?.itemDao()?.atualizaItem(item.comprado, item.id ?: 0)
            handler.post {
                callBack()
            }
        }
    }
}

