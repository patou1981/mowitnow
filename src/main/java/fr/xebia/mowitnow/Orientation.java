package fr.xebia.mowitnow;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumération pour l'orientation
 *
 * @author MORAND
 */
public enum Orientation
{
 /** Nord */
  N(0),
 /** Est */
  E(1),
 /** Sud */
  S(2),
 /** Ouest */
  O(3);

  private static Map<Integer, Orientation> MAP = new HashMap<Integer, Orientation>();

  static
  {
    for (final Orientation orientation : Orientation.values())
    {
      MAP.put(orientation.getValue(), orientation);
    }
  }

  private int value;

  /**
   * Constructeur
   * 
   * @param value
   */
  private Orientation(final int value)
  {
    this.value = value;
  }

  public int getValue()
  {
    return value;
  }

  public static Orientation getOrientation(final int value)
  {
    if (value > 3)
    {
      return Orientation.N;
    }
    else if (value < 0)
    {
      return Orientation.O;
    }
    return MAP.get(value);
  }

}
