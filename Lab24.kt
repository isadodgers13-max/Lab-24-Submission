Function as an input argument to another function

fun add(a: Int, b: Int): Int = a + b
fun subtract(a: Int, b: Int): Int = a - b
fun multiply(a: Int, b: Int): Int = a * b

// Higher-order function that takes another function as input
fun mathOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    println("Addition: ${mathOperation(5, 3, ::add)}")        // 8
    println("Subtraction: ${mathOperation(5, 3, ::subtract)}") // 2
    println("Multiplication: ${mathOperation(5, 3, ::multiply)}") // 15

    // Using lambda expressions instead of named functions
    println("Lambda Add: ${mathOperation(10, 4) { x, y -> x + y }}")
}
---------------------------------------------------------------------------
Returning a function from another function

// Higher-order function that returns another function
fun mathOperation(operation: (Int, Int) -> Int): (Int, Int) -> Int {
    return operation
}

fun main() {
    val addFunction = mathOperation(::add)
    val resultAdd = addFunction(5, 3)
    println("Result of addFunction: $resultAdd")  // 8

    val multiplyFunction = mathOperation(::multiply)
    val resultMultiply = multiplyFunction(5, 3)
    println("Result of multiplyFunction: $resultMultiply")  // 15
}
