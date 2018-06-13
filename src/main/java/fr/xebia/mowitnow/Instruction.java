package fr.xebia.mowitnow;

/**
 * Instructions
 *
 * @author MORAND
 */
public enum Instruction
{
 /**
  * Droite
  */
  D("D")
  {
    @Override
    public Position execute(final Mouvement mouvement, final Position positionInitiale)
    {
      return mouvement.aDroite(positionInitiale);
    }
  },
 /** Gauche */
  G("G")
  {
    @Override
    public Position execute(final Mouvement mouvement, final Position positionInitiale)
    {
      return mouvement.aGauche(positionInitiale);
    }
  },
 /** Avancer */
  A("A")
  {
    @Override
    public Position execute(final Mouvement mouvement, final Position positionInitiale)
    {
      return mouvement.avancer(positionInitiale);
    }
  };
  private String value;

  /**
   * @param value
   */
  private Instruction(final String value)
  {
    this.value = value;
  }

  /**
   * Retourne la valeur du champ value.
   *
   * @return la valeur du champ value
   */
  public String getValue()
  {
    return value;
  }

  protected abstract Position execute(final Mouvement mouvement, final Position positionInitiale);
}
