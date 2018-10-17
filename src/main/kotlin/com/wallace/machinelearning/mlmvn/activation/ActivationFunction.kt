package com.wallace.machinelearning.mlmvn.activation

import com.wallace.machinelearning.mlmvn.Complex
import com.wallace.machinelearning.mlmvn.NeuralInputBinding

interface ActivationFunction {
    fun activate(neuralInputBinding: NeuralInputBinding): Complex
}