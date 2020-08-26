package g_tdd_solution;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MarsRoverNavigatorTest {

  @Mock
  MarsRover marsRover;

  @InjectMocks
  MarsRoverNavigator marsRoverNavigator;

  @Test
  public void navigate_whenPassingDirectionsSeparatedByComma_shouldNavigateTheMarsRoverAccordingToThoseDirections() {
    marsRoverNavigator.navigate("F,L,R,B");

    verify(marsRover).goForward();
    verify(marsRover).goLeft();
    verify(marsRover).goRight();
    verify(marsRover).goBackward();
  }

  @Test
  public void navigate_whenPassingDirectionsMultipleTimesInARow_shouldNavigateTheMarsRoverAccordingToThoseDirections() {
    marsRoverNavigator.navigate("F,F,L,R,B,B,B");

    verify(marsRover, times(2)).goForward();
    verify(marsRover).goLeft();
    verify(marsRover).goRight();
    verify(marsRover, times(3)).goBackward();
  }

  @Test
  public void navigate_whenPassingDirectionsWithNumberOfMoves_shouldNavigateTheMarsRoverAccordingToThoseDirections() {
    marsRoverNavigator.navigate("2|F,L,R,3|B");

    verify(marsRover, times(2)).goForward();
    verify(marsRover).goLeft();
    verify(marsRover).goRight();
    verify(marsRover, times(3)).goBackward();
  }

  @Test
  public void navigate_whenPassingUnrecognizedDirection_shouldThrowIllegalArgumentExceptionWithProperMessage() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      marsRoverNavigator.navigate("2|F,L,Y");
    }).withMessage("unrecognized direction");

    verify(marsRover, times(2)).goForward();
    verify(marsRover).goLeft();
  }

}
