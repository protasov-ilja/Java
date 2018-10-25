import java.util.Random;

public class PasswordHandler {
  private final static int NUMBER_OF_ARGUMENTS = 2;

  private String _availableCharacters;
  private int _lengthOfPassword;

  public PasswordHandler(String[] arguments) {
    try {
      checkNumberOfArguments(arguments.length);
      setPasswordLengthFromString(arguments[0]);
      checkPasswordAvailableCharacters(arguments[1]);
      _availableCharacters = arguments[1];
    } catch (Exception er) {
      System.out.print(er.getMessage());
    }
  }

  private void checkNumberOfArguments(int number) {
    if (number != NUMBER_OF_ARGUMENTS) {
      throw new IllegalArgumentException("Wrong arguments");
    }
  }

  private void setPasswordLengthFromString(String lengthString) {
    try {
      int length = Integer.parseInt(lengthString);
      if (length <= 0) {
        throw new IllegalArgumentException();
      }

      _lengthOfPassword = length;
    } catch (Exception er) {
      throw new IllegalArgumentException("Wrong arguments");
    }
  }

  private void checkPasswordAvailableCharacters(String symbols) {
    if (symbols.isEmpty()) {
      throw new IllegalArgumentException("Wrong arguments");
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
