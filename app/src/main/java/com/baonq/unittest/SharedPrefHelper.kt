package com.baonq.unittest

import android.content.SharedPreferences
import java.util.*

/**
 *  Helper class to manage access to {@link SharedPreferences}.
 *
 *  Constructor with dependency injection.
 *
 * @param sharedPreferences The {@link SharedPreferences} that will be used in this DAO.
 */
class SharedPrefHelper(sharedPreferences: SharedPreferences?) {

    // The injected SharedPreferences implementation to use for persistence.
    private var mSharedPreferences: SharedPreferences? = null

    init {
        mSharedPreferences = sharedPreferences
    }

    /**
     * Saves the given {@link SharedPreferenceEntry} that contains the user's settings to
     * {@link SharedPreferences}.
     *
     * @param sharedPreferenceEntry contains data to save to {@link SharedPreferences}.
     * @return {@code true} if writing to {@link SharedPreferences} succeeded. {@code false}
     *         otherwise.
     */
    fun savePersonalInfo(sharedPreferenceEntry: SharedPrefEntry?): Boolean? {
        // Start a SharedPreferences transaction.
        val editor = mSharedPreferences?.edit()
        return editor?.apply{
            putString(KEY_NAME, sharedPreferenceEntry?.name)
            putLong(KEY_DOB, sharedPreferenceEntry?.dob?.timeInMillis ?: 0L)
            putString(KEY_EMAIL, sharedPreferenceEntry?.email)
        }?.commit() // Commit changes to SharedPreferences.
    }

    /**
     * Retrieves the {@link SharedPreferenceEntry} containing the user's personal information from
     * {@link SharedPreferences}.
     *
     * @return the Retrieved {@link SharedPreferenceEntry}.
     */
    fun getPersonalInfo(): SharedPrefEntry {
        // Get data from the SharedPreferences.
        val name = mSharedPreferences?.getString(KEY_NAME, "")
        val dobMillis =
                mSharedPreferences?.getLong(KEY_DOB, Calendar.getInstance().timeInMillis)
        val dateOfBirth = Calendar.getInstance()
        dateOfBirth.timeInMillis = dobMillis ?: 0L
        val email = mSharedPreferences!!.getString(KEY_EMAIL, "")
        // Create and fill a SharedPreferenceEntry model object.
        return SharedPrefEntry(name, dateOfBirth, email)
    }

    companion object {
        // Keys for saving values in SharedPreferences.
        const val KEY_NAME = "key_name"
        const val KEY_DOB = "key_dob_millis"
        const val KEY_EMAIL = "key_email"
    }
}
