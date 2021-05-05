import formatter.BillFormatter
import models.Widget

class BillGenerator(billFormatter: BillFormatter) {
  def generate(widget: List[Widget]): String = {
    billFormatter.format(widget)
  }
}
