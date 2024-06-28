object TranslatorLogic {

  def run:Unit  = {

    val translator = new Translator();
    val translatorService = new TranslatorService(translator);

    UserInteraction.welcomeUser
    var continueTranslating = true

    while (continueTranslating) {
      val translationDirection : Int = UserInteraction.getTranslationDirection
      if (translationDirection==1) {
        //To Morse code
        var isValid : Boolean = false

        while (!isValid) {
          val strToConvert = UserInteraction.textToMorseCode
          try {
            val convertedCode = translatorService.convertStringToMorse(strToConvert)
            isValid = true
            UserInteraction.announceMorseCode(strToConvert, convertedCode)
          } catch {
            case (e: Exception) => println("This is not valid Morse code, have another go!")
          }
        }


        continueTranslating = UserInteraction.goAgain
      } else if (translationDirection==2) {
        //From Morse code
        val codeToConvert = UserInteraction.morseCodeToText
        val convertedText = translatorService.convertMorseToString(codeToConvert)
        UserInteraction.announceText(codeToConvert, convertedText)

        continueTranslating = UserInteraction.goAgain
      } else {
        println("Okay! See you soon!")
        continueTranslating = false
      }
    }
  }





}
