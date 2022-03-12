import java.util.*;

// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RemoveInvalidParanthesis {
    public static void main(String[] args) {
        String s = "(a)())()";
        removeInvalidParentheses(s);
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if(s == null || s.length() == 0) return result;

        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();  // to find the duplicates of already process strings
        boolean flag = false;

        q.add(s);
        set.add(s);

        while(!q.isEmpty() && !flag){  // T.C - O(2^N)
            int size = q.size(); // to go level by level
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(!isValid(curr)){
                    if(!flag){  // if the valid string is alreay found, jsut find the other valis string in the same level. No need to find the children
                        for(int j=0; j<curr.length(); j++){
                            String temp = curr.substring(0,j) + curr.substring(j+1);
                            if(!set.contains(temp)){ // not already processed
                                q.add(temp);
                                set.add(temp);
                            }
                        }
                    }
                } else{
                    result.add(curr);
                    flag = true;
                }
            }
        }

        return result;
    }

    public static boolean isValid(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(Character.isLetter(s.charAt(i)))
                continue;
            else if(s.charAt(i) == '(')
                count++;
            else{
                if(count == 0)  // if count is already 0, then it is invalid
                    return false;
                else
                    count--;
            }
        }

        return count==0;
    }
}

