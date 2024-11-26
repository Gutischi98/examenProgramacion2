package cl.gutischigami.medidorapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.gutischigami.medidorapp.databinding.ItemMedicionBinding
import cl.gutischigami.medidorapp.models.Medicion

class MedicionAdapter : ListAdapter<Medicion, MedicionAdapter.MedicionViewHolder>(MedicionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicionViewHolder {
        val binding = ItemMedicionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedicionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedicionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MedicionViewHolder(private val binding: ItemMedicionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(medicion: Medicion) {
            binding.medicion = medicion
            binding.executePendingBindings()
        }
    }

    class MedicionDiffCallback : DiffUtil.ItemCallback<Medicion>() {
        override fun areItemsTheSame(oldItem: Medicion, newItem: Medicion): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Medicion, newItem: Medicion): Boolean {
            return oldItem == newItem
        }
    }
}
