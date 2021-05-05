package formatter

import models._

class MaterialBillFormatter extends BillFormatter {

  override def format(widgets: List[Widget]): String = {
    val dashLine = "---------------------------------------"
    val widgetsInFormat = widgets.map {
      case widget: Rectangle => s"Rectangle(${widget.xPosition}, ${widget.yPosition}) width=${widget.width} height=${widget.height}"
      case widget: Square => s"Square(${widget.xPosition}, ${widget.yPosition}) size=${widget.size}"
      case widget: Ellipse => s"Ellipse(${widget.xPosition}, ${widget.yPosition}) diameterH=${widget.hDiameter} diameterV=${widget.vDiameter}"
      case widget: Circle => s"Circle(${widget.xPosition}, ${widget.yPosition}) size=${widget.diameter}"
      case widget: TextBox => {
        import widget.rectangle._
        val mandatoryPartFormat = s"TextBox($xPosition, $yPosition) width=$width height=$height"
        widget.textBox.fold(mandatoryPartFormat)(text => s"""$mandatoryPartFormat text="$text"""")
      }
    }
    s"""$dashLine
       |Bill of Materials
       |$dashLine
       |${widgetsInFormat.mkString("\n")}
       |""".stripMargin
  }
}
