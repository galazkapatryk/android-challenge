package pl.branchdev.android_common.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import pl.branchdev.android_common.R

fun Fragment.showToastError() {
    Toast.makeText(context, R.string.errorMessage, Toast.LENGTH_SHORT).run { show() }
}