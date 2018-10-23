package com.wallace.machinelearning.mlmvn

import com.wallace.math.Complex

/**
 * Data class abstracting a binding between an list of inputs and a [Neuron].
 *
 * This data class aids in the error correction process. Error correction for MVN requires several components:
 * the weights, the weighted sum, the inputs, and the error. This class encapsulates the first three without tightly
 * coupling the [Neuron] and `input`. This loose coupling comes into play when activating the same [Neuron]  against
 * many `inputs`, where tightly coupling inputs and a [Neuron] would lead to an unnecessary amount of pointless
 * instantiations.
 */
data class NeuralInputBinding(val neuron: Neuron, val inputs: List<Complex>) {
    /**
     * Cached lazy delegate for [Neuron#weightedSum] with `inputs` as the parameter.
     */
    val weightedSum: Complex by lazy { neuron.weightedSum(inputs) }
}