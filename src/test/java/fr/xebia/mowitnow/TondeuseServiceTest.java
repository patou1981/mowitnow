package fr.xebia.mowitnow;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("javadoc")
public class TondeuseServiceTest
{

  public Mouvement       mouvement       = new MouvementImpl();
  public Mouvement       mouvementSpy    = spy(mouvement);
  public TondeuseService tondeuseService = new TondeuseService(mouvementSpy);
  public Position        position        = new Position(0, 0, Orientation.N);
  public Pelouse         pelouse         = new Pelouse(10, 10);

  @org.junit.jupiter.api.Test
  public void executeDShouldgetADroite()
  {
    final Tondeuse tondeuse = new Tondeuse(position);
    tondeuse.setPosition(position);
    tondeuseService.execute(tondeuse, pelouse, Instruction.D);
    verify(mouvementSpy, times(1)).aDroite(position);
    Assertions.assertEquals(new Position(0, 0, Orientation.E), tondeuse.getPosition());
  }

  @Test
  public void executeDShouldgetAGauche()
  {
    final Tondeuse tondeuse = new Tondeuse(position);
    tondeuseService.execute(tondeuse, pelouse, Instruction.G);
    verify(mouvementSpy, times(1)).aGauche(position);
    Assertions.assertEquals(new Position(0, 0, Orientation.O), tondeuse.getPosition());
  }

  @Test
  public void executeDShouldgetAvancerMouvement()
  {
    final Tondeuse tondeuse = new Tondeuse(position);
    tondeuseService.execute(tondeuse, pelouse, Instruction.A);
    verify(mouvementSpy, times(1)).avancer(position);
    Assertions.assertEquals(new Position(0, 1, Orientation.N), tondeuse.getPosition());
  }

  @Test
  public void executeDShouldgetAvancerMouvementImpossible()
  {
    final Tondeuse tondeuse = new Tondeuse(new Position(0, 0, Orientation.S));
    tondeuseService.execute(tondeuse, pelouse, Instruction.A);
    verify(mouvementSpy, times(1)).avancer(new Position(0, 0, Orientation.S));
    Assertions.assertEquals(new Position(0, 0, Orientation.S), tondeuse.getPosition());
  }

}
