public class Lint624_Remove_Substrings {
    public int minLength(String s, Set<String> dict) {
        // write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }

        if(dict == null || dict.size() == 0) {
            return s.length();
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        visited.add(s);
        int min = s.length();
        String result = s;
        while(!q.isEmpty()) {
            String cur = q.poll();
            int found = -1;
            for(String sub : dict) {
                found = cur.indexOf(sub);
                while(found != -1) {
                    String newString = cur.substring(0, found) + cur.substring(found + sub.length(), cur.length());

                    if(!visited.contains(newString)) {
                        if(newString.length() < min) {
                            result = newString;
                            min = newString.length();
                        }
                        visited.add(newString);
                        q.offer(newString);
                    }
                    found = newString.indexOf(sub, found + 1);
                }
            }
        }
        s = result;
        return min;
    }
}
