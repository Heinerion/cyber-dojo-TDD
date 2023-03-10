package de.hsp.tdd.fizz_buzz;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FizzBuzz {
  public String render(int number) {
    String rendered = "";
    if (number % 3 == 0) {
      rendered += "Fizz";
    }
    if (number % 5 == 0) {
      rendered += "Buzz";
    }

    return rendered.isBlank()
        ? String.valueOf(number)
        : rendered;
  }

  public void print(OutputStream outputStream) {
    try (outputStream) {
      writeNumbers(outputStream);
      outputStream.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeNumbers(OutputStream outputStream) throws IOException {
    for (int number = 1; number <= 100; number++) {
      String line = String.format("%s%n", render(number));
      outputStream.write(line.getBytes(StandardCharsets.UTF_8));
    }
  }
}
