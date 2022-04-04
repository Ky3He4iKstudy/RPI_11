package dev.ky3he4ik.pract37_311

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class TestTimePickerDialog(
    private val sun: Boolean, private val moonstars: Boolean,
    private val callback: TestFragment
) : DialogFragment(),
    TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let { it ->
            TimePickerDialog(it, this, 14, 48, true)
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
        p0?.let {
            callback.setState(hour, minute, sun, moonstars)
        }
    }
}
