package by.it.korzun.matlab;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BracketsChecker {
    static boolean check(String expression){
        Stack<Character> stack = new Stack<>();
        Pattern pattern = Pattern.compile("[{}()\\[\\]]");
        Matcher matcher = pattern.matcher(expression);
        boolean isCorrect = true;
        while(matcher.find()){
            if(expression.charAt(matcher.start()) == '{'){
                stack.push('{');
            }else if(expression.charAt(matcher.start()) == '('){
                stack.push('(');
            }else if(expression.charAt(matcher.start()) == '['){
                stack.push('[');
            }else{
                if(stack.isEmpty()){
                    isCorrect = false;
                    break;
                }else if(stack.peek() == '{'&& expression.charAt(matcher.start()) == '}'){
                    stack.pop();
                }else if(stack.peek() == '('&& expression.charAt(matcher.start()) == ')'){
                    stack.pop();
                }else if(stack.peek() == '['&& expression.charAt(matcher.start()) == ']'){
                    stack.pop();
                }else{
                    isCorrect = false;
                    break;
                }
            }
        }
        return isCorrect && stack.isEmpty();
    }
}
