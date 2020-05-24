package tf_api.keras.shape

import org.tensorflow.Operand
import org.tensorflow.Shape
import org.tensorflow.op.Ops
import kotlin.math.abs

fun constArray(tf: Ops, vararg i: Int): Operand<Int> {
    return tf.constant(i)
}

fun shapeOperand(tf: Ops, shape: Shape): Operand<Int> {
    val shapeArray = IntArray(shape.numDimensions())
    for (i in shapeArray.indices) {
        shapeArray[i] = shape.size(i).toInt()
    }
    return tf.constant(shapeArray)
}

fun shapeToIntArray(shape: Shape): IntArray {
    val shapeArray = IntArray(shape.numDimensions())
    for (i in shapeArray.indices) {
        shapeArray[i] = shape.size(i).toInt()
    }
    return shapeArray
}

fun shapeToLongArray(shape: Shape): LongArray {
    val shapeArray = LongArray(shape.numDimensions())
    for (i in shapeArray.indices) {
        shapeArray[i] = shape.size(i)
    }
    return shapeArray
}

fun shapeArrayToString(shape: Shape): String {
    val shapeArray = IntArray(shape.numDimensions())
    for (i in shapeArray.indices) {
        shapeArray[i] = shape.size(i).toInt()
    }
    return shapeArray.contentToString()
}

fun head(vararg dims: Long): Long {
    return dims[0]
}

fun tail(vararg dims: Long): LongArray {
    return dims.copyOfRange(1, dims.size)
}

fun tail(shape: Shape): LongArray {
    val shapeArray = LongArray(shape.numDimensions())
    for (i in shapeArray.indices) {
        shapeArray[i] = shape.size(i)
    }
    return tail(*shapeArray)
}

fun shapeFromDims(vararg dims: Long): Shape {
    return Shape.make(head(*dims), *tail(*dims))
}


fun numElementsInShape(shape: LongArray): Long {
    var prod = 1L
    for (i in shape.indices) {
        prod *= abs(shape[i])
    }
    return prod
}

