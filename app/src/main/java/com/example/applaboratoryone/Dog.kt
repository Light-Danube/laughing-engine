package com.example.applaboratoryone

class Dog(name: String, age: Int) : Animal(name, age, "Dog"), SpeakVolume {
    override fun makeSound() {
        println("$name the Dog barks!")
    }

    override fun loudVoice() {
        println("$name the Dog barks loudly!")
    }

    override fun softVoice() {
        println("$name the Dog barks softly.")
    }

    // Additional function for Dog
    fun fetch() {
        println("$name fetches a stick.")
    }
}
