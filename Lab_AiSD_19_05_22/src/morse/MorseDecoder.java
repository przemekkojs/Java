package morse;

public class MorseDecoder 
{
	public static char MorseToLetter(String code)
	{		
		if(code.equals(".")) return 'e';
		if(code.equals("_")) return 't';
		if(code.equals("..")) return 'i';
		if(code.equals("._")) return 'a';
		if(code.equals("_.")) return 'n';
		if(code.equals("__")) return 'm';
		if(code.equals("...")) return 's';
		if(code.equals(".._")) return 'u';
		if(code.equals("._.")) return 'r';
		if(code.equals(".__")) return 'w';
		if(code.equals("_..")) return 'd';
		if(code.equals("_._")) return 'k';
		if(code.equals("__.")) return 'g';
		if(code.equals("___")) return 'o';
		if(code.equals("....")) return 'h';
		if(code.equals("..._")) return 'v';
		if(code.equals(".._.")) return 'f';
		if(code.equals("._..")) return 'l';
		if(code.equals(".__.")) return 'p';
		if(code.equals(".___")) return 'j';
		if(code.equals("_...")) return 'b';
		if(code.equals("_.._")) return 'x';
		if(code.equals("_._.")) return 'c';
		if(code.equals("_.__")) return 'y';
		if(code.equals("__..")) return 'z';		
		if(code.equals("--.-")) return 'q';		
		return ' ';		
	}	
	
	public static String LetterToMorse(char letter)
	{
		if(letter == ('e')) return ".";
		if(letter == ('t')) return "_";
		if(letter == ('i')) return "..";
		if(letter == ('a')) return "._";
		if(letter == ('n')) return "_.";
		if(letter == ('m')) return "__";
		if(letter == ('s')) return "...";
		if(letter == ('u')) return ".._";
		if(letter == ('r')) return "._.";
		if(letter == ('w')) return ".__";
		if(letter == ('d')) return "_..";
		if(letter == ('k')) return "_._";
		if(letter == ('g')) return "__.";
		if(letter == ('o')) return "___";
		if(letter == ('h')) return "....";
		if(letter == ('v')) return "..._";
		if(letter == ('f')) return ".._.";
		if(letter == ('l')) return "._..";
		if(letter == ('p')) return ".__.";
		if(letter == ('j')) return ".___";
		if(letter == ('b')) return "_...";
		if(letter == ('x')) return "_.._";
		if(letter == ('c')) return "_._.";
		if(letter == ('y')) return "_.__";
		if(letter == ('z')) return "__..";		
		if(letter == ('q')) return "--.-";		
		return "";		
	}
}