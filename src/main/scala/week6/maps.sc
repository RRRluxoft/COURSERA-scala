
object maps {
  val romanNumerals =  Map("I" -> 1, "V" -> 5, "X" -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")

  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case Some(country) => country
    case None => "mismatch data"
  }

  romanNumerals("I")
  capitalOfCountry get "andorra"
  showCapital("andorra")
  capitalOfCountry get "US"
  showCapital("US")

  val fruit = List("apple", "pear", "orange", "pineapple")
  fruit sortWith(_.length < _.length)
  fruit.sorted

  fruit groupBy (_.head)



}