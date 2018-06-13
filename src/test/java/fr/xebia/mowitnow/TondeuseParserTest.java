package fr.xebia.mowitnow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

@SuppressWarnings("javadoc")
public class TondeuseParserTest
{
  private final TondeuseParser tondeuseParser = new TondeuseParser();

  @Test
  public void parseTondeuseInvalidCoordonnee()
  {
    final Executable executable = () -> tondeuseParser.parse("A 10 N");
    assertThrows(IllegalArgumentException.class, executable, "Les données de la tondeuse ne sont pas au format attendu");
  }

  @Test
  public void parseTondeuseInvalidOrientation()
  {
    final Executable executable = () -> tondeuseParser.parse("10 10 R");
    assertThrows(IllegalArgumentException.class, executable, "Les données de la tondeuse ne sont pas au format attendu");
  }

  @Test
  public void parseTondeuseInvalidSeparator()
  {
    final Executable executable = () -> tondeuseParser.parse("10.10.N");
    assertThrows(IllegalArgumentException.class, executable, "Les données de la tondeuse ne sont pas au format attendu");
  }

  @Test
  public void parseTondeuseValideInput()
  {
    final Tondeuse Tondeuse = tondeuseParser.parse("10 10 N");
    Assertions.assertEquals(new Tondeuse(new Position(10, 10, Orientation.N)), Tondeuse);
  }
}
