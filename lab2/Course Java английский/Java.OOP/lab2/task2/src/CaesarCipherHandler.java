

public class CaesarCipherHandler {
  private final static String ENCODE_COMMAND = "-e";
  private final static String DECODE_COMMAND = "-d";
  private final static int NUMBER_OF_ARGUMENTS = 3;
  private final static int ALPHABET_LENGTH = 26;

  private int _key;
  private String _resultString = "";

  public CaesarCipherHandler(String[] args) {
    try {
      checkNumberOfInputArguments(args.length);
      checkCommandForExistence(args[0]);
      setKeyFromString(args[1]);
      checkInputString(args[2]);
      if (args[0].equals(ENCODE_COMMAND)) {
        createEncodedString(args[2]);
      } else {
        createDecodedString(args[2]);
      }
    } catch (Exception er) {
      System.out.print(er.getMessage());
    }
  }

  private void checkNumberOfInputArguments(int number) {
    if (number != NUMBER_OF_ARGUMENTS) {
      throw new IllegalArgumentException("Wrong arguments");
    }
  }

  private void checkCommandForExistence(String command) {
    if (!(command.equals(ENCODE_COMMAND) || command.equals(DECODE_COMMAND))) {
      throw new IllegalArgumentException("Wrong arguments");
    }
  }

  private void setKeyFromString(String stringKey) {
    try {
      _key = Integer.parseInt(stringKey);
    } catch (Exception er) {
      throw new IllegalArgumentException("Wrong arguments");
    }
  }

  private void createEncodedString(String inputString) {
    for (int i = 0; i < inputString.length(); ++i) {
      int newLetterCode = (int)inputString.charAt(i) + (_key % ALPHABET_LENGTH);
      _resultString += getLetterFromCode(newLetterCode, Character.isLowerCase(inputString.charAt(i)));
    }
  }

  private void createDecodedString(String inputString) {
    for (int i = 0; i < inputString.length(); ++i) {
      int newLetterCode = (int)inputString.charAt(i) - (_key % ALPHABET_LENGTH);
      _resultString += getLetterFromCode(newLetterCode, Character.isLowerCase(inputString.charAt(i)));
    }
  }

  private char getLetterFromCode(int newLetterCode, boolean isLowerCase) {
    if (isLowerCase) {
      if (newLetterCode > (int)'z') {
        return (char)(newLetterCode - (int)'z' + (int)'a' - 1);
      } else if (newLetterCode < (int)'a') {
        return (char)(newLetterCode + (int)'z' - (int)'a' + 1);
      }
    } else {
      if (newLetterCode > (int)'Z') {
        return (char)(newLetterCode - (int)'Z' + (int)'A' - 1);
      } else if (newLetterCode < (int)'A') {
        return (char)(newLetterCode + (int)'Z' - (int)'A' + 1);
      }
    }

    return (char)(newLetterCode);
  }

  private void checkInputString(String str) {
    if (!str.matches("^[a-zA-Z]+$")) {
      throw new IllegalArgumentException("Wrong arguments");
    }
  }

  public String getProcessedString() {
    return _resultString;
  }
}
