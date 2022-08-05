package com.baonq.unittest

import android.content.SharedPreferences
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.AdditionalMatchers.eq
import org.mockito.Matchers.anyLong
import org.mockito.Matchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner
import java.util.*

/**
 * This class has not been complete for some sensitive reason
 */
/**
 * Unit tests for the {@link SharedPreferencesHelper} that mocks {@link SharedPreferences}.
 */
@RunWith(MockitoJUnitRunner::class)
class SharedPrefHelperTest {

//    private var sharedPrefEntry: SharedPrefEntry? = null
//    private var mockSharedPrefHelper: SharedPrefHelper? = null
//    private var mockBrokenSharedPrefHelper: SharedPrefHelper? = null
//
//    @Mock
//    var mockSharedPreferences: SharedPreferences? = null
//
//    @Mock
//    var mockBrokenSharedPreferences: SharedPreferences? = null
//
//    @Mock
//    var mockEditor: SharedPreferences.Editor? = null
//
//    @Mock
//    var mockBrokenEditor: SharedPreferences.Editor? = null
//
//    @Before
//    fun initMocks() {
//        // Create SharedPrefEntry to persist.
//        sharedPrefEntry = SharedPrefEntry(TEST_NAME, TEST_DOB, TEST_EMAIL)
//
//        // Create a mocked SharedPreferences.
//        mockSharedPrefHelper = createMockSharedPreference()
//
//        // Create a mocked SharedPreferences that fails at saving data.
//        mockBrokenSharedPrefHelper = createMockSharedPreference()
//    }
//
//    @Test
//    fun sharePrefHelper_SaveAndReadPersonalInformation() {
//        // Save the personal information to SharedPreferences
//        val success = mockSharedPrefHelper?.savePersonalInfo(sharedPrefEntry)
//        assertThat(
//            "Checking that SharedPreferenceEntry.save... return true",
//            success,
//            is (true)
//        )
//    }
//
//    /**
//     * Creates a mocked SharedPreferences.
//     */
//    private fun createMockSharedPreference(): SharedPrefHelper {
//        // Mocking reading the SharedPreferences as if mMockSharedPreferences was previously written
//        // correctly.
//        `when`(mockSharedPreferences?.getString(eq(SharedPrefHelper.KEY_NAME), anyString()))
//            .thenReturn(sharedPrefEntry?.name)
//        `when`(mockSharedPreferences?.getString(eq(SharedPrefHelper.KEY_EMAIL), anyString()))
//            .thenReturn(sharedPrefEntry?.email)
//        `when`(mockSharedPreferences?.getLong(eq(SharedPrefHelper.KEY_DOB), anyLong()))
//            .thenReturn(sharedPrefEntry?.dob?.timeInMillis)
//        // Mocking a successful commit.
//        `when`(mockEditor?.commit()).thenReturn(true)
//        // Return the MockEditor when requesting it.
//        `when`(mockSharedPreferences?.edit()).thenReturn(mockEditor)
//        return SharedPrefHelper(mockSharedPreferences)
//    }
//
//    init {
//        TEST_DOB.set(1998, 4, 16)
//    }
//
//    companion object {
//        private const val TEST_NAME = "Test name"
//        private const val TEST_EMAIL = "Test email"
//        private val TEST_DOB = Calendar.getInstance()
//    }
}
