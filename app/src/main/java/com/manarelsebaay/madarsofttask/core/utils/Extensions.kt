package com.manarelsebaay.madarsofttask.core.utils

    import android.app.Activity
    import android.content.Context
    import android.widget.Toast
    import androidx.fragment.app.Fragment

    object Extensions {

        fun Activity.toast(msg: String){
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        fun Fragment.toast(msg: String){
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        fun Context.toast(msg: String){
            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        }
    }
