package com.example.applaboratoryone

open class Animal(val name:String, val age:Int, var species: String) {

    //Public function:
    fun getInfo(): String {
        return "Name:  $name, Age: $age, Specie: $species"
    }

    //Abstract function:
    open fun makeSound() {}
}