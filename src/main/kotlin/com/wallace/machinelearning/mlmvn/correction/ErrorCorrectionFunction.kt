package com.wallace.machinelearning.mlmvn.correction

import com.wallace.machinelearning.mlmvn.Complex
import com.wallace.machinelearning.mlmvn.Neuron
import com.wallace.machinelearning.mlmvn.activation.NeuralTrainingActivationBinding

/**
 * Interface for neural error correction.
 */
interface ErrorCorrectionFunction {
    /**
     * Corrects a given [Neuron], returning a new [Neuron] containing the corrected weights.
     *
     * @param activationBinding [NeuralTrainingActivationBinding] containing the requisite data for error correction,
     * this shall contain the [Neuron] and the input values
     * @param error the error of the neuron
     * @param learningRate the rate of learning. The default value of `1` should be sufficient for most cases
     */
    fun correct(activationBinding: NeuralTrainingActivationBinding, error: Complex, learningRate: Double = 1.0): Neuron
}