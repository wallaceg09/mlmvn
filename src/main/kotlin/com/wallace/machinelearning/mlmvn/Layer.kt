package com.wallace.machinelearning.mlmvn

import com.wallace.machinelearning.mlmvn.activation.ActivationFunction
import com.wallace.math.Complex

/**
 * Abstraction for a simplistic FeedForward layer of an MLMVN.
 * @param neurons the [Neuron]s that make up this layer
 * @param activationFunction the activation function to execute on each [Neuron] in the layer
 */
data class Layer(val neurons: List<Neuron>, val activationFunction: ActivationFunction) {
    /**
     * Activates all [Neuron]s in this layer with the provided [activationFunction] instance, returning a [List] of
     * the [Complex] values of all the [Neuron]s' activations.
     *
     * The order of the outputs should correspond with the order of the [neurons].
     * @param inputs the [List] of inputs to be used for activation for this layer.
     */
    fun activate(inputs: List<Complex>): List<Complex> {
        return neurons.map { activationFunction.activate(it, inputs) }
    }
}