import org.scalatest.funspec.AnyFunSpec
import org.scalatest.BeforeAndAfter

class TranslatorTest extends AnyFunSpec with BeforeAndAfter {

  var translator: Translator = _

  before {
    translator = new Translator();
  }

  describe("Testing conversion from normal string to a morse code sequence") {
    it("Should return an empty string when passed an empty string (both singleChar and String version)") {
      val inputStr = ""
      val expectedStr = ""

      assert(translator.convertStringToMorse(inputStr) == expectedStr)
    }

    it("Should convert a single character (Lowercase)") {
      val inputStr = "a"
      val expectedStr = ".-"

      assert(translator.convertStringToMorse(inputStr) == expectedStr)
    }


    it("Should convert a single character (uppercase)") {
      val inputStr = "A"
      val expectedStr = ".-"

      assert(translator.convertStringToMorse(inputStr) == expectedStr)
    }

    it("Should convert multiple characters (uppercase + lowercase)") {
      val inputStr = "AaA"
      val expectedStr = ".- .- .-"

      assert(translator.convertStringToMorse(inputStr) == expectedStr)
    }

    it("Should convert multiple characters and a space (uppercase + lowercase)") {
      val inputStr = "AaA B"
      val expectedStr = ".- .- .- / -..."

      assert(translator.convertStringToMorse(inputStr) == expectedStr)
    }

    it("Should throw an exception if a non-alphanumeric character is passed") {
      val inputStr = "!"

      val exception = intercept[IllegalArgumentException] {
        translator.convertStringToMorse(inputStr)
      }
      assert(exception.getMessage == "! is not a valid character to convert to Morse code")
    }
  }

  describe("Testing conversion from Morse code back to a string") {
    it("Should return an empty string when passed an empty string (both singleChar and String version)") {
      val inputStr = ""
      val expectedStr = ""

      assert(translator.convertMorseToString(inputStr) == expectedStr)
    }

    it("Should convert a single Morse code character") {
      val inputStr = ".-"
      val expectedStr = "A"

      assert(translator.convertMorseToString(inputStr) == expectedStr)
    }


    it("Should convert multiple characters") {
      val inputStr = ".- .-"
      val expectedStr = "AA"

      assert(translator.convertMorseToString(inputStr) == expectedStr)
    }

    it("Should convert multiple characters with spaces") {
      val inputStr = ".- .- / .- .-"
      val expectedStr = "AA AA"

      assert(translator.convertMorseToString(inputStr) == expectedStr)
    }

//    it("Should be able to convert back from morse code when there are spaces in words") {
//      val inputStr = ".- / .-"
//      val expectedStr = "A A"
//
//      assert(translator.convertMorseToString(inputStr) == expectedStr)
//    }

    it("Should throw an exception if there are characters present that are not valid morse code") {
      val inputStr = ".--..- .-   .- .-"

      val exception = intercept[IllegalArgumentException] {
        translator.convertMorseToString(inputStr)
      }

      assert(exception.getMessage == ".--..- is not a valid character to convert from Morse code")
    }

  }


}
