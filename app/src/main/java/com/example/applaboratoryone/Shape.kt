package com.example.applaboratoryone

sealed class Shape {
    abstract val type: ShapeType

    data class Rectangle(val width: Int, val height: Int) : Shape() {
        override val type = ShapeType.Rectangle
    }

    data class Oval(val majorAxis: Int, val minorAxis: Int) : Shape() {
        override val type = ShapeType.Oval
    }

    data class Line(val length: Int) : Shape() {
        override val type = ShapeType.Line
    }
}

