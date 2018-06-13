package fr.xebia.mowitnow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * Classe du parser de pelouse
 *
 * @author MORAND
 */
public class PelouseParser implements Parser<String, Pelouse>
{

  private static final Pattern PATTERN = Pattern.compile("^\\d+ \\d+$");

  /**
   * {@inheritDoc}
   * 
   * @see fr.xebia.mowitnow.Parser#parse(java.lang.Object)
   */
  @Override
  public Pelouse parse(final String source)
  {
    final Matcher matcher = PATTERN.matcher(source);
    if (!matcher.find())
    {
      throw new IllegalArgumentException("Les données de dimension de la pelouse ne sont pas au format attendu");
    }
    final String[] split = source.split(StringUtils.SPACE);
    if (!Pelouse.isDonneeValide(Integer.valueOf(split[0]), Integer.valueOf(split[1])))
    {
      throw new IllegalArgumentException("Les valeurs entrée pour la pelouse ne sont pas possibles");
    }
    return new Pelouse(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
  }

}
