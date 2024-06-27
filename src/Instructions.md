# Scala Morse Code Translator

## Overview

You're tasked with creating a unit-tested Morse code translator. The class, once initialized, should have methods that should translate:

- A character to a Morse string,
  - e.g. charToMorse('a') -> ".-"
- A string to a Morse sequence,
  - e.g. stringToMorse("abc") -> (".-","-...","-.-.")

Consider how you will store the Morse characters to make translation easier. Which **data structure** will work best?

Ensure to think about and handle edge cases such as invalid characters, spaces in the input, and case sensitivity.

All of your methods and classes should be tested with ScalaTest.

The project should allow users to type English words/sentences into the CLI and receive the Morse code translation. Do this outside of the translator class. Its responsibility is translating another class can handle interaction etc..

## Extension

It should be able to translate both ways.
The logic for translating both ways won't be exactly the same, but there might be similarities between the two translators (Morse => English, English => Morse). For example, "... --- ..." should translate to "sos" and "sos" should translate to "... --- ...".