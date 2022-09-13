import java.io.*;
import java.util.*;

public class Mystack{
  private int[] stack;
  private int top=0;

  public Mystack(int length) {//Mystack constructor
    stack = new int[length];//take parameter
  }
  public void push(int n){//pushes an element onto the top of stack
    stack[top]=n;
    top=top+1;

  }
  public int pop(){//removes and returns top element of stack
    top=top-1;
    int prev = stack[top];
    return prev;
  }
  public boolean isEmpty(){//checks if stack is empty
    if(top==0){//if next available index is 0
      return true;
    }
    return false;
  }
}
