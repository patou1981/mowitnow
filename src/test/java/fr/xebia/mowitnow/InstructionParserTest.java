package fr.xebia.mowitnow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Classe de test des instructions
 *
 * @author MORAND
 */
@SuppressWarnings("javadoc")
public class InstructionParserTest
{

  private final InstructionParser instructionParser = new InstructionParser();

  @Test
  public void parseEntreeValide()
  {
    final List<Instruction> instructionAttentues = new ArrayList<>();
    instructionAttentues.add(Instruction.A);
    instructionAttentues.add(Instruction.D);
    instructionAttentues.add(Instruction.G);
    instructionAttentues.add(Instruction.G);
    instructionAttentues.add(Instruction.D);
    instructionAttentues.add(Instruction.A);
    final List<Instruction> instructions = instructionParser.parse("ADGGDA");
    Assertions.assertEquals(instructionAttentues, instructions);
  }

  @Test
  public void parseEntreeInvalide()
  {
    final Executable executable = () -> instructionParser.parse("ARGGDA");
    assertThrows(IllegalArgumentException.class, executable);
  }

  @Test
  public void parseNull()
  {
    final List<Instruction> parse = instructionParser.parse(null);
    Assertions.assertNotNull(parse);
    Assertions.assertTrue(parse.isEmpty());
  }

  @Test
  public void parseEmpty()
  {
    final List<Instruction> parse = instructionParser.parse("");
    Assertions.assertNotNull(parse);
    Assertions.assertTrue(parse.isEmpty());
  }
}
