package fr.xebia.mowitnow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("javadoc")
public class MouvementTest
{

  private final Mouvement mouvement = new MouvementImpl();

  @Test
  public void aGaucheWithNull()
  {
    Assertions.assertNull(mouvement.aDroite(null));
  }

  @Test
  public void avancerWithNull()
  {
    Assertions.assertNull(mouvement.avancer(null));
  }

  @Test
  public void aGauche()
  {
    Position position = new Position(0, 0, Orientation.N);
    Position positionArrivee = mouvement.aGauche(position);
    Assertions.assertEquals(position.getCoordonnee().getX(), positionArrivee.getCoordonnee().getX());
    Assertions.assertEquals(position.getCoordonnee().getY(), positionArrivee.getCoordonnee().getY());
    Assertions.assertEquals(Orientation.O, positionArrivee.getOrientation());

    position = new Position(0, 0, Orientation.E);
    positionArrivee = mouvement.aGauche(position);
    Assertions.assertEquals(position.getCoordonnee().getX(), positionArrivee.getCoordonnee().getX());
    Assertions.assertEquals(position.getCoordonnee().getY(), positionArrivee.getCoordonnee().getY());
    Assertions.assertEquals(Orientation.N, positionArrivee.getOrientation());

    position = new Position(0, 0, Orientation.S);
    positionArrivee = mouvement.aGauche(position);
    Assertions.assertEquals(position.getCoordonnee().getX(), positionArrivee.getCoordonnee().getX());
    Assertions.assertEquals(position.getCoordonnee().getY(), positionArrivee.getCoordonnee().getY());
    Assertions.assertEquals(Orientation.E, positionArrivee.getOrientation());

    position = new Position(0, 0, Orientation.O);
    positionArrivee = mouvement.aGauche(position);
    Assertions.assertEquals(position.getCoordonnee().getX(), positionArrivee.getCoordonnee().getX());
    Assertions.assertEquals(position.getCoordonnee().getY(), positionArrivee.getCoordonnee().getY());
    Assertions.assertEquals(Orientation.S, positionArrivee.getOrientation());
  }

  @Test
  public void aDroite()
  {
    Position position = new Position(0, 0, Orientation.O);
    Position positionArrivee = mouvement.aDroite(position);
    Assertions.assertEquals(position.getCoordonnee().getX(), positionArrivee.getCoordonnee().getX());
    Assertions.assertEquals(position.getCoordonnee().getY(), positionArrivee.getCoordonnee().getY());
    Assertions.assertEquals(Orientation.N, positionArrivee.getOrientation());

    position = new Position(0, 0, Orientation.N);
    positionArrivee = mouvement.aDroite(position);
    Assertions.assertEquals(position.getCoordonnee().getX(), positionArrivee.getCoordonnee().getX());
    Assertions.assertEquals(position.getCoordonnee().getY(), positionArrivee.getCoordonnee().getY());
    Assertions.assertEquals(Orientation.E, positionArrivee.getOrientation());
  }

  @Test
  public void avancerVersNord()
  {
    final Position position = new Position(0, 0, Orientation.N);
    final Position positionArrivee = mouvement.avancer(position);
    Assertions.assertEquals(position.getCoordonnee().getX(), positionArrivee.getCoordonnee().getX());
    Assertions.assertEquals(position.getCoordonnee().getY() + 1, positionArrivee.getCoordonnee().getY());
    Assertions.assertEquals(Orientation.N, positionArrivee.getOrientation());
  }

  @Test
  public void avancerVersSud()
  {
    final Position position = new Position(0, 0, Orientation.S);
    final Position positionArrivee = mouvement.avancer(position);
    Assertions.assertEquals(position.getCoordonnee().getX(), positionArrivee.getCoordonnee().getX());
    Assertions.assertEquals(position.getCoordonnee().getY() - 1, positionArrivee.getCoordonnee().getY());
    Assertions.assertEquals(Orientation.S, positionArrivee.getOrientation());
  }

  @Test
  public void avancerVersOuest()
  {
    final Position position = new Position(0, 0, Orientation.O);
    final Position positionArrivee = mouvement.avancer(position);
    Assertions.assertEquals(position.getCoordonnee().getX() - 1, positionArrivee.getCoordonnee().getX());
    Assertions.assertEquals(position.getCoordonnee().getY(), positionArrivee.getCoordonnee().getY());
    Assertions.assertEquals(Orientation.O, positionArrivee.getOrientation());
  }

  @Test
  public void avancerVersEst()
  {
    final Position position = new Position(0, 0, Orientation.E);
    final Position positionArrivee = mouvement.avancer(position);
    Assertions.assertEquals(position.getCoordonnee().getX() + 1, positionArrivee.getCoordonnee().getX());
    Assertions.assertEquals(position.getCoordonnee().getY(), positionArrivee.getCoordonnee().getY());
    Assertions.assertEquals(Orientation.E, positionArrivee.getOrientation());
  }
}
