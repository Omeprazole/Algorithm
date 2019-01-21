public class L127_WordLadder {    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    Set<String> wordSet = new HashSet<>(wordList);
    if(!wordSet.contains(endWord)) return 0;
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    int res = 0;
    int step = 1;
    visited.add(beginWord);
    while(!q.isEmpty()) {
        int size = q.size();


        for(int j = 0; j < size; j++) {
            String curWord = q.poll();
            char[] wordArray = curWord.toCharArray();
            for(int i = 0; i < curWord.length(); i++) {
                char temp = wordArray[i];
                for(char c = 'a'; c <= 'z'; c++) {
                    if(c == wordArray[i]) continue;
                    wordArray[i] = c;
                    String newWord = new String(wordArray);
                    if(newWord.equals(endWord)) {
                        return ++step;
                    }
                    if(wordSet.contains(newWord) && !visited.contains(newWord)) {
                        q.offer(newWord);
                        visited.add(newWord);
                    }
                }
                wordArray[i] = temp;
            }
        }

        step++;
    }
    return 0;
}
}
