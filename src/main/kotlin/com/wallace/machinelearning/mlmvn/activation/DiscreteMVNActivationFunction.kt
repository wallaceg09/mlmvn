package com.wallace.machinelearning.mlmvn.activation

import com.wallace.machinelearning.mlmvn.Complex
import com.wallace.machinelearning.mlmvn.NeuralInputBinding

class DiscreteMVNActivationFunction(private val numberOfSectors: Int) : ActivationFunction {

    private val sectors: List<Double> by lazy {
        val list = mutableListOf<Double>()

        for (sector in 0 until numberOfSectors) {
            list.add((2.0 * kotlin.math.PI * sector) / numberOfSectors)
        }

        list
    }

    private val unitCircle: List<Complex> by lazy {
        sectors.map { Complex.exp(Complex.I * it) }
    }

    override fun activate(neuralInputBinding: NeuralInputBinding): Complex {
        val argument = neuralInputBinding.weightedSum.argument

        for (i in 0 until numberOfSectors) {
            if (i == numberOfSectors - 1) {
                return unitCircle[i]
            } else if (sectors[i] <= argument && argument < sectors[i + 1]) {
                return unitCircle[i]
            }
        }

        return Complex.NAN
    }
}