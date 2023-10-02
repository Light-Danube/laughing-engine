package com.example.applaboratoryone

class Fish(name: String, age: Int) : Animal(name, age, "Fish") {
    // Fish doesn't make a traditional sound, so we don't override makeSound() here
    // Additional function for Fish
    fun swim() {
        println("$name the Fish is swimming.")
    }
}