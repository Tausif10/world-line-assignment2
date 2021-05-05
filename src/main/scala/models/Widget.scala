package models

sealed trait Widget

case class Rectangle(xPosition: Int, yPosition: Int, width: Int, height: Int) extends Widget {
  require(xPosition > 0, "xPosition must be positive")
  require(yPosition > 0, "yPosition must be positive")
  require(width > 0, "width must be positive")
  require(height > 0, "height must be positive")
}

case class Square(xPosition: Int, yPosition: Int, size: Int) extends Widget {
  require(xPosition > 0, "xPosition must be positive")
  require(yPosition > 0, "yPosition must be positive")
  require(size > 0, "size must be positive")
}

case class Ellipse(xPosition: Int, yPosition: Int, hDiameter: Int, vDiameter: Int) extends Widget {
  require(xPosition > 0, "xPosition must be positive")
  require(yPosition > 0, "yPosition must be positive")
  require(hDiameter > 0, "hDiameter must be positive")
  require(vDiameter > 0, "vDiameter must be positive")
}

case class Circle(xPosition: Int, yPosition: Int, diameter: Int) extends Widget {

  require(xPosition > 0, "xPosition must be positive")
  require(yPosition > 0, "yPosition must be positive")
  require(diameter > 0, "diameter must be positive")
}

case class TextBox(rectangle: Rectangle, textBox: Option[String] = None) extends Widget