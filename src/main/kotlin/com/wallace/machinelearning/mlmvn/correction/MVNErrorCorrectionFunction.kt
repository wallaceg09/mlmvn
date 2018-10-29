package com.wallace.machinelearning.mlmvn.correction

import com.wallace.machinelearning.mlmvn.Neuron
import com.wallace.math.Complex

/**
 * Error correction function for a single Multi-Valued Neuron (MVN).
 */
class MVNErrorCorrectionFunction : ErrorCorrectionFunction {
    /**
     * Corrects a [Neuron] based on the error correction rule presented
     * [here](https://drive.google.com/file/d/0B48SMe7JQTsmVlh5THRSMFdxSTg/view).
     *
     * The error correction rule is as such:
     *
     * For the bias weight: `bias + (learningRate / (activationBinding.inputs.size + 1)) * error`
     *
     * For the rest of the weights: `weight[n] + (learningRate / (activationBinding.inputs.size + 1)) * error * input[n].conjugate`
     */
    override fun correct(neuron: Neuron, inputs: List<Complex>, error: Complex, learningRate: Double): Neuron {
        // Optimization to keep this from being calculated multiple times
        val errorTimesLearningDivideInputs = error * learningRate / (inputs.size + 1.0)

        val bias = neuron.bias + errorTimesLearningDivideInputs
        val inputConjugate = inputs.map { it.conjugate }

        val weights = neuron.weights.zip(inputConjugate) { weight, inputConj ->
            weight + (errorTimesLearningDivideInputs * inputConj)
        }

        return Neuron(bias, weights)
    }
}