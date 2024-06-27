import scala.language.implicitConversions

class Translator {

  var letterToMorse: Map[String, String] = Map[String, String]()
  var morseToLetter: Map[String, String] = Map[String, String]()
  val morseCharacters: Array[String] = Array[String](
    ".-", // A
    "-...", // B
    "-.-.", // C
    "-..", // D
    ".", // E
    ".._.", // F
    "--.", // G
    "....", // H
    "..", // I
    ".---", // J
    "-.-", // K
    ".-..", // L
    "--", // M
    "-.", // N
    "---", // O
    ".--.", // P
    "--.-", // Q
    ".-.", // R
    "...", // S
    "-", // T
    "..-", // U
    "...-", // V
    ".--", // W
    "-..-", // X
    "-.--", // Y
    "--..", // Z
    "-----", // 0
    ".----", // 1
    "..---", // 2
    "...--", // 3
    "....-", // 4
    ".....", // 5
    "-....", // 6
    "--...", // 7
    "---..", // 8
    "----.", // 9
    "/", //" "
  );
  val normalCharacters: Array[String] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ".split("")


  //REFACTOR///////////////////////////////////////////////////////////////////////////
  var i: Int = 0
  while (i < morseCharacters.length) {
    letterToMorse = letterToMorse + (normalCharacters(i) -> morseCharacters(i))
    morseToLetter = morseToLetter + (morseCharacters(i) -> normalCharacters(i))
    i = i + 1
  }

  //////////////////////////////////////////////////////////////////////////////////////

  private def convertCharToMorse(normalChar: String): Option[String] = {
    letterToMorse.get(normalChar.toUpperCase())
  }

  private def convertMorseToLetter(morseString: String): Option[String] = {
    morseToLetter.get(morseString)
  }

  //parses it as a string if it is passed as a character
  implicit def convertCharToMorse(a: Char): Option[String] = {
    val aAsString = a.toString
    convertCharToMorse(aAsString)
  }

  def convertStringToMorse(message: String): String = {
    val convertedToMorse = for {letter <- message} yield convertCharToMorse(letter) match {
      case Some(value) => value
      case None => throw new IllegalArgumentException(s"$letter is not a valid character to convert to Morse code")
    }
    var outputStr = ""
    for (morseCodeChunk <- convertedToMorse) {
      outputStr += morseCodeChunk + " "
    }
    //REMOVES EXTRA SPACE AT THE END
    outputStr = outputStr.slice(0, outputStr.length - 1)
    outputStr
  }

  //  def convertStringToMorse(message : Array[String]) : String = {
  //    var newStr = "";
  //    for (letter <- message) {
  //      newStr = newStr + letter
  //    }
  //    convertStringToMorse(newStr)
  //  }

  def convertMorseToString(morseCode: String): String = {
    if (morseCode.isEmpty) {
      ""
    } else {
      val wordArr = morseCode.split(" / ")
      var finalWord = ""

      for {word <- wordArr} yield {
        val charArr = word.split(" ")
        var wordStr = ""
        for {morseChar <- charArr} {
          val convertedLetter = convertMorseToLetter(morseChar) match {
            case Some(value) => value
            case None => throw new IllegalArgumentException(s"$morseChar is not a valid character to convert from Morse code")
          }
          wordStr = wordStr + convertedLetter
        }
        finalWord = finalWord + wordStr + " "
      }
      finalWord.slice(0, finalWord.length-1)
    }
  }


}
