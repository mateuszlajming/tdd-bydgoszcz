package a_junit_live;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockTest {


    @Test
    public void test1() {
        List<String> mockedList = mock(List.class);     // tworzenie mocka

        when(mockedList.size()).thenReturn(100);        // informowanie co ma zwracać

        System.out.println(mockedList.size());          // 100
        System.out.println(mockedList.size());          // 100
    }

    @Test
    public void test2() {
        List<String> mockedList = mock(List.class);     // tworzenie mocka

        when(mockedList.size())
            .thenReturn(100)                            // co zwróci za pierwszym razem
            .thenReturn(555);                           // co zwróci za drugim i kolejnym razem

        System.out.println(mockedList.size());          // 100
        System.out.println(mockedList.size());          // 555
        System.out.println(mockedList.size());          // 555
    }

    @Test
    public void test3() {
        List<String> mockedList = mock(List.class);             // tworzenie mocka

        when(mockedList.get(0)).thenReturn("first");            // informowanie co ma zwracać w konkretnym przypadku

        System.out.println(mockedList.get(0));                  // first
        System.out.println(mockedList.get(999));                // null
    }

    @Test
    public void test4() {
        List<String> mockedList = mock(List.class);             // tworzenie mocka

        when(mockedList.get(anyInt())).thenReturn("element");   // informowanie co ma zwracać we wszystkich przypadkach

        System.out.println(mockedList.get(0));                  // element
        System.out.println(mockedList.get(999));                // element
    }

    @Test
    public void test5() {
        List<String> mockedList = mock(List.class);             // tworzenie mocka

        when(mockedList.get(666))
            .thenThrow(new RuntimeException("el diablo"));      // dla danego przypadku rzuć wyjątek

        try {
            mockedList.get(666);
            fail("expected exception to be thrown");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("el diablo");
        }
    }

}


