package a_junit_live;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserValidator.class)
public class PowerTest {

    @Test
    public void testConstructorInvocation() throws Exception {
        UserValidator mock = mock(UserValidator.class);
        whenNew(UserValidator.class).withNoArguments().thenReturn(mock);

        UserValidator userValidator = new UserValidator();

        verifyNew(UserValidator.class).withNoArguments();
        assertEquals(mock, userValidator);
    }

    @Test
    public void testFinalMethod() {
        UserValidator userValidator = mock(UserValidator.class);
        when(userValidator.validateFinal("Hello SDA!")).thenReturn(true);

        boolean result = userValidator.validateFinal("Hello SDA!");

        assertTrue(result);
    }

    @Test
    public void testStaticMethod() {
        mockStatic(UserValidator.class);
        when(UserValidator.validateStatic("Hello SDA!")).thenReturn(true);

        boolean result = UserValidator.validateStatic("Hello SDA!");

        assertTrue(result);
    }

}
