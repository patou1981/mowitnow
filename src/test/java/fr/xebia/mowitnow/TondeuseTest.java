package fr.xebia.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("javadoc")
public class TondeuseTest
{

  @Test
  public void toStringNull()
  {
    final Tondeuse tondeuse = new Tondeuse(null);
    Assertions.assertNull(tondeuse.toString());
  }

  @Test
  public void toStringValue()
  {
    final Tondeuse tondeuse = new Tondeuse(new Position(0, 0, Orientation.N));
    Assertions.assertEquals("0 0 N", tondeuse.toString());
  }
}
