package g_tdd_solution;

public class Queue {

  private Object[] elements;
  private int tailIndex = -1;

  public Queue(int maxSize) {
    elements = new Object[maxSize];
  }

  public void enqueue(Object o) {
    if(queueIsFull()) {
      throw new FullQueueException();
    }
    storeObjectAtTheEndOfTheQueue(o);
  }

  public Object dequeue() {
    if(queueIsEmpty()) {
      throw new EmptyQueueException();
    }
    Object ret = getElementFromTheHeadOfTheQueue();
    moveElementsByOneIndexTowards0();
    return ret;
  }

  public Object peek() {
    if(queueIsEmpty()) {
      throw new EmptyQueueException();
    }
    return getElementFromTheHeadOfTheQueue();
  }

  private boolean queueIsEmpty() {
    return tailIndex == -1;
  }

  private Object getElementFromTheHeadOfTheQueue() {
    return elements[0];
  }

  private boolean queueIsFull() {
    return tailIndex == elements.length - 1;
  }

  private void storeObjectAtTheEndOfTheQueue(Object o) {
    elements[++tailIndex] = o;
  }

  private void moveElementsByOneIndexTowards0() {
    for(int i = tailIndex; i > 0; i--) {
      elements[i-1] = elements[i];
    }
    tailIndex--;
  }
}

class EmptyQueueException extends RuntimeException {}

class FullQueueException extends RuntimeException {}