package com.wallace.machinelearning.mlmvn.correction

import com.wallace.machinelearning.mlmvn.Complex
import com.wallace.machinelearning.mlmvn.Neuron
import com.wallace.machinelearning.mlmvn.activation.NeuralTrainingActivationBinding

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
    override fun correct(activationBinding: NeuralTrainingActivationBinding, error: Complex, learningRate: Double): Neuron {
        val bias = activationBinding.neuron.bias + (error * learningRate / (activationBinding.inputs.size + 1.0))
        val inputConjugate = activationBinding.inputs.map { it.conjugate }

        val weights = activationBinding.neuron.weights.zip(inputConjugate) { weight, inputConj ->
            weight + (error * learningRate / (activationBinding.inputs.size + 1.0) * inputConj)
        }

        return Neuron(bias, weights)
    }
}