package com.wallace.machinelearning.mlmvn

/**
 * Multi-Valued [Neuron].
 *
 * This [Neuron] is activation and error-correction function agnostic. It serves only as a data class for the structure
 * of an MVN. Its weights are immutable, and is designed from a functional-programming standpoint. Activation and
 * error-correction functions are to be applied to this [Neuron], instead of this [Neuron] encapsulating said functions.
 * This is because there are multiple types of activation and error-correction functions that may be applied, ergo,
 * encapsulating them here is not advised.
 */
data class Neuron(val bias: Complex, val weights: List<Complex>) {
    /**
     * Calculates the weighted sum for a given list of [inputs].
     */
    fun weightedSum(inputs: List<Complex>): Complex {
        assert(weights.size == inputs.size)

        val sum = weights.zip(inputs) { weight, input -> weight * input }
                .fold(bias) { sum, value -> sum + value }

        return sum
    }
}