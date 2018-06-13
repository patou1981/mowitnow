package fr.xebia.mowitnow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class MowItNow
{
  /**
   * Méthode main
   * 
   * @param args
   *          le chemin d'accès
   */
  public static void main(final String[] args)
  {

    final Parser<String, Pelouse> pelouseParser = new PelouseParser();
    final Parser<String, Tondeuse> tondeuseParser = new TondeuseParser();
    final Parser<String, List<Instruction>> instructionParser = new InstructionParser();
    final TondeuseService tondeuseService = new TondeuseService(new MouvementImpl());

    if (args.length != 1)
    {
      throw new IllegalArgumentException("Un seul paramètre est attendu");
    }
    final String filePath = args[0];

    try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
    {

      String ligne;
      final Pelouse pelouse = pelouseParser.parse(br.readLine());

      int count = 1;
      Tondeuse tondeuse = null;
      while ((ligne = br.readLine()) != null)
      {
        count++;

        if (count % 2 == 0)
        {
          tondeuse = tondeuseParser.parse(ligne);
        }
        else
        {
          final List<Instruction> instructions = instructionParser.parse(ligne);
          final String position = tondeuseService.execute(tondeuse, pelouse, instructions).toString();
          System.out.println(position);
        }
      }

    }
    catch (final IOException e)
    {
      e.printStackTrace();
    }
  }
}
