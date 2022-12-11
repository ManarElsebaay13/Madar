package com.manarelsebaay.madarsofttask.core.utils

import android.widget.EditText


class Validation {

    companion object {
        fun isEditTextEmpty(editText: EditText): Boolean {
            return isTextEmpty(editText.text.toString().trim { it <= ' ' })
        }

        fun isTextEmpty(text: String): Boolean {
            return text == ""
        }
    }
}
