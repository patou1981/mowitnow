package fr.xebia.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("javadoc")
public class PelouseTest
{

  @Test
  public void isInsideTrue()
  {
    final Pelouse pelouse = new Pelouse(10, 10);
    Coordonnee coordonnee = new Coordonnee(0, 10);
    Assertions.assertEquals(true, pelouse.isInside(coordonnee));

    coordonnee = new Coordonnee(0, 0);
    Assertions.assertEquals(true, pelouse.isInside(coordonnee));

    coordonnee = new Coordonnee(10, 10);
    Assertions.assertEquals(true, pelouse.isInside(coordonnee));

    coordonnee = new Coordonnee(5, 5);
    Assertions.assertEquals(true, pelouse.isInside(coordonnee));
  }

  @Test
  public void isInsideFalse()
  {
    final Pelouse pelouse = new Pelouse(-1, 10);
    Coordonnee coordonnee = new Coordonnee(0, 10);
    Assertions.assertEquals(false, pelouse.isInside(coordonnee));

    coordonnee = new Coordonnee(0, -1);
    Assertions.assertEquals(false, pelouse.isInside(coordonnee));

    coordonnee = new Coordonnee(10, 11);
    Assertions.assertEquals(false, pelouse.isInside(coordonnee));

    coordonnee = new Coordonnee(15, -5);
    Assertions.assertEquals(false, pelouse.isInside(coordonnee));
  }

}
