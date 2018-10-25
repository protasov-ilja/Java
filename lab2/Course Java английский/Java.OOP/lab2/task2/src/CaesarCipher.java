class CaesarCipher {
  private final static String HELP_INFO = "please input 3 arguments: command(-e or -d), offset key, string for processing(only english letters)";

  public static void main(String[] args) {
    try {
      CaesarCipherHandler caesarCipherHandler = new CaesarCipherHandler(args);
      System.out.println(caesarCipherHandler.getProcessedString());
    } catch (Exception er) {
      System.out.println(er.getMessage());
      System.out.println(HELP_INFO);
    }
  }
}