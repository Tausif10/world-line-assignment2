import formatter.MaterialBillFormatter
import models.{Rectangle, Square}
import org.specs2.mutable.Specification

class BillGeneratorIntegrationSpec extends Specification {

  "Bill generator" should {
    "generate material bill" in {
      val materialBillFormatter = new MaterialBillFormatter
      val billGenerator = new BillGenerator(materialBillFormatter)
      val rectangleWidget = Rectangle(10, 10, 20, 20)
      val square = Square(10, 10, 15)
      val bill = billGenerator.generate(List(rectangleWidget, square))
      bill mustEqual """---------------------------------------
                       |Bill of Materials
                       |---------------------------------------
                       |Rectangle(10, 10) width=20 height=20
                       |Square(10, 10) size=15
                       |""".stripMargin
    }
  }
}
