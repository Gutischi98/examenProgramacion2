package cl.gutischigami.medidorapp.presistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cl.gutischigami.medidorapp.models.Medicion

@Dao
interface MedicionDao {

    @Insert
    suspend fun insert(medicion: Medicion)

    @Query("SELECT * FROM medicion ORDER BY fecha DESC")
    fun getAllMediciones(): LiveData<List<Medicion>>
}
