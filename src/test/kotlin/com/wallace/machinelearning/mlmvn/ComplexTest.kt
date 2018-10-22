package com.wallace.machinelearning.mlmvn

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.atan
import kotlin.math.sqrt

class ComplexTest {
    private val complex1 = Complex(2.0, 3.0)
    private val complex2 = Complex(5.0, 10.0)

    private val scalar = 6.0

    @Test
    fun getMagnitude() {
        val magnitude = complex1.magnitude
        val expected = sqrt(13.0)
        assertEquals(expected, magnitude, accuracyDelta)
    }

    @Test
    fun getArgument() {
        val argument = complex1.argument
        val expected = atan(3.0 / 2.0)
        assertEquals(expected, argument, accuracyDelta)
    }

    @Test
    fun getConjugate() {
        val conjugate = complex1.conjugate
        val expected = complex1.copy(imaginary = -complex1.imaginary)
        assertEquals(expected, conjugate)
    }

    @Test
    fun getUnitary() {
        val unitary = complex1.unitary
        assertEquals(1.0, unitary.magnitude, accuracyDelta)
        assertEquals(complex1.argument, unitary.argument, accuracyDelta)
    }

    @Test
    fun plusComplex() {
        val plus = complex1 + complex2
        val expected = Complex(7.0, 13.0)
        assertEquals(expected, plus)
    }

    @Test
    fun plusDouble() {
        val plus = complex1 + scalar
        val expected = Complex(8.0, 3.0)
        assertEquals(expected, plus)
    }

    @Test
    fun doublePlus() {
        val plus = scalar + complex1
        val expected = Complex(8.0, 3.0)
        assertEquals(expected, plus)
    }

    @Test
    fun minusComplex() {
        val minus = complex1 - complex2
        val expected = Complex(-3.0, -7.0)
        assertEquals(expected, minus)
    }

    @Test
    fun minusDouble() {
        val minus = complex1 - scalar
        val expected = Complex(-4.0, complex1.imaginary)
        assertEquals(expected, minus)
    }

    @Test
    fun doubleMinus() {
        val minus = scalar - complex1
        val expected = Complex(4.0, complex1.imaginary)
        assertEquals(expected, minus)
    }

    @Test
    fun timesComplex() {
        val times = complex1 * complex2
        val expected = Complex(-20.0, 35.0)
        assertEquals(expected, times)
    }

    @Test
    fun timesDouble() {
        val times = complex1 * scalar
        val expected = Complex(12.0, 18.0)
        assertEquals(expected, times)
    }

    @Test
    fun doubleTimes() {
        val times = scalar * complex1
        val expected = Complex(12.0, 18.0)
        assertEquals(expected, times)
    }

    @Test
    fun divComplex() {
        val div = complex1 / complex2
        val expected = Complex(.32, -.04)
        assertEquals(expected, div)
    }

    @Test
    fun divDouble() {
        val div = complex1 / scalar
        val expected = Complex(1.0 / 3.0, .5)
        assertEquals(expected, div)
    }

    @Test
    fun doubleDiv() {
        val div = scalar / complex1
        val expected = Complex(12.0 / 13.0, -18.0 / 13.0)
        assertEquals(expected, div)
    }

    @Test
    fun sin() {
        val sin = Complex.sin(complex1)
        val expected = Complex(9.15449914691142957346729954460983255915886056876518297789, -4.16890695996656435075481305885375484357356560475805588996)
        assertEquals(expected, sin, accuracyDelta)
    }

    @Test
    fun cos() {
        val cos = Complex.cos(complex1)
        val expected = Complex(-4.1896256909688072301325550196159737286219454041279210357, -9.1092278937553365979791972627788621213326202389201695649)
        assertEquals(expected, cos, accuracyDelta)
    }

    @Test
    fun exp() {
        val exp = Complex.exp(complex1)
        val expected = Complex(-7.3151100949011025174865361510507893218698794489446322367, 1.0427436562359044141015039404625521939183300604422348975)
        assertEquals(expected, exp, accuracyDelta)
    }

    @Test
    fun exp0() {
        val exp0 = Complex.exp(Complex.ZERO)
        val expected = Complex.ONE
        assertEquals(expected, exp0, accuracyDelta)
    }

    @Test
    fun expTwoPiI() {
        val expTwoPiI = Complex.exp(Complex.TWO_PI_I)
        val expected = Complex.ONE
        assertEquals(expected, expTwoPiI, accuracyDelta)
    }
}