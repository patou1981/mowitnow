package fr.xebia.mowitnow;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * Classe parser de la ligne des instructions
 *
 * @author MORAND
 */
public class InstructionParser implements Parser<String, List<Instruction>>
{

  /**
   * {@inheritDoc}
   * 
   * @see fr.xebia.mowitnow.Parser#parse(java.lang.Object)
   */
  @Override
  public List<Instruction> parse(final String source)
  {
    final List<Instruction> instructions = new ArrayList<Instruction>();
    if (!StringUtils.isBlank(source))
      for (final char instruction : source.toCharArray())
      {
        instructions.add(Instruction.valueOf(String.valueOf(instruction).toUpperCase()));
      }
    return instructions;
  }

}
