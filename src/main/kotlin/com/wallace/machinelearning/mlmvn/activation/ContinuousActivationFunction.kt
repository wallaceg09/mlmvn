package com.wallace.machinelearning.mlmvn.activation

import com.wallace.machinelearning.mlmvn.NeuralInputBinding
import com.wallace.machinelearning.mlmvn.Neuron
import com.wallace.math.Complex

/**
 * Continuous activation function.
 */
class ContinuousActivationFunction : ActivationFunction {
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