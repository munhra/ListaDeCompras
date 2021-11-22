package com.segundo.listadecompras.modelo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert
    fun insere(item: Item)

    @Query("SELECT * from Item order by nome asc")
    fun pegaTodosItens(): MutableList<Item>

    @Query("DELETE from Item")
    fun deleteTodos()

    @Query("UPDATE Item SET comprado=:comprado WHERE id = :id")
    fun atualizaItem(comprado: Boolean, id: Long)
}