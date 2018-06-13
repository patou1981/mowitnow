package fr.xebia.mowitnow;

import org.apache.commons.lang3.StringUtils;

/**
 * Classe pour l'objet coordonnée
 * 
 *
 * @author MORAND
 */
public class Coordonnee
{
  private int x;
  private int y;

  /**
   * Constructeur par défaut
   */
  public Coordonnee()
  {
    super();
  }

  /**
   * Constructeur
   * 
   * @param x
   *          valeur x
   * @param y
   *          valeur y
   */
  public Coordonnee(final int x, final int y)
  {
    this.x = x;
    this.y = y;
  }

  public int getX()
  {
    return x;
  }

  public void setX(final int x)
  {
    this.x = x;
  }

  public int getY()
  {
    return y;
  }

  public void setY(final int y)
  {
    this.y = y;
  }

  /**
   * Méthode qui permet d'ajouter à des coordonnées un déplacement via une valeur de coordonnées
   * 
   * @param initial
   *          Coordonnées initiale
   * @param ajout
   *          coordonnées d'ajout
   * @return les coordonnées d'arrivée
   */
  public static Coordonnee ajouter(final Coordonnee initial, final Coordonnee ajout)
  {
    final int x = initial.getX() + ajout.getX();
    final int y = initial.getY() + ajout.getY();
    return new Coordonnee(x, y);
  }

  /**
   * 
   * {@inheritDoc}
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
  {
    return new StringBuilder().append(getX()).append(StringUtils.SPACE).append(getY()).toString();
  }

  /**
   * 
   * {@inheritDoc}
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (!(obj instanceof Coordonnee))
    {
      return false;
    }
    final Coordonnee c = (Coordonnee)obj;
    return c.getX() == this.x && c.getY() == this.y;
  }

}
