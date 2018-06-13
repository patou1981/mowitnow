package fr.xebia.mowitnow;

import java.util.HashMap;
import java.util.Map;

/**
 * Implémentation des mouvements
 * 
 *
 * @author MORAND
 */
public class MouvementImpl implements Mouvement
{

  private static Map<Orientation, Coordonnee> MAP = new HashMap<Orientation, Coordonnee>();

  static
  {
    MAP.put(Orientation.N, new Coordonnee(0, 1));
    MAP.put(Orientation.E, new Coordonnee(1, 0));
    MAP.put(Orientation.S, new Coordonnee(0, -1));
    MAP.put(Orientation.O, new Coordonnee(-1, 0));
  }

  /**
   * 
   * {@inheritDoc}
   * 
   * @see fr.xebia.mowitnow.Mouvement#aGauche(fr.xebia.mowitnow.Position)
   */
  public Position aGauche(final Position positionInitiale)
  {
    return tourner(positionInitiale, -1);
  }

  /**
   * 
   * {@inheritDoc}
   * 
   * @see fr.xebia.mowitnow.Mouvement#aDroite(fr.xebia.mowitnow.Position)
   */
  public Position aDroite(final Position positionInitiale)
  {
    return tourner(positionInitiale, +1);
  }

  /**
   * Méthode permettant de tourner
   */
  private Position tourner(final Position positionInitiale, final int valeur)
  {
    if (positionInitiale == null)
    {
      return null;
    }
    return new Position(positionInitiale.getCoordonnee(), Orientation.getOrientation(positionInitiale.getOrientation().getValue() + valeur));
  }

  /**
   * 
   * {@inheritDoc}
   * 
   * @see fr.xebia.mowitnow.Mouvement#avancer(fr.xebia.mowitnow.Position)
   */
  public Position avancer(final Position positionInitiale)
  {
    if (positionInitiale == null)
    {
      return null;
    }
    final Coordonnee coordonnee = MAP.get(positionInitiale.getOrientation());
    final Coordonnee coordonneeInitiale = positionInitiale.getCoordonnee();
    return new Position(Coordonnee.ajouter(coordonneeInitiale, coordonnee), positionInitiale.getOrientation());
  }

}
