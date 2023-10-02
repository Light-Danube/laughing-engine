package com.example.applaboratoryone

data class Figure(var width: Int, var height: Int) {
    private var area: Int = width * height

    fun getArea(): Int {
        return area
    }

    // Custom setter for area
    fun setArea(value: Int) {
        area = value
    }
}

