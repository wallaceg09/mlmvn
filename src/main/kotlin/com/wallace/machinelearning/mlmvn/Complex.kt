package com.wallace.machinelearning.mlmvn

import kotlin.math.cosh
import kotlin.math.sinh

/**
 * Encapsulates a complex number in the form of `a + bi`.
 * @param real the real component of this complex number, or the `a` of `a + bi`
 * @param imaginary the imaginary component of this complex number, or the `b` of `a + bi`
 */
data class Complex(val real: Double, val imaginary: Double = 0.0) {
    /**
     * The magnitude of this complex number.
     */
    val magnitude: Double by lazy { kotlin.math.sqrt((real * real) + (imaginary * imaginary)) }

    /**
     * The argument, or phase, of this complex number.
     */
    val argument: Double by lazy { kotlin.math.atan2(imaginary, real) }

    /**
     * The complex-conjugate of this complex number.
     *
     */
    val conjugate: Complex by lazy { this.copy(imaginary = -imaginary) }

    operator fun plus(other: Complex): Complex {
        val newReal = real + other.real
        val newImag = imaginary + other.imaginary
        return Complex(real = newReal, imaginary = newImag)
    }

    operator fun plus(scalar: Double): Complex {
        return copy(real = real + scalar)
    }

    operator fun Double.plus(complex: Complex): Complex {
        return complex + this
    }

    operator fun minus(other: Complex): Complex {
        val newReal = real - other.real
        val newImag = imaginary - other.imaginary
        return Complex(real = newReal, imaginary = newImag)
    }

    operator fun minus(scalar: Double): Complex {
        return copy(real = real - scalar)
    }

    operator fun Double.minus(complex: Complex): Complex {
        return complex.copy(real = this - complex.real)
    }

    operator fun times(other: Complex): Complex {
        val newReal = (real * other.real) - (imaginary * other.imaginary)
        val newImag = (real * other.imaginary) + (imaginary * other.real)
        return Complex(newReal, newImag)
    }

    operator fun times(scalar: Double): Complex {
        return Complex(real * scalar, imaginary * scalar)
    }

    operator fun Double.times(complex: Complex): Complex {
        return complex * this
    }

    operator fun div(other: Complex): Complex {
        val conjugate = other.conjugate
        return (this * conjugate) / (other * conjugate).real
    }

    operator fun div(scalar: Double): Complex {
        return Complex(real / scalar, imaginary / scalar)
    }

    operator fun Double.div(complex: Complex): Complex {
        return (this * complex.conjugate) / (complex * complex.conjugate)
    }

    companion object {
        /**
         * `0 + i`
         */
        val I = Complex(0.0, 1.0)

        /**
         * `0 + 0i`
         */
        val ZERO = Complex(0.0, 0.0)

        /**
         * `1 + 0i`
         */
        val ONE = Complex(1.0, 0.0)

        /**
         * `(2 * pi) + i`
         */
        val TWO_PI_I = Complex(kotlin.math.PI * 2.0, 1.0)

        /**
         * The sine operation of the complex number.
         *
         * `sin(a + bi)`
         *
         * @param complex complex number for which the sine operation is to be performed
         */
        fun sin(complex: Complex): Complex {
            val real = kotlin.math.sin(complex.real) * cosh(complex.imaginary)
            val imaginary = kotlin.math.cos(complex.real) * sinh(complex.imaginary)
            return Complex(real, imaginary)
        }

        /**
         * The cosine operation of the complex number.
         *
         * `cos(a + bi)`
         *
         * @param complex complex number for which the cosine operation is to be performed
         */
        fun cos(complex: Complex): Complex {
            val real = kotlin.math.cos(complex.real) * cosh(complex.imaginary)
            val imaginary = kotlin.math.sin(complex.real) * sinh(complex.imaginary)
            return Complex(real, -imaginary)
        }

        /**
         * The exponentiation operation of the complex number.
         *
         * `e^(a + bi)`
         *
         * @param complex complex number for which the exponentiation operation is to be performed
         */
        fun exp(complex: Complex): Complex {
            val realExp = kotlin.math.exp(complex.real)
            val newReal = realExp * kotlin.math.cos(complex.imaginary)
            val newImag = realExp * kotlin.math.cos(complex.imaginary)
            return Complex(newReal, newImag)
        }
    }
}