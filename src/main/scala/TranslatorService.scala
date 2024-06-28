class TranslatorService(translator : Translator) {

//  ## Add Mocking
//
//  Create a TranslatorService class that:
//
//  Has an instance of your translator, added via dependency injection.
//
//  Exposes two methods that handle input validation.
//
//    Any unsupported character should raise an exception.
//
//    The two methods should:
//    - Accept a character or a string.
//    - Validate the input.
//  - Translate the input.
//    - Return a string containing both the input and the translation.
//
//    It will be tested with ScalaTest and Mockito.


  def convertStringToMorse(strToConvert : String) : String = {
    translator.convertStringToMorse(strToConvert)
  }

  def convertMorseToString(codeToConvert : String) : String = {
    translator.convertMorseToString(codeToConvert)
  }


}
