package cl.gutischigami.medidorapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.gutischigami.medidorapp.models.Medicion
import cl.gutischigami.medidorapp.repositories.MedicionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicionViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MedicionRepository = MedicionRepository(application)
    val mediciones: LiveData<List<Medicion>> = repository.getAllMediciones()

    fun insert(medicion: Medicion) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(medicion)
        }
    }
}
