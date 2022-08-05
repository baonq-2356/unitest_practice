package com.baonq.unittest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.baonq.unittest.databinding.ActivityMainBinding
import java.util.*


/**
 * An {@link Activity} that represents an input form page where the user can provide his name, date
 * of birth and email address. The personal information can be saved to {@link SharedPreferences}
 * by clicking a button.
 */
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    // The helper that manages writing to SharedPreferences.
    private var sharePrefHelper: SharedPrefHelper? = null

    // The validator for the email input field.
    private var emailValidator: EmailValidator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initialize()
    }

    private fun initialize() {

        emailValidator = EmailValidator()
        binding?.emailInput?.addTextChangedListener(emailValidator)

        // Instantiate a SharedPreferencesHelper.
        sharePrefHelper =
                SharedPrefHelper(PreferenceManager.getDefaultSharedPreferences(this))

        // Fill input fields from data retrieved from the SharedPreferences.
        populateUi()
    }

    /**
     * Initialize all fields from the personal info saved in the SharedPreferences.
     */
    private fun populateUi() {
        val sharedPreferenceEntry = sharePrefHelper?.getPersonalInfo()
        binding?.userNameInput?.setText(sharedPreferenceEntry?.name)
        val dateOfBirth = sharedPreferenceEntry?.dob
        binding?.dateOfBirthInput?.init(
            dateOfBirth?.get(Calendar.YEAR) ?: 0, dateOfBirth?.get(Calendar.MONTH) ?: 0,
            dateOfBirth?.get(Calendar.DAY_OF_MONTH) ?: 0, null
        )
        binding?.emailInput?.setText(sharedPreferenceEntry?.email)
    }

    /**
     * Called when the "Save" button is clicked.
     */
    fun onSaveClick(view: View) {
        // Don't save if the fields do not validate.
        if (emailValidator?.isValid() == false) {
            binding?.emailInput?.error = "Invalid email"
            Log.d(TAG, "Not saving personal information: Invalid email")
            return
        }
        // Get the text from the input fields.
        val name = binding?.userNameInput?.text.toString()
        val dateOfBirth = Calendar.getInstance()
        dateOfBirth.set(
            binding?.dateOfBirthInput?.year ?: 0,
            binding?.dateOfBirthInput?.month ?: 0,
            binding?.dateOfBirthInput?.dayOfMonth ?: 0
        )
        val email = binding?.emailInput?.text.toString()
        // Create a Setting model class to persist.
        val sharedPreferenceEntry = SharedPrefEntry(name, dateOfBirth, email)
        // Persist the personal information.
        val isSuccess = sharePrefHelper?.savePersonalInfo(sharedPreferenceEntry)
        if (isSuccess == true) {
            Toast.makeText(
                this,
                "Personal information saved",
                Toast.LENGTH_LONG
            ).show()
            Log.d(TAG, "Personal information saved")
        } else {
            Log.d(TAG, "Failed to write personal information to SharedPreferences")
        }
    }

    /**
     * Called when the "Revert" button is clicked.
     */
    fun onRevertClick(view: View?) {
        populateUi()
        Toast.makeText(this, "Personal information reverted", Toast.LENGTH_LONG).show()
        Log.d(TAG, "Personal information reverted")
    }

    companion object {
        private const val TAG = "NQB"
    }
}
