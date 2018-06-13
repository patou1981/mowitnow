package fr.xebia.mowitnow;

public class Tondeuse
{

  private Position position;

  public Tondeuse(final Position position)
  {
    this.position = position;
  }

  /**
   * @return the position
   */
  public Position getPosition()
  {
    return position;
  }

  /**
   * @param position
   *          the position to set
   */
  public void setPosition(final Position position)
  {
    this.position = position;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
  {
    return position == null ? null : position.toString();
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
    if (!(arg0 instanceof Tondeuse))
    {
      return false;
    }
    final Tondeuse p = (Tondeuse)arg0;
    return this.getPosition().equals(p.getPosition());
  }

}
