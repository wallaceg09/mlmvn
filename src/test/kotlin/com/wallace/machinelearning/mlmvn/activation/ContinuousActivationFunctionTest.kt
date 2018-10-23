package com.wallace.machinelearning.mlmvn.activation

import com.wallace.machinelearning.mlmvn.Neuron
import com.wallace.machinelearning.mlmvn.accuracyDelta
import com.wallace.machinelearning.mlmvn.assertEquals
import com.wallace.math.Complex
import org.junit.Test

class ContinuousActivationFunctionTest {
    private val neuron = Neuron(Complex(2.0, 3.0), listOf(Complex(4.0, 5.0), Complex(6.0, 7.0)))
    private val inputs = listOf(Complex(8.0, 9.0), Complex(10.0, 11.0))
    val activationFunction = ContinuousActivationFunction()

    @Test
    fun activate() {
        val weightedSum = neuron.weightedSum(inputs)
        val activation = activationFunction.activate(neuron, inputs)
        val expected = weightedSum / weightedSum.argument
        assertEquals(expected, activation, accuracyDelta)
    }
}