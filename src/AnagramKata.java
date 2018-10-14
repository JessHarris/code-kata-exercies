import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;

public class AnagramKata {

    public static void main(String [] args){
        Path file = Paths.get("src/words.txt");

       if(Files.exists(file)){
           try {
               List<String> words = Files.readAllLines(file);
               List<String> sortedWords = sortWords(words);
               List<String> anagrams = findAnagramsInSortedList(sortedWords);
               printAnagrams(anagrams);

           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
    public static List<String> sortWords(List<String> words){
        List<String> sortedList = new ArrayList<>();

        for(String word : words){
            char [] charArray = word.toLowerCase().toCharArray();
            Arrays.sort(charArray);
            sortedList.add(new String(charArray));
        }
        return sortedList;
    }

    public static List<String> findAnagramsInSortedList(List<String> sortedWords){
        Map<String, List<String>> anagramMap = new HashMap<>();
        List<String> anagrams = new ArrayList<>();

        for(String sortedWord : sortedWords){
            if(anagramMap.containsKey(sortedWord)){
                List<String> list = anagramMap.get(sortedWord);
                list.add(sortedWord);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(sortedWord);
                anagramMap.put(sortedWord, newList);

            }
        }

        for(Map.Entry<String, List<String>> entry : anagramMap.entrySet()){
            if(entry.getValue().size() > 1){
                for(String anagram : entry.getValue()){
                    anagrams.add(anagram);
                }
            }
        }
        return anagrams;
    }

    public static void printAnagrams(List<String> anagrams){
        System.out.println("Total number of anagrams in the file is " + anagrams.size());
    }
}
