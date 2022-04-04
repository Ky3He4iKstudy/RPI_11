package dev.ky3he4ik.pract37_311

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class TestCheckboxDialog(private val callback: TestFragment) : DialogFragment() {
    private val langs = arrayOf("Луна и звёзды ночью", "Солнце днём")
    private val checked = booleanArrayOf(true, true)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let { it ->
            AlertDialog.Builder(it)
                .setMultiChoiceItems(langs, checked) { dialog, which, isChecked ->
                    checked[which] = isChecked
                }
                .setPositiveButton("Ok") { dialog, which ->
                    TestTimePickerDialog(checked[0], checked[1], callback).show(parentFragmentManager, "TPD")
                }
                .create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
