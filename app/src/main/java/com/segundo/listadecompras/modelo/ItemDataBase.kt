package com.segundo.listadecompras.modelo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class ItemDataBase: RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        private var INSTANCIA: ItemDataBase? = null
        fun pegaInstancia(context: Context): ItemDataBase? {
            if (INSTANCIA == null) {
                synchronized(ItemDataBase::class) {
                    INSTANCIA = Room.databaseBuilder(context.applicationContext,
                                                     ItemDataBase::class.java,
                                                    "item.db").build()
                }
            }
            return INSTANCIA
        }
    }
}