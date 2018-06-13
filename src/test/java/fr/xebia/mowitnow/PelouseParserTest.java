package fr.xebia.mowitnow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

@SuppressWarnings("javadoc")
public class PelouseParserTest
{

  private final PelouseParser pelouseParser = new PelouseParser();

  @Test
  public void parsePelouseInvalidText()
  {
    final Executable executable = () -> pelouseParser.parse("A B");
    assertThrows(IllegalArgumentException.class, executable, "Les données de dimension de la pelouse ne sont pas au format attendu");
  }

  @Test
  public void parsePelouseInvalidSeparator()
  {
    final Executable executable = () -> pelouseParser.parse("10.10");
    assertThrows(IllegalArgumentException.class, executable, "Les données de dimension de la pelouse ne sont pas au format attendu");
  }

  @Test
  public void parsePelouseValideInput()
  {
    final Pelouse pelouse = pelouseParser.parse("10 10");
    Assertions.assertEquals(new Pelouse(10, 10), pelouse);
  }
}
