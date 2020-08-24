package a_junit_live;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

public class VerifyTest {

    @Test
    public void test() {
        List<String> mockedList = mock(List.class);

        verifyNoInteractions(mockedList);
    }

}

