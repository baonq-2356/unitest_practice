package com.baonq.unittest

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 *  All the input cases we can think of:
 *  1. Correct Input: test@gmail.com
 *  2. Email with subdomain: test@gmail.co.uk
 *  3. Without .com: test@gmail
 *  4. With extra characters: test@gmail..com
 *  5. With no username: @gmail.com
 *  6. Empty Input:
 *  7. Null value: this can occur if we initialize the string from this field to be null.
 *      It does not hurt to have a test case for null check in place.
 */
class EmailValidatorTest {

    // 1. Correct Input
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    // 2. Email with subdomain
    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    // 3. Without .com
    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    // 4. With extra characters
    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    // 5. With no username
    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    // 6. Empty Input
    @Test
    fun emailValidator_EmptyInput_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    // 7. Null value
    @Test
    fun emailValidator_NullPointer_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }
}
