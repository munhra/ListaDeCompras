package com.segundo.listadecompras.modelo

import android.content.Context
import android.os.AsyncTask
import android.os.Handler
import android.os.Looper
import androidx.loader.content.AsyncTaskLoader
import java.util.concurrent.Executor
import java.util.concurrent.Executors

object ListaDeCompras {

    var listaItens = mutableListOf<Item>()
    //var listaItens = listOf<Item>()
    private val executor = Executors.newSingleThreadExecutor()
    private val handler = Handler(Looper.getMainLooper())

    fun adicionarItemNaLista(item: Item, context: Context, callBack: () -> Unit) {
        executor.execute {
            val dataBase = ItemDataBase.getInstance(context)
            dataBase?.itemDao()?.insert(item)
            listaItens.add(item)
            handler.post {
                callBack()
            }
        }
    }

    fun pegaTodosItensDaLista(context: Context, callBack: () -> Unit) {
        executor.execute {
            val dataBase = ItemDataBase.getInstance(context)
            listaItens = dataBase?.itemDao()?.getAllItens()!!
            handler.post{
                callBack()
            }
        }
    }

    fun removerTodosItens(context: Context) {
        listaItens.clear()
    }
}

