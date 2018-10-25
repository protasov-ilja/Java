import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class BaseIOValidationTest {
  protected ByteArrayOutputStream output = new ByteArrayOutputStream();
  private final PrintStream old = System.out;

  @Before
  public void setUp() {
    resetOutput();
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(old);
  }

  protected void resetOutput() {
    output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));
  }

  public static class TestMsg {
    private int testId;
    private String input;
    private String details;

    private TestMsg(int testId, String input, String details) {
      this.testId = testId;
      this.input = input;
      this.details = details;
    }

    public static TestMsg of(int testId, String input, String details) {
      return new TestMsg(testId, input, details);
    }

    public static TestMsg of(int testId, String[] args, String details) {
      return new TestMsg(testId, String.join(" ", args), details);
    }

    @Override
    public String toString() {
      return String.format(
              "CaesarCipherTest #%s. Input:\n" +
                      "%s\n" +
                      "Details: %s\n",
              testId,
              input,
              details
      );
    }
  }


}
