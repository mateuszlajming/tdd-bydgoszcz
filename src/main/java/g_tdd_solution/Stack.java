package g_tdd_solution;

public class Stack {

  private final Object[] elements;
  private int topOfTheStackIndex = -1;

  public Stack(int maxSize) {
    elements = new Object[maxSize];
  }

  public void push(Object o) {
    if(stackIsFull()) {
      throw new FullStackException();
    }
    elements[++topOfTheStackIndex] = o;
  }

  public Object pop() {
    if (stackIsEmpty()) {
      throw new EmptyStackException();
    }
    Object valueFromTheTop = elements[topOfTheStackIndex];
    topOfTheStackIndex--;
    return valueFromTheTop;
  }

  public Object peek() {
    if(stackIsEmpty()) {
      throw new EmptyStackException();
    }
    return elements[topOfTheStackIndex];
  }

  private boolean stackIsFull() {
    return topOfTheStackIndex == elements.length - 1;
  }

  private boolean stackIsEmpty() {
    return topOfTheStackIndex == -1;
  }
}

class EmptyStackException extends RuntimeException {}

class FullStackException extends RuntimeException {}