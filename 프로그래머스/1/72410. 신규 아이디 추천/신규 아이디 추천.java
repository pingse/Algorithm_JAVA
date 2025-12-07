import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        new_id = new_id.toLowerCase();
        
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        new_id = new_id.replaceAll("[.]+", ".");
        
        new_id = new_id.replaceAll("^[.]?", "");
        new_id = new_id.replaceAll("[.]?$", "");
        
        new_id = new_id.equals("") ? "a" : new_id;

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]?$", "");
        }

        if (new_id.length() <= 2) new_id += new_id.substring(new_id.length()-1).repeat(3-new_id.length());
        
        return new_id;
    }
}