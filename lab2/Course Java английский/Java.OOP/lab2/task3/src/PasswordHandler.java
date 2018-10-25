import java.util.Random;

public class PasswordHandler {
  private final static int NUMBER_OF_ARGUMENTS = 2;
  private static final String INCORRECT_DATA = "Wrong arguments";

  private String _availableCharacters;
  private int _lengthOfPassword;

  public PasswordHandler(String[] arguments) {
    try {
      checkNumberOfArguments(arguments.length);
      setPasswordLengthFromString(arguments[0]);
      checkPasswordAvailableCharacters(arguments[1]);
      _availableCharacters = arguments[1];
    } catch (Exception er) {
      System.out.println(INCORRECT_DATA);
    }
  }

  private void checkNumberOfArguments(int number) throws IllegalArgumentException {
    if (number != NUMBER_OF_ARGUMENTS) {
      throw new IllegalArgumentException();
    }
  }

  private void setPasswordLengthFromString(String lengthString) throws IllegalArgumentException {
    try {
      int length = Integer.parseInt(lengthString);
      if (length <= 0) {
        throw new IllegalArgumentException();
      }

      _lengthOfPassword = length;
    } catch (Exception er) {
      throw new IllegalArgumentException();
    }
  }

  private void checkPasswordAvailableCharacters(String symbols) throws IllegalArgumentException {
    if (symbols.isEmpty()) {
      throw new IllegalArgumentException();
    }
  }

  public String generateNewPassword() {
    String password = "";
    Random random = new Random(System.currentTimeMillis() * _availableCharacters.length());
    for(int i = 0; i < _lengthOfPassword; ++i) {
      password += _availableCharacters.charAt(random.nextInt(_availableCharacters.length()));
    }

    return password;
  }

}
