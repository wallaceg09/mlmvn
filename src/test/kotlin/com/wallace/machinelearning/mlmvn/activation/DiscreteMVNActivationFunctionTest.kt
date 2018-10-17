package com.wallace.machinelearning.mlmvn.activation

import com.wallace.machinelearning.mlmvn.*
import org.junit.Test
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class DiscreteMVNActivationFunctionTest {
    private val weightlessNeuron: Neuron by lazy {
        val bias = Complex.ZERO
        val weights = listOf(Complex.ONE)

        Neuron(bias, weights)
    }

    private val discreteMVNActivationFunction = DiscreteMVNActivationFunction(2)

    @Test
    fun activateAtSector0() {
        val complex = argumentToComplex(0.0)
        val inputBinding = NeuralInputBinding(weightlessNeuron, listOf(complex))

        val activation = discreteMVNActivationFunction.activate(inputBinding)

        val expected = Complex.exp(Complex.ZERO)

        assertEquals(expected, activation, accuracyDelta)
    }

    @Test
    fun activateBetweenSector0and1() {
        val complex = argumentToComplex(PI - 0.1)

        val inputBinding = NeuralInputBinding(weightlessNeuron, listOf(complex))
        val activation = discreteMVNActivationFunction.activate(inputBinding)

        val expected = Complex.exp(Complex.ZERO)

        assertEquals(expected, activation, accuracyDelta)
    }

    @Test
    fun activateAtSector1() {
        val complex = argumentToComplex(PI)

        val inputBinding = NeuralInputBinding(weightlessNeuron, listOf(complex))
        val activation = discreteMVNActivationFunction.activate(inputBinding)

        val expected = Complex.exp(Complex(0.0, PI))

        assertEquals(expected, activation, accuracyDelta)
    }

    @Test
    fun activateAfterSector1() {
        val complex = argumentToComplex(PI + 0.1)

        val inputBinding = NeuralInputBinding(weightlessNeuron, listOf(complex))
        val activation = discreteMVNActivationFunction.activate(inputBinding)

        val expected = Complex.exp(Complex(0.0, PI))

        assertEquals(expected, activation, accuracyDelta)
    }

    private fun argumentToComplex(argument: Double): Complex {
        val real = cos(argument)
        val imaginary = sin(argument)
        return Complex(real, imaginary)
    }
}