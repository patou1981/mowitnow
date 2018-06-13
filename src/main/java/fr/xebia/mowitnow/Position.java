package fr.xebia.mowitnow;

/**
 * Classe pour l'objet position
 * 
 *
 * @author MORAND
 */
public class Position
{
  private Coordonnee  coordonnee;
  private Orientation orientation;

  /**
   * Constructeur
   * 
   * @param x
   *          la valeur x
   * @param y
   *          la valeur y
   * @param orientation
   *          l'orientation
   */
  public Position(final int x, final int y, final Orientation orientation)
  {
    this.coordonnee = new Coordonnee(x, y);
    this.orientation = orientation;
  }

  /**
   * Constructeur
   * 
   * @param coordonnee
   *          les coordonnées
   * 
   * @param orientation
   *          l'orientation
   */
  public Position(final Coordonnee coordonnee, final Orientation orientation)
  {
    this(coordonnee.getX(), coordonnee.getY(), orientation);
  }

  public Coordonnee getCoordonnee()
  {
    if (coordonnee == null)
    {
      coordonnee = new Coordonnee();
    }
    return coordonnee;
  }

  public void setCoordonnee(final Coordonnee coordonnee)
  {
    this.coordonnee = coordonnee;
  }

  public Orientation getOrientation()
  {
    return orientation;
  }

  public void setOrientation(final Orientation orientation)
  {
    this.orientation = orientation;
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
    if (!(obj instanceof Position))
    {
      return false;
    }
    final Position p = (Position)obj;
    if (p.getOrientation().equals(this.orientation))
    {
      return p.getCoordonnee().equals(this.getCoordonnee());
    }
    return false;
  }

  /**
   * 
   */
  @Override
  public String toString()
  {
    return new StringBuilder().append(coordonnee.toString()).append(" ").append(orientation.toString()).toString();
  }
}
