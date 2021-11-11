package com.segundo.listadecompras.modelo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class ItemDataBase: RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        private var INSTANCE: ItemDataBase? = null
        fun getInstance(context: Context): ItemDataBase? {
            if (INSTANCE == null) {
                synchronized(ItemDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, ItemDataBase::class.java, "item.db").build()
                }
            }
            return INSTANCE
        }
    }
}