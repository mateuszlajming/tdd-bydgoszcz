package f_mockito_solution;

import f_mockito.Book;
import f_mockito.BooksProcessor;
import f_mockito.BooksProcessorException;
import f_mockito.Database;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BooksProcessorTest {

  @InjectMocks
  BooksProcessor booksProcessor;

  @Mock
  Database database;

  @Test
  public void getTotalPrice_whenThereIsOnlyOneBook_shouldReturnThePriceOfThisBook() {
    Book book = new Book("W pustyni i w puszczy", 99.99);
    List<Book> list = singletonList(book);
    when(database.getBooks()).thenReturn(list);

    double totalPrice = booksProcessor.getTotalPrice();
    assertThat(totalPrice).isEqualTo(99.99);
    verify(database).getBooks();
  }

  @Test
  public void getTotalPrice_whenThereAreTwoBooks_shouldReturnTheSumOfThePricesOfThoseBooks() {
    // Arrange
    Book book1 = new Book("Wiedźmin", 200.0);
    Book book2 = new Book("Dziady", 5.0);
    List<Book> list = Arrays.asList(book1, book2);
    when(database.getBooks()).thenReturn(list);

    // Act
    double totalPrice = booksProcessor.getTotalPrice();

    // Assert
    assertThat(totalPrice).isEqualTo(205.0);
    verify(database).getBooks();
  }

  @Test
  public void getListOfTitles_whenThereIsOnlyOneBook_shouldReturnOnlyThatOneTitle() {
    // Arrange
    Book book = new Book("Pan Tadeusz", 35.0);
    List<Book> list = singletonList(book);

    when(database.getBooks()).thenReturn(list);

    // Act
    String listOfTitles = booksProcessor.getListOfTitles();

    // Assert
    assertThat(listOfTitles).isEqualTo("Pan Tadeusz");
    verify(database).getBooks();
  }

  @Test
  public void getListOfTitles_whenThereAreTwoBooks_shouldReturnBothTitlesSeparatedByAComma() {
    // Arrange
    Book book1 = new Book("Potop", 15.0);
    Book book2 = new Book("Pan Wołodyjowski", 16.0);
    List<Book> list = Arrays.asList(book1, book2);
    when(database.getBooks()).thenReturn(list);

    // Act
    String listOfTitles = booksProcessor.getListOfTitles();

    // Assert
    assertThat(listOfTitles).isEqualTo("Potop,Pan Wołodyjowski");
    verify(database).getBooks();
  }

  @Test
  public void getTotalPrice_whenDatabaseThrowsAnException_shouldThrowABooksProcessorExceptionWithProperMessageAndCause() {
    // Arrange
    RuntimeException exception = new RuntimeException("wiadomość");
    when(database.getBooks()).thenThrow(exception);

    // Act
    assertThatExceptionOfType(BooksProcessorException.class)
        .isThrownBy(() -> booksProcessor.getTotalPrice())
        .withCause(exception)
        .withMessage("Database has thrown exception with message: wiadomość");

    verify(database, times(3)).getBooks();
  }

  @Test
  public void getTotalPrice_whenDatabaseThrowsExeptionButWhenCalledSecondTimeReturnsTheListOfBooks() {
    // Arrange
    Book book = new Book("Czarodziejka", 250.0);
    List<Book> list = singletonList(book);
    Exception exception = new RuntimeException("wiadomość");
    when(database.getBooks())
        .thenThrow(exception)
        .thenReturn(list);

    // Act
    double totalPrice = booksProcessor.getTotalPrice();

    // Assert
    assertThat(totalPrice).isEqualTo(250.0);
    verify(database, times(2)).getBooks();
  }

}
