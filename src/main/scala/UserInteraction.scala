import scala.io.StdIn.{readInt, readLine}
import scala.util.matching.Regex

object UserInteraction {

  def welcomeUser: Unit = {
    println("Welcome to the Morse code translator")
    println("You will be able to translate to/from Morse code with this tool")
  }

  def getTranslationDirection : Int = {
    println("Would you like to convert:")
    println("1. From text to Morse code")
    println("2. From Morse code to text")
    println("3. Quit")

    var isValidAnswer = false

    var userAnswer : Int = 0
    while (!isValidAnswer) {
      userAnswer = readLine() match {
        case "1" => {
          isValidAnswer=true
          1
        }
        case "2" => {
          isValidAnswer=true
          2
        }
        case "3" => {
          isValidAnswer=true
          3
        }
        case _ => {
          println("Must be either 1, 2 or 3")
          0
        }
      }
    }
    userAnswer
  }

  def textToMorseCode: String = {

    var isValidAnswer = false
    val numberPattern: Regex = "^[A-Za-z0-9\\s]*$".r

    var userAnswer : String = ""
    while (!isValidAnswer) {
      println("You have chosen to convert from text to Morse code!")
      println("Enter some text below, it must be alphanumeric and cannot include punctuation (except spaces)")
      var userInput = readLine()
      userAnswer = numberPattern.findFirstMatchIn(userInput) match {
        case Some(value) => {
          isValidAnswer=true
          value.toString()
        }
        case None => {
          println("Invalid string, must be ONLY alphanumeric characters and spaces")
          ""
        }
      }
    }
    userAnswer
  }

  def announceMorseCode(originalText: String, codeToPresent : String) : Unit = {
    println("The text you asked to convert was:")
    println(originalText)
    println("In Morse code, this is:")
    println(codeToPresent)
    println("/ represents a space")
  }

  def morseCodeToText: String = {

    var isValidAnswer = false
    val numberPattern: Regex = "[-./\\s]*".r

    var userAnswer : String = ""
    while (!isValidAnswer) {
      println("You have chosen to convert from Morse code to text!")
      println("Enter some text below, it must be be valid Morse code. Separate individual sections of code with a space, and new words with \"space/space\" ")
      var userInput = readLine()
      userAnswer = numberPattern.findFirstMatchIn(userInput) match {
        case Some(value) => {
          isValidAnswer=true
          value.toString()
        }
        case None => {
          println("Invalid morse code.")
          ""
        }
      }
    }
    userAnswer
  }

  def announceText(originalCode: String, textToPresent : String) : Unit = {
    println("The Morse code you asked to convert was:")
    println(originalCode)
    println("In text, this is:")
    println(textToPresent)
  }

  def goAgain : Boolean = {
    println("Would you like to do another translation?")
    println("1. Yes")
    println("2. No")

    var isValidAnswer = false
    val numberPattern: Regex = "^[1-2]$".r

    var userAnswer : String = ""
    while (!isValidAnswer) {
      userAnswer = numberPattern.findFirstMatchIn(readLine()) match {
        case Some(value) => {
          isValidAnswer=true
          value.toString()
        }
        case None => {
          println("Invalid string")
          ""
        }
      }
    }
    if (userAnswer=="1") true
    else false
  }

}
