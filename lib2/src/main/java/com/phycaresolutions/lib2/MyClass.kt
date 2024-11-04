package com.phycaresolutions.lib2

class MyClass {
}

fun main(){
    println("this is main ")
    //val result: (Int, Int) -> Unit ={ a, b -> println(a+b)}
    //result(10,20)
    //caluclator(100,200){x,y-> x-y}

    //caluclator(10,20){x,y->x+y} //OR
    caluclator(10,20,::addition)
    caluclator(2,3){x,y->x-y}
    even(21){x-> if (x%2==0) println("$x  is the even number") else println("$x  is odd num") }
    val str ="hi"
    val str2="hi"
    if (str == str2)
    {
        println("this is Equval")
    }
    dowork(1000){x-> println(x) }
}
fun even(x:Int, operation: (Int) -> Unit) {
     operation(x)
}

fun caluclator(x: Int, y: Int, operation: (Int,Int)-> Int) {
  val result = operation(x,y)
    println(result)
}
fun addition(x: Int,y: Int) = x+y
fun dowork(x:Int,operation:(Int)->Unit){
     operation(x)
    println("this is do work fun!")
}
