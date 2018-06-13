package fr.xebia.mowitnow;

/**
 * Interface pour les parsers avec une entrée I et une sortie O
 *
 * @author MORAND
 * @param <I>
 *          Entrée
 * @param <O>
 *          Sortie
 */
public interface Parser<I, O>
{
  /**
   * Méthode qui convertie une entrée en sortie
   * 
   * @param source
   *          L'entrée
   * @return la sortie attendue
   */
  O parse(I source);
}
