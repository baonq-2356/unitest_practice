package com.baonq.unittest

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

/**
 * An Email format validator for {@link android.widget.EditText}.
 */
class EmailValidator: TextWatcher {

    private var isValid = false

    fun isValid() = isValid

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        /*No-op*/
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        /*No-op*/
    }

    override fun afterTextChanged(p0: Editable?) {
        isValid = isValidEmail(p0)
    }

    companion object {
        /**
         * Email validation pattern.
         */
        private val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9+._%\\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
        )

        /**
         * Validates if the given input is a valid email address.
         *
         * @param email     The email to validate.
         * @return {@code true} if the input is a valid email. {@code false} otherwise.
         */
        fun isValidEmail(email: CharSequence?): Boolean {
            return email != null && EMAIL_PATTERN.matcher(email).matches()
        }
    }
}
