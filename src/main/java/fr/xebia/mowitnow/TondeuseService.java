package fr.xebia.mowitnow;

import java.util.List;

/**
 * Classe service pour les tondeuses
 *
 * @author MORAND
 */
public class TondeuseService
{

  private final Mouvement mouvement;

  /**
   * Constructeur par défaut
   * 
   * @param mouvement
   *          L'implémentation mouvement choisie
   */
  public TondeuseService(final Mouvement mouvement)
  {
    this.mouvement = mouvement;
  }

  /**
   * Méthode qui exécute l'ensemble des instructions saisie pour une tondeuse
   * 
   * @param tondeuse
   *          la tondeuse à actionner
   * @param pelouse
   *          la pelouse à tondre
   * @param instructions
   *          les instructions
   * @return la position de la tondeuse à la fin des instructions
   */
  public Position execute(final Tondeuse tondeuse, final Pelouse pelouse, final List<Instruction> instructions)
  {
    if (!isPositionTondeusePossible(pelouse, tondeuse))
    {
      throw new IndexOutOfBoundsException("La position de la tondeuse n'est pas sur la pelouse");
    }

    // for (final Instruction instruction : instructions)
    // {
    // execute(tondeuse, pelouse, instruction);
    // }
    instructions.forEach(x -> execute(tondeuse, pelouse, x));

    return tondeuse.getPosition();
  }

  protected boolean isPositionTondeusePossible(final Pelouse pelouse, final Tondeuse tondeuse)
  {
    return tondeuse.getPosition() == null ? false : pelouse.isInside(tondeuse.getPosition().getCoordonnee());
  }

  protected boolean isInstructionValide()
  {
    return true;
  }

  /**
   * Méthode qui modifie la position de la tondeuse en fonction de l'instruction et de la pelouse
   * 
   * @param tondeuse
   *          la tondeuse
   * 
   * @param pelouse
   *          la pelouse à tondre
   * @param instruction
   *          l'instruction de mouvement
   */
  public void execute(final Tondeuse tondeuse, final Pelouse pelouse, final Instruction instruction)
  {
    final Position positionMaj = instruction.execute(mouvement, tondeuse.getPosition());
    if (pelouse.isInside(positionMaj.getCoordonnee()))
    {
      tondeuse.setPosition(positionMaj);
    }
  }
}
