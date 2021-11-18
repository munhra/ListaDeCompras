package com.segundo.listadecompras.modelo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert
    fun insert(item: Item)

    @Query("SELECT * from Item")
    fun getAllItens(): MutableList<Item>

    @Query("DELETE from Item")
    fun deleteAll()

    @Query("UPDATE Item SET comprado=:comprado WHERE id = :id")
    fun update(comprado: Boolean, id: Long)
}