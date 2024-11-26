package cl.gutischigami.medidorapp.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import cl.gutischigami.medidorapp.models.Medicion
import cl.gutischigami.medidorapp.presistence.MedicionDao
import cl.gutischigami.medidorapp.presistence.MedicionDatabase

class MedicionRepository(context: Context) {

    private val medicionDao: MedicionDao = MedicionDatabase.getDatabase(context).medicionDao()

    fun getAllMediciones(): LiveData<List<Medicion>> {
        return medicionDao.getAllMediciones()
    }

    suspend fun insert(medicion: Medicion) {
        medicionDao.insert(medicion)
    }
}
