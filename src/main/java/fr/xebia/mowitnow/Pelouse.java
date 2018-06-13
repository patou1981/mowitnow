package fr.xebia.mowitnow;

/**
 * 
 * Classe pour l'objet pelouse
 *
 * @author MORAND
 */
public class Pelouse
{
  final private int minX = 0;
  final private int minY = 0;
  private int       maxX = 0;
  private int       maxY = 0;

  /**
   * Constructeur par défaut
   * 
   * @param maxX
   *          valeur x du coin supérieur droit
   * @param maxY
   *          valeur y du coin supérieur droit
   */
  public Pelouse(final int maxX, final int maxY)
  {
    this.maxX = maxX;
    this.maxY = maxY;
  }

  public int getMaxX()
  {
    return maxX;
  }

  public void setMaxX(final int maxX)
  {
    this.maxX = maxX;
  }

  public int getMaxY()
  {
    return maxY;
  }

  public void setMaxY(final int maxY)
  {
    this.maxY = maxY;
  }

  public int getMinX()
  {
    return minX;
  }

  public int getMinY()
  {
    return minY;
  }

  /**
   * Méthode qui retourne si les coordonnées sont à l'instérieur de la pelouse
   * 
   * @param coordonnee
   *          les coordonnées à vérifier
   * @return <i>true</i> si les coordoonnées sont à l'intérieur, <i>false</i> sinon
   */
  public boolean isInside(final Coordonnee coordonnee)
  {
    return this.minX <= coordonnee.getX() && this.minY <= coordonnee.getY() && this.maxX >= coordonnee.getX() && this.maxY >= coordonnee.getY();
  }

  /**
   * Fonction qui retourne si les données saisie en entrée sont valides pour une pelouse
   * 
   * @param x
   *          la valeur x
   * @param y
   *          la valeur y
   * @return <i>true</i> si les valeurs sont possible, <i>false</i> sinon
   */
  public static boolean isDonneeValide(final int x, final int y)
  {
    return x > 0 && y > 0;
  }

  /**
   * {@inheritDoc}
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object arg0)
  {
    if (this == arg0)
    {
      return true;
    }
    if (!(arg0 instanceof Pelouse))
    {
      return false;
    }
    final Pelouse p = (Pelouse)arg0;
    return this.maxX == p.getMaxX() && this.maxY == p.getMaxY();
  }

}
