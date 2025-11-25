import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        boolean isEmpty = true;
        int start = 0;
        int end = 0;
        for (int i = 0; i<my_string.length(); i++) {
            if (my_string.charAt(i) == ' ') {
                if (isEmpty) {
                    continue;
                } else {
                    isEmpty = true;
                    end = i;
                    list.add(my_string.substring(start, end));
                    continue;
                }
            } else {
                if (isEmpty) {
                    isEmpty = false;
                    start = i;
                } else {
                    continue;
                }
            }
        }
        if (!isEmpty) {
            list.add(my_string.substring(start, my_string.length()));
        }
        return list.toArray(new String[list.size()]);
    }
}