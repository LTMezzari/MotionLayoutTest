package mezzari.torres.lucas.motion_layout_test.archive

import android.text.Editable
import android.text.TextWatcher
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * @author Lucas T. Mezzari
 * @since 10/06/2021
 */
fun EditText.addAfterTextChangedListener(listener: (Editable?) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            listener(s)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    })
}

fun EditText.bindTo(
    property: MutableLiveData<String>,
    owner: LifecycleOwner = context as LifecycleOwner,
    observer: ((String?) -> Unit)? = null
) {
    addAfterTextChangedListener { editable ->
        if (property.value != editable.toString()) {
            property.value = editable.toString()
            observer?.invoke(property.value)
        }
    }
    property.observe(owner) { value ->
        if (property.value != this.text.toString()) {
            setText(value)
            observer?.invoke(value)
        }
    }
}

fun Switch.bindTo(
    property: MutableLiveData<Boolean>,
    owner: LifecycleOwner = context as LifecycleOwner,
    observer: ((Boolean?) -> Unit)? = null
) {
    setOnCheckedChangeListener { _, isChecked ->
        if (property.value != isChecked) {
            property.value = isChecked
            observer?.invoke(property.value)
        }
    }
    property.observe(owner) {
        if (it != isChecked) {
            isChecked = it ?: false
            observer?.invoke(it)
        }
    }
}

fun CheckBox.bindTo(
    property: MutableLiveData<Boolean>,
    owner: LifecycleOwner = context as LifecycleOwner,
    observer: ((Boolean?) -> Unit)? = null
) {
    setOnCheckedChangeListener { _, isChecked ->
        if (property.value != isChecked) {
            property.value = isChecked
            observer?.invoke(property.value)
        }
    }
    property.observe(owner) {
        if (it != isChecked) {
            isChecked = it ?: false
            observer?.invoke(it)
        }
    }
}

fun TextView.bindTo(
    property: LiveData<String>,
    owner: LifecycleOwner = context as LifecycleOwner
) {
    property.observe(owner) {
        this@bindTo.text = it
    }
}