import org.mockito.ArgumentMatchers.{any, anyString}
import org.mockito.MockitoSugar.{mock, times, verify, when}
import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec

class TranslatorServiceTest extends AnyFunSpec with BeforeAndAfter {

  var translatorService :TranslatorService = _
  var translator :Translator = _

  before {
    translator = mock[Translator]
    translatorService = new TranslatorService(translator)
  }

  describe("translator service with mock translator") {
    it("Should correctly translate when passed a string of characters") {
      val inputStr = ""
      val expectedStr = ""

      when(translator.convertStringToMorse(anyString())).thenReturn(".- .-")

      assert(translator.convertStringToMorse("") == ".- .-")
    }

    it("Should correctly translate when passed a string of Morse characters") {
      val inputStr = ""
      val expectedStr = ""

      when(translator.convertMorseToString(anyString())).thenReturn("AA")

      assert(translator.convertMorseToString("") == "AA")
    }



  }


}
