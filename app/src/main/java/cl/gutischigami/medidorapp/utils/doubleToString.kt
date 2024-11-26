package cl.gutischigami.medidorapp.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:doubleToString")
fun bindDoubleToString(view: TextView, value: Double?) {
    if (value != null) {
        view.text = value.toString()
    } else {
        view.text = ""
    }
}