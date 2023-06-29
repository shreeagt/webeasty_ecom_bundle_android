package com.nide.tecom.util

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.snackbar.Snackbar
import com.nide.tecom.core.response.ApiResponse

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

fun <T> Fragment.observeFlow(data: Flow<T>, block: suspend (T) -> Unit) {
    lifecycleScope.launchWhenStarted {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            data.collectLatest {
                block.invoke(it)
            }
        }
    }
}

fun <T> AppCompatActivity.observeFlow(data: Flow<T>, block: suspend (T) -> Unit) {
    lifecycleScope.launchWhenCreated {
        repeatOnLifecycle(Lifecycle.State.CREATED) {
            data.collectLatest {
                block(it)
            }
        }
    }
}

inline fun <reified T> ApiResponse<T>.doIfSuccess(block: (value: T) -> Unit) {
    if (this is ApiResponse.Success) {
        block(this.data)
    }
}

inline fun <reified T> ApiResponse<T>.doIfFailure(block: (message: String, code: Int) -> Unit) {
    if (this is ApiResponse.Error) {
        block(message, code)
    }
}

fun <T : ViewDataBinding> ViewGroup.binding(
    @LayoutRes layoutRes: Int,
    attachToParent: Boolean
): T {
    return DataBindingUtil.inflate(
        LayoutInflater.from(context),
        layoutRes,
        this,
        attachToParent
    )
}


fun EditText.validName(): Boolean {
    return if (this.text.toString().trim().isEmpty()) {
        error = "please enter a name"
        false
    } else if (this.text.toString().length < 2) {
        error = "Name should be at least more then 2 character "
        false
    } else {
        error = null
        true
    }
}

fun EditText.validEmail(): Boolean {
    return if (this.text.toString().trim().isEmpty()) {
        error = "please enter a email"
        false
    } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()) {
        error = "Please enter a valid email "
        false
    } else {
        error = null
        true
    }
}

fun EditText.validInput(): Boolean {
    return if (this.text.toString().trim().isEmpty()) {
        error = "please fill the data"
        false
    } else {
        error = null
        true
    }
}


fun EditText.validPass(): Boolean {
    return if (this.text.toString().trim().isEmpty()) {
        error = "please enter password"
        false
    } else if (this.text.toString().length < 8) {
        error = "password should be at least 8 char"
        false
    } else {
        error = null
        true
    }
}

fun EditText.confirmPass(editText: EditText): Boolean {
    return if (text.toString() == editText.text.toString()) {
        error = null
        true
    } else {
        error = "password not match!"
        false
    }
}

fun EditText.validMobile(): Boolean {
    return if (text.toString().length == 10) {
        error = null
        true
    } else {
        error = "enter a valid mobile"
        false
    }
}

fun Fragment.openActivity(activity: Class<*>) {
    startActivity(
        Intent(requireContext(), activity)
    )
}

fun Fragment.startNewActivity(activity: Class<*>) {
    startActivity(
        Intent(requireContext(), activity).apply {
            flags =  Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
    )
}

fun Fragment.showSnack(msg: String) {
    Snackbar.make(requireView(), msg, Snackbar.LENGTH_SHORT).show()
}



