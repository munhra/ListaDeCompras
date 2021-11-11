package com.segundo.listadecompras.modelo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
                    @NonNull
                    @PrimaryKey(autoGenerate = true)
                    var id: Long?,
                    val qtd: Int,
                    val nome: String,
                    var comprado: Boolean) {

}