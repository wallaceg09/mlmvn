package com.wallace.machinelearning.mlmvn.correction

import com.wallace.machinelearning.mlmvn.Complex
import com.wallace.machinelearning.mlmvn.Neuron
import com.wallace.machinelearning.mlmvn.accuracyDelta
import com.wallace.machinelearning.mlmvn.activation.DiscreteActivationFunction
import com.wallace.machinelearning.mlmvn.assertEquals
import org.junit.Test

class MVNErrorCorrectionFunctionTest {
    val bias = Complex(1.0, 5.0)
    val weights = listOf(Complex(2.0, 6.0), Complex(3.0, 7.0))
    val inputs = listOf(Complex(4.0, 8.0), Complex(5.0, 9.0))

    val neuron = Neuron(bias, weights)
    val activationFunction = DiscreteActivationFunction(5)
    val errorCorrectionFunction = MVNErrorCorrectionFunction()

    @Test
    fun correct() {
        val activationBinding = activationFunction.activateTrain(neuron, inputs)
        val desired = Complex.exp((Complex.TWO_PI_I * 4.0) / 5.0)
        val error = desired - activationBinding.activation

        val corrected = errorCorrectionFunction.correct(activationBinding, error)

        val correctedBias = Complex(0.9999999999999997779553950749687, 4.36596232246989756666666666666666666666666666666666)

        val correctedWeights = listOf(
                Complex(-3.07230142024081976272613990004173333333333333333333, 3.4638492898795908587856131334168),
                Complex(-2.7063390977709222700743415417188333333333333333333333333, 3.8298116123494884994671481084272333333333333333333333333))

        assertEquals(correctedBias, corrected.bias, accuracyDelta)

        for (i in 0 until corrected.weights.size) {
            assertEquals(correctedWeights[i], corrected.weights[i], accuracyDelta)
        }
    }
}