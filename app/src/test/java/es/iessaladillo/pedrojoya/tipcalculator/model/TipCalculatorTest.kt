package es.iessaladillo.pedrojoya.tipcalculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TipCalculatorTest {

    @DisplayName("Should throw IllegalArgumentException when bill is negative")
    @Test
    fun `should throw IllegalArgumentException when bill is negative`() {
        assertThrows(IllegalArgumentException::class.java) { TipCalculator(-1f, 10f, 1f).validateData() }
    }

    @DisplayName("Should throw IllegalArgumentException when percentage is negative")
    @Test
    fun `should throw IllegalArgumentException when percentage is negative`() {
        assertThrows(IllegalArgumentException::class.java) { TipCalculator(1f, -10f, 1f).validateData() }
    }

    @DisplayName("Should throw IllegalArgumentException when diners is not positive")
    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `should throw IllegalArgumentException when diners is not positive`(diners: Float) {
        assertThrows(IllegalArgumentException::class.java) { TipCalculator(1f, 10f, diners).validateData() }
    }

    @DisplayName("Should calculate total properly")
    @Test
    fun `should calculate total properly`() {
        val tip = TipCalculator(100f,10f,1f)

        val actual = tip.calculateTotal()

        assertEquals(110f, actual)
    }

    @DisplayName("Should calculate total properly with bill 0")
    @Test
    fun `should calculate total properly with bill 0`() {
        val tip = TipCalculator(0f,10f,1f)

        val actual = tip.calculateTotal()

        assertEquals(0f, actual)
    }

    @DisplayName("Should calculate total properly with percentage 0")
    @Test
    fun `should calculate total properly with percentage 0`() {
        val tip = TipCalculator(100f,0f,1f)

        val actual = tip.calculateTotal()

        assertEquals(100f, actual)
    }

    @DisplayName("Should calculate perDiner properly")
    @Test
    fun `should calculate perDiner properly`() {
        val tip = TipCalculator(100f,10f,2f)

        val actual = tip.calculatePerDiner()

        assertEquals(55f, actual)
    }

    @DisplayName("Should calculate perDinerRounded properly")
    @Test
    fun `should calculate perDinerRounded properly`() {
        val tip = TipCalculator(100f,10f,2f)

        val actual = tip.calculatePerDinerRounded()

        assertEquals(110f, actual)
    }

    @DisplayName("Should calculate perDinerRounded properly when perDinerRounded has 00 as cents")
    @Test
    fun `should calculate perDinerRounded properly when perDinerRounded has 00 as cents`() {
        val tip = TipCalculator(100f,10f,2f)

        val actual = tip.calculatePerDinerRounded()

        assertEquals(110f, actual)
    }

}