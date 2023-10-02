package com.example.applaboratoryone

class Bird(name: String, age: Int) : Animal(name, age, "Bird"), SpeakVolume {
    override fun makeSound() {
        println("$name the Bird sings!")
    }

    override fun loudVoice() {
        println("$name the Bird sings loudly!")
    }

    override fun softVoice() {
        println("$name the Bird sings softly.")
    }

    // Additional function for Bird
    fun fly() {
        println("$name the Bird is flying.")
    }
}