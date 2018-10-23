package com.wallace.machinelearning.mlmvn.activation

import com.wallace.machinelearning.mlmvn.Complex
import com.wallace.machinelearning.mlmvn.Neuron
import com.wallace.machinelearning.mlmvn.accuracyDelta
import com.wallace.machinelearning.mlmvn.assertEquals
import org.junit.Test
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class DiscreteActivationFunctionTest {
    private val weightlessNeuron: Neuron by lazy {
        val bias = Complex.ZERO
        val weights = listOf(Complex.ONE)

        Neuron(bias, weights)
    }

    private val discreteMVNActivationFunction = DiscreteActivationFunction(2)

    @Test
    fun activateAtSector0() {
        val complex = argumentToComplex(0.0)

        val activation = discreteMVNActivationFunction.activate(weightlessNeuron, listOf(complex))

        val expected = Complex.exp(Complex.ZERO)

        assertEquals(expected, activation, accuracyDelta)
    }

    @Test
    fun activateBetweenSector0and1() {
        val complex = argumentToComplex(PI - 0.1)

        val activation = discreteMVNActivationFunction.activate(weightlessNeuron, listOf(complex))

        val expected = Complex.exp(Complex.ZERO)

        assertEquals(expected, activation, accuracyDelta)
    }

    @Test
    fun activateAtSector1() {
        val complex = argumentToComplex(PI)

        val activation = discreteMVNActivationFunction.activate(weightlessNeuron, listOf(complex))

        val expected = Complex.exp(Complex(0.0, PI))

        assertEquals(expected, activation, accuracyDelta)
    }

    @Test
    fun activateAfterSector1() {
        val complex = argumentToComplex(PI + 0.1)

        val activation = discreteMVNActivationFunction.activate(weightlessNeuron, listOf(complex))

        val expected = Complex.exp(Complex(0.0, PI))

        assertEquals(expected, activation, accuracyDelta)
    }

    private fun argumentToComplex(argument: Double): Complex {
        val real = cos(argument)
        val imaginary = sin(argument)
        return Complex(real, imaginary)
    }
}