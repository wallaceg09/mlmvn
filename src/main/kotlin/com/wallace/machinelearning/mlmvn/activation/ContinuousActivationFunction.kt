package com.wallace.machinelearning.mlmvn.activation

import com.wallace.machinelearning.mlmvn.Neuron
import com.wallace.math.Complex

/**
 * Continuous activation function.
 */
class ContinuousActivationFunction : ActivationFunction {
    override fun activate(neuron: Neuron, inputs: List<Complex>): Complex {
        val weightedSum = neuron.weightedSum(inputs)
        return weightedSum / weightedSum.argument
    }
}