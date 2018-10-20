package com.wallace.machinelearning.mlmvn.activation

import com.wallace.machinelearning.mlmvn.Complex
import com.wallace.machinelearning.mlmvn.NeuralInputBinding
import com.wallace.machinelearning.mlmvn.Neuron

/**
 * Class that provides a binding between the input and the output of a given neural activation.
 *
 * This class is used by the training algorithms to perform error correction. Error correction methods need to know the
 * inputs, outputs, and weights of a given activation at a minimum.
 */
data class NeuralTrainingActivationBinding(private val neuralInputBinding: NeuralInputBinding, val activation: Complex) {
    val neuron: Neuron get() = neuralInputBinding.neuron
    val inputs: List<Complex> get() = neuralInputBinding.inputs
}