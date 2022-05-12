package com.mbobiosio.firstlaunchutil.util

import android.content.Context
import android.widget.Toast

/**
 * @Author Mbuodile Obiosio
 * Twitter: @cazewonder
 */
fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}
