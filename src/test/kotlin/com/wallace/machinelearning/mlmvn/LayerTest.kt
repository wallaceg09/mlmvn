package com.wallace.machinelearning.mlmvn

import com.wallace.machinelearning.mlmvn.activation.ContinuousActivationFunction
import com.wallace.math.Complex
import org.junit.Assert.assertEquals
import org.junit.Test

class LayerTest {

    @Test
    fun activate() {
        // (1.1 + 2.2i, 2.3 + 4.7i)
        val inputs = listOf(Complex(1.1, 2.2), Complex(2.3, 4.7))

        // Bias = 7.3 + 6.5i
        // Weights = (4.3 + 8.2i, 2.9 + 10.1i)
        val neuron1 = Neuron(Complex(7.3, 6.5), listOf(Complex(4.3, 8.2), Complex(2.9, 10.1)))

        // Bias = 3.4 + 5.1i
        // Weights = (9 + -3.4i, 8.7 + 6.6i)
        val neuron2 = Neuron(Complex(3.4, 5.1), listOf(Complex(9.0, -3.4), Complex(8.7, 6.6)))

        val activationFunction = ContinuousActivationFunction()

        val layer = Layer(listOf(neuron1, neuron2), activationFunction)

        val activation = layer.activate(inputs)

        val expected = listOf(activationFunction.activate(neuron1, inputs), activationFunction.activate(neuron2, inputs))

        // Only assumption that is needed to be tested is whether the order of the activation's output is exactly the
        // order of the neuron list
        assertEquals(expected, activation)
    }
}