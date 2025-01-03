import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        boolean fail = false;
        char s;
        int j = 0;

        for (int i = 0; i<babbling.length; i++) {
            j = 0;
            while(j < babbling[i].length()) {
                if (fail) {
                    fail = false;
                    break;
                }

                s = babbling[i].charAt(j);

                if (s == 'a') {
                    if (j+1 == babbling[i].length() || j + 2 == babbling[i].length()) {
                        break;
                    }

                    if (babbling[i].charAt(j+1) == 'y') {
                        if (babbling[i].charAt(j+2) == 'a') {
                            j += 3;
                        } else {
                            fail = true;
                        }
                    } else {
                        fail = true;
                    }
                } else if (s == 'y') {
                    if (j+1 == babbling[i].length()) {
                        break;
                    }

                    if (babbling[i].charAt(j+1) == 'e') {
                        j += 2;
                    } else {
                        fail = true;
                    }
                } else if (s == 'w') {
                    if (j+1 == babbling[i].length() || j + 2 == babbling[i].length()) {
                        break;
                    }

                    if (babbling[i].charAt(j+1) == 'o') {
                        if (babbling[i].charAt(j+2) == 'o') {
                            j += 3;
                        } else {
                            fail = true;
                        }
                    } else {
                        fail = true;
                    }
                } else if (s == 'm') {
                    if (j+1 == babbling[i].length()) {
                        break;
                    }

                    if (babbling[i].charAt(j+1) == 'a') {
                        j += 2;
                    } else {
                        fail = true;
                    }
                } else {
                    fail = true;
                }
                if (j == babbling[i].length()) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
