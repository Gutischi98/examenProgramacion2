package cl.gutischigami.medidorapp.ui

import androidx.recyclerview.widget.DiffUtil
import cl.gutischigami.medidorapp.models.Medicion

class MedicionDiffCallback : DiffUtil.ItemCallback<Medicion>() {
    override fun areItemsTheSame(oldItem: Medicion, newItem: Medicion): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Medicion, newItem: Medicion): Boolean {
        return oldItem == newItem
    }
}
