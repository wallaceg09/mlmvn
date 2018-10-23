package com.wallace.machinelearning.mlmvn

import com.wallace.math.Complex
import org.junit.Before
import org.junit.Test

class NeuronTest {


    private var inputs: List<Complex> = listOf()
    private var neuron1: Neuron = Neuron(Complex.ZERO, listOf())

    @Before
    fun init() {
        val bias = Complex(1.0, 2.0)
        val weights = listOf(Complex(3.0, 4.0))
        inputs = listOf(Complex(5.0, 6.0))
        neuron1 = Neuron(bias, weights)
    }

    @Test
    fun weightedSum() {
        val weightedSum = neuron1.weightedSum(inputs)
        val expected = Complex(-8.0, 40.0)
        assertEquals(expected, weightedSum, accuracyDelta)
    }


}