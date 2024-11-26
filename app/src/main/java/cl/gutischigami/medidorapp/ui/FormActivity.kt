package cl.gutischigami.medidorapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import cl.gutischigami.medidorapp.R
import cl.gutischigami.medidorapp.databinding.ActivityFormBinding
import cl.gutischigami.medidorapp.models.Medicion
import cl.gutischigami.medidorapp.viewmodels.MedicionViewModel

class FormActivity : AppCompatActivity() {

    private lateinit var viewModel: MedicionViewModel
    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MedicionViewModel::class.java)

        binding.btnSave.setOnClickListener {
            val tipo = when (binding.radioGroup.checkedRadioButtonId) {
                R.id.radioAgua -> "Agua"
                R.id.radioLuz -> "Luz"
                R.id.radioGas -> "Gas"
                else -> ""
            }

            val valor = binding.edtValor.text.toString().toDoubleOrNull()
            val fecha = binding.edtFecha.text.toString()

            if (tipo.isNotEmpty() && valor != null && fecha.isNotEmpty()) {
                val medicion = Medicion(tipo = tipo, valor = valor, fecha = fecha)
                viewModel.insert(medicion)
                Toast.makeText(this, "Medición guardada", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
