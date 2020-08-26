package g_tdd_solution;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {

  Queue queue;

  @BeforeEach
  public void before() {
    queue = new Queue(10);
  }

  @Test
  public void peek_whenNoElementsWereAddedToTheQueue_shouldThrowEmptyQueueException() {
    assertThatThrownBy(() -> queue.peek()).isInstanceOf(EmptyQueueException.class);

  }

  @Test
  public void dequeue_whenNoElementsWereAddedToTheQueue_shouldThrowEmptyQueueException() {
    assertThatThrownBy(() -> queue.dequeue()).isInstanceOf(EmptyQueueException.class);
  }

  @Test
  public void enqueue_whenMaxSizeIsSetTo0_shouldThrowFullQueueException() {
    queue = new Queue(0);

    assertThatThrownBy(() -> queue.enqueue("bla")).isInstanceOf(FullQueueException.class);
  }

  @Test
  public void peek_whenOneElementWasPreviouslyAddedToTheQueue_shouldReturnThatElement() {
    String element = "bla";
    queue.enqueue(element);
    assertThat(queue.peek()).isEqualTo(element);
  }

  @Test
  public void deque_whenOneElementWasPreviouslyAddedToTheQueue_shouldReturnThatElementAndRemoveItFromTheQueue() {
    String element = "bla";
    queue.enqueue(element);
    assertThat(queue.dequeue()).isEqualTo(element);
    assertThatExceptionOfType(EmptyQueueException.class).isThrownBy(() -> {
      queue.dequeue();
    });
  }

  @Test
  public void deque_whenTwoElementWerePreviouslyAddedToTheQueue_shouldReturnThoseElementsInProperOrderAndRemoveThemFromTheQueue() {
    String element1 = "bla";
    String element2 = "alb";
    queue.enqueue(element1);
    queue.enqueue(element2);

    assertThat(queue.dequeue()).isEqualTo(element1);
    assertThat(queue.dequeue()).isEqualTo(element2);
    assertThatExceptionOfType(EmptyQueueException.class).isThrownBy(() -> {
      queue.dequeue();
    });
  }

}
