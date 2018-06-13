package fr.xebia.mowitnow;

/**
 * Interface pour les mouvements
 *
 * @author MORAND
 */
public interface Mouvement
{

  /**
   * Méthode qui donne la position après avoir tourné à gauche
   * 
   * @param positionInitiale
   *          la position de départ
   * @return la position d'arrivée après avoir tourné à gauche
   */
  public Position aGauche(Position positionInitiale);

  /**
   * Méthode qui donne la position après avoir tourné à droite
   * 
   * @param positionInitiale
   *          la position de départ
   * @return la position d'arrivée après avoir tourné à droite
   */
  public Position aDroite(Position positionInitiale);

  /**
   * Méthode qui donne la position après avoir avancé
   * 
   * @param positionInitiale
   *          la position de départ
   * @return la position d'arrivée après avoir avancé
   */
  public Position avancer(Position positionInitiale);

}
