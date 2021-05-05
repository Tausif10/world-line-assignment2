package formatter

import models.Widget

trait BillFormatter {
  def format(widgets: List[Widget]): String
}
