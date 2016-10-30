import java.util.*;

public class WordLadder{
    
    public static void main(String[] args){
        Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");

        Set<String> wordList2 = new HashSet<String>();
        wordList2.add("a");
        wordList2.add("b");
        wordList2.add("c");

        Set<String> wordList3 = new HashSet<String>();
        wordList3.add("hot");
        wordList3.add("dog");

        System.out.println(ladderLength("hit", "cog", wordList));
        System.out.println(ladderLength("a", "c", wordList2));
        System.out.println(ladderLength("hot", "dog", wordList3));
    }

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList){
        Queue<String> queue = new LinkedList<String>();

        queue.add(beginWord);
        int layer = 1;
        wordList.add(endWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j = 0; j < size; j++){
                String currentStr = queue.remove();

                if(currentStr.compareTo(endWord) == 0)
                    return layer;
                
                List<String> allAdjacent = findAdjacent(currentStr, wordList);
                for (int i = 0; i < allAdjacent.size(); i++) {
                    queue.add(allAdjacent.get(i));      
                }
                
            }
            layer++;        
        }
        return 0;
    }

    public static List<String> findAdjacent(String currentStr, Set<String> wordList){
        List<String> allAdj = new LinkedList<String>();

        for (int i = 0; i < currentStr.length(); i++) {
            char[] tmp = currentStr.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                tmp[i] = j;
                String tmpStr = new String(tmp);

                if (tmpStr.compareTo(currentStr) != 0 && wordList.remove(tmpStr)) {
                    allAdj.add(tmpStr);
                }
            }
        }
        return allAdj;
    }
}