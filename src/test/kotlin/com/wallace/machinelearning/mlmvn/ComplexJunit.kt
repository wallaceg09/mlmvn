package com.wallace.machinelearning.mlmvn

import com.wallace.math.Complex
import org.junit.Assert

val accuracyDelta = 10e-10

fun assertEquals(expected: Complex, actual: Complex, delta: Double) {
    Assert.assertEquals("Real component is inaccurate.", expected.real, actual.real, delta)
    Assert.assertEquals("Imaginary component is inaccurate.", expected.imaginary, actual.imaginary, delta)
}