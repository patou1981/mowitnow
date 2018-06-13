package fr.xebia.mowitnow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * Classe parser pour l'objet tondeuse
 *
 * @author MORAND
 */
public class TondeuseParser implements Parser<String, Tondeuse>
{

  private static final Pattern PATTERN = Pattern.compile("^\\d+ \\d+ [NESO]{1}$");

  /**
   * {@inheritDoc}
   * 
   * @see fr.xebia.mowitnow.Parser#parse(java.lang.Object)
   */
  @Override
  public Tondeuse parse(final String source)
  {
    final Matcher matcher = PATTERN.matcher(source);
    if (!matcher.find())
    {
      throw new IllegalArgumentException("Les données de la tondeuse ne sont pas au format attendu");
    }
    final String[] split = source.split(StringUtils.SPACE);
    if (Integer.valueOf(split[0]) < 0 && Integer.valueOf(split[1]) < 0)
    {
      throw new IllegalArgumentException("Les valeurs entrée pour la tondeuse ne sont pas possibles");
    }
    return new Tondeuse(new Position(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Orientation.valueOf(split[2])));
  }

}
