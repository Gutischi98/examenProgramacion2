package cl.gutischigami.medidorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.gutischigami.medidorapp.ui.MedicionAdapter
import cl.gutischigami.medidorapp.viewmodels.MedicionViewModel
import cl.gutischigami.medidorapp.databinding.ActivityMainBinding
import android.content.Intent
import cl.gutischigami.medidorapp.ui.FormActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MedicionViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MedicionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.recyclerView
        adapter = MedicionAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(MedicionViewModel::class.java)

        viewModel.mediciones.observe(this) { mediciones ->
            adapter.submitList(mediciones)
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }
    }
}
