package io.razem.influxdbclient

sealed trait Field extends Product with Serializable {
  def serialize: String
}

case class StringField(key: String, value: String) extends Field {
  def serialize: String = Util.escapeString(key) + "=\"" + value.replaceAll("\"", "\\\\\"") + "\""
}

case class DoubleField(key: String, value: Double) extends Field {
  def serialize: String = Util.escapeString(key) + "=" + value
}

case class LongField(key: String, value: Long) extends Field {
  def serialize: String = Util.escapeString(key) + "=" + value + "i"
}

case class BooleanField(key: String, value: Boolean) extends Field {
  def serialize: String = Util.escapeString(key) + "=" + value
}

case class BigDecimalField(key: String, value: BigDecimal) extends Field {
  def serialize: String = Util.escapeString(key) + "=" + value
}
