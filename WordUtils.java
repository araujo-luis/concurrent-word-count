
public class WordUtils {
	 public static String[] clean(String line){
	      return line.toLowerCase().split("[ \t\r.,;:!?(){]");
	   }
}
