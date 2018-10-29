package com.wallace.machinelearning.mlmvn.activation

import com.wallace.machinelearning.mlmvn.Neuron
import com.wallace.math.Complex

/**
 * Interface for implementations of various MVN and MLMVN activation functions.
 *
 * Implementors must take care that each of these methods return the same results for any single [Neuron] and given
 * `inputs`.
 */
interface ActivationFunction {
    /**
     * Standard activation implementation.
     *
     * This method is to be used if the activation function is not for the purpose of training a [Neuron], as it only
     * returns the activation output.
     *
     * @param neuron the [Neuron] to activate
     * @param inputs the list of [Complex]-valued inputs for the [Neuron] to activate against
     * @return the [Complex]-valued output of the activated [Neuron]
     */
    fun activate(neuron: Neuron, inputs: List<Complex>): Complex
}