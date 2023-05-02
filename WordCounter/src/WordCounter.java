import java.util.*;

class TextAnalyzer {
    public ArrayList<String> words;
    public int spaceCount=0;
    public int englishCharCount=0;
    public int specialCharCount=0;
    public int sentenceCount=1;
    public int totalChar;

    public TextAnalyzer(String str) {
        words = new ArrayList<>();
        processText(str);
    }

    public void processText(String str) {
        String newstr = str.trim();
        for(int i=0;i<newstr.length()-1;i++){
	        if(newstr.charAt(i)=='.' && newstr.charAt(i+1)==' '){
	            sentenceCount++;
	        }
	    }
	    for(int i=0;i<newstr.length();i++){
	        if((newstr.charAt(i)>='A' && newstr.charAt(i)<='Z')
	        ||(newstr.charAt(i)>='a' && newstr.charAt(i)<='z')){
	            englishCharCount++;
	        }
	        else if(newstr.charAt(i)==' '){
	            spaceCount++;
	        }
	        else{
	            specialCharCount++;
	        }
	    }
        
        totalChar= newstr.length()-spaceCount;

        char c=(char)39;
        StringBuilder sb = new StringBuilder(newstr);
        for(int i=0;i<sb.length();i++){
	        if((sb.charAt(i)>='A' && sb.charAt(i)<='Z')||(sb.charAt(i)>='a' && sb.charAt(i)<='z')
	        ||sb.charAt(i)==' '){
	            continue;
	        }
	        else if(sb.charAt(i)=='.' && i<sb.length()-1
	        && ((sb.charAt(i+1)>='A' && sb.charAt(i+1)<='Z')||(sb.charAt(i+1)>='a' && sb.charAt(i+1)<='z'))){
	            continue;
	        }
	        else if(sb.charAt(i)==c && i<sb.length()-1 && sb.charAt(i-1)!=' '
	        && ((sb.charAt(i+1)>='A' && sb.charAt(i+1)<='Z')||(sb.charAt(i+1)>='a' && sb.charAt(i+1)<='z'))){
	            continue;
	        }
	        else{
	                sb.replace(i,i+1," ");
	        }
	    }

        String finalstr = sb.toString();
        String[] s = finalstr.split("\\s+");
        for (int i = 0; i < s.length; i++) {
            words.add(s[i]);
        }
    }

    public int getCharCount() {
        return totalChar;
    }

    public int getEnglishCharCount() {
        return englishCharCount;
    }

    public int getSpecialCharCount() {
        return specialCharCount;
    }

    public int getSentenceCount() {
        return sentenceCount;
    }

    public int getWordCount() {
        return words.size();
    }

    public List<String> getWords() {
        return words;
    }
}

public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your text:    ");
        String str = sc.nextLine();
        TextAnalyzer analyzer = new TextAnalyzer(str);

        System.out.println("\nThere are total " + analyzer.getCharCount() + " Characters");
        System.out.println("There are total " + analyzer.getEnglishCharCount() + " English characters");
        System.out.println("There are total " + analyzer.getSpecialCharCount() + " Special characters");
        System.out.println("There are total " + analyzer.getSentenceCount() + " Sentences");
        System.out.println("\nTotal number of words present in the text is: "+analyzer.getWordCount());
        System.out.print("\nWords are: ");
        System.out.println(analyzer.getWords());
        System.out.println();
    }
}