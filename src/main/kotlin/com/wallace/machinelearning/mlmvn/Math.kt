package com.wallace.machinelearning.mlmvn

operator fun Double.plus(complex: Complex): Complex {
    return complex + this
}

operator fun Double.minus(complex: Complex): Complex {
    return complex.copy(real = this - complex.real)
}

operator fun Double.times(complex: Complex): Complex {
    return complex * this
}

operator fun Double.div(complex: Complex): Complex {
    return (this * complex.conjugate) / (complex * complex.conjugate)
}