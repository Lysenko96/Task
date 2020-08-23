package com.lysenko.collections.stack;

import com.lysenko.collections.lists.iterator.Main;

public class MainStack {
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        stack.push('U');
        stack.push('n');
        stack.push('c');
       print(stack.pop().toString());
       print(stack.pop().toString());
       print(stack.pop().toString());
        stack.push('e');
        stack.push('r');
        stack.push('t');
        print(stack.pop().toString());
        print(stack.pop().toString());
        print(stack.pop().toString());
        stack.push('a');
        print(stack.pop().toString());
        stack.push('i');
        print(stack.pop().toString());
        stack.push('n');
        stack.push('t');
        stack.push('y');
        print(stack.pop().toString());
        print(stack.pop().toString());
        print(stack.pop().toString());
        stack.push(' ');
        print(stack.pop().toString());
        stack.push('r');
        stack.push('u');
        print(stack.pop().toString());
        print(stack.pop().toString());
        stack.push('l');
        stack.push('e');
        stack.push('s');
        print(stack.pop().toString());
        print(stack.pop().toString());
        print(stack.pop().toString());
    }


    private static void print(String result) {
        System.out.print(result);
    }

}
