package cl.gutischigami.medidorapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mediciones")
data class Medicion(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val tipo: String,
    val valor: Double,
    val fecha: String
)
