package com.tedemach.july15;

class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder outputString = new StringBuilder();
        int beginIndex = s.length() - 1;
        int lastIndex = s.length();
        while (beginIndex >= 0) {
            // case1: space 
            while (beginIndex >= 0 && s.charAt(beginIndex) == ' ') {
                beginIndex--;
                lastIndex--;
            }
            // case2: char
            while (beginIndex >= 0 && s.charAt(beginIndex) != ' ') {
                beginIndex--;
            }
            if (beginIndex + 1 < lastIndex) {
                outputString.append(s.substring(beginIndex + 1, lastIndex)).append(" ");
                lastIndex = beginIndex;
                beginIndex--;
            }
        }

        if (outputString.length() != 0)
            outputString.deleteCharAt(outputString.length() - 1);// remove trailing space 
        return outputString.toString();
    }
}

/*
" T is  ss!"
ops = 'ss! is T '
bi = 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1
li = 10, 6, 5, 2, 0

"   "
ops = ''
bi = 2, 1, 0, -1
li = 3, 2, 1, 0


StringBuilder outputString = new StringBuilder();
int beginIndex = s.length() - 1;
int lastIndex = s.length();

while (beginIndex >= 0) {
    // case1: space 
    while (beginIndex >= 0 && s.charAt(beginIndex) == " ") {
        beginIndex--;
        lastIndex--;
    }
    // case2: char
    while (beginIndex >= 0 && s.charAt(beginIndex) != " ") {
        beginIndex--;
    }
    if (beginIndex + 1 < lastIndex) {
        outputString.append(s.subString(beginIndex + 1, lastIndex)).append(" ");
        lastIndex = beginIndex;
        beginIndex--;
    }
}

if (outputString.length() != 0)
    outputString.delete(outputString.length() - 1);// remove trailing space 
return outputString.toString();


*/