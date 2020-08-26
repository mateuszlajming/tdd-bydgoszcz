package g_tdd_solution;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GreeterTest {

  @Mock
  TimeProvider timeProvider;

  @InjectMocks
  Greeter greeter;

  @BeforeEach
  public void before() {
    when(timeProvider.getCurrentTime()).thenReturn(LocalTime.of(13,0));
  }

  @Test
  public void generateGreeting_whenPassingTheName_shouldReturnGreetingWithThatName() {
    assertThat(greeter.generateGreeting("Mateusz")).isEqualTo("Hello Mateusz");
  }

  @Test
  public void generateGreeting_whenPassingTheNameWithLeadingWhiteSpace_shouldReturnGreetingWithTheNameTrimmed() {
    assertThat(greeter.generateGreeting(" \n\tMateusz")).isEqualTo("Hello Mateusz");
  }

  @Test
  public void generateGreeting_whenPassingTheNameWithTrailingWhiteSpace_shouldReturnGreetingWithTheNameTrimmed() {
    assertThat(greeter.generateGreeting("Mateusz \n\t")).isEqualTo("Hello Mateusz");
  }

  @Test
  public void generateGreeting_whenPassingTheNameWithBothLeadingAndTrailingWhiteSpace_shouldReturnGreetingWithTheNameTrimmed() {
    assertThat(greeter.generateGreeting(" \n\tMateusz \n\t")).isEqualTo("Hello Mateusz");
  }

  @Test
  public void generateGreeting_whenPassingTheNameWhichStartsWithLowerLetter_shouldReturnGreetingWithTheNameStartingWithUpperLetter() {
    assertThat(greeter.generateGreeting("mateusz")).isEqualTo("Hello Mateusz");
  }

  @Test
  public void generateGreeting_whenGeneratingGreetingBetween6And12_shouldReturnGreetingStartingWithGoodMorning() {
    when(timeProvider.getCurrentTime()).thenReturn(LocalTime.of(7,0));
    assertThat(greeter.generateGreeting("Mateusz")).isEqualTo("Good morning Mateusz");
  }

  @Test
  public void generateGreeting_whenGeneratingGreetingBetween18And22_shouldReturnGreetingStartingWithGoodEvening() {
    when(timeProvider.getCurrentTime()).thenReturn(LocalTime.of(19,0));
    assertThat(greeter.generateGreeting("Mateusz")).isEqualTo("Good evening Mateusz");
  }

  @Test
  public void generateGreeting_whenGeneratingGreetingBetween22And6_shouldReturnGreetingStartingWithGoodEvening() {
    when(timeProvider.getCurrentTime()).thenReturn(LocalTime.of(2,0));
    assertThat(greeter.generateGreeting("Mateusz")).isEqualTo("Good night Mateusz");
  }
}
