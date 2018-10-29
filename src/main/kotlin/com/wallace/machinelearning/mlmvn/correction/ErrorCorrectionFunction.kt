package com.wallace.machinelearning.mlmvn.correction

import com.wallace.machinelearning.mlmvn.Neuron
import com.wallace.math.Complex

/**
 * Interface for neural error correction.
 */
interface ErrorCorrectionFunction {
    /**
     * Corrects a given [Neuron], returning a new [Neuron] containing the corrected weights.
     *
     * @param neuron the neuron to be corrected
     * @param inputs the list of inputs that activated the neuron that is to be corrected
     * @param error the error of the neuron
     * @param learningRate the rate of learning. The default value of `1` should be sufficient for most cases
     */
    fun correct(neuron: Neuron, inputs: List<Complex>, error: Complex, learningRate: Double = 1.0): Neuron
}