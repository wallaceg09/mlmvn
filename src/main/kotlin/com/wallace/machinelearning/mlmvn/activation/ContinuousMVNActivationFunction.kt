package com.wallace.machinelearning.mlmvn.activation

import com.wallace.machinelearning.mlmvn.Complex
import com.wallace.machinelearning.mlmvn.NeuralInputBinding
import com.wallace.machinelearning.mlmvn.Neuron

/**
 * Continuous activation function.
 */
class ContinuousMVNActivationFunction : ActivationFunction {
    override fun activate(neuron: Neuron, inputs: List<Complex>): Complex {
        val weightedSum = neuron.weightedSum(inputs)
        return weightedSum / weightedSum.argument
    }

    override fun activateTrain(neuralInputBinding: NeuralInputBinding): NeuralTrainingActivationBinding {
        val activation = neuralInputBinding.weightedSum / neuralInputBinding.weightedSum.argument
        return NeuralTrainingActivationBinding(neuralInputBinding, activation)
    }

    override fun activateTrain(neuron: Neuron, inputs: List<Complex>): NeuralTrainingActivationBinding {
        return activateTrain(NeuralInputBinding(neuron, inputs))
    }
}