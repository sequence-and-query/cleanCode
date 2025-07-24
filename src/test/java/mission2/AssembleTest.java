package mission2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

@ExtendWith(MockitoExtension.class)
public class AssembleTest {
    @Test
    public void assembleTest() {
        Assertions.assertThrows(NoSuchElementException.class, () -> Assemble.main(new String[]{"Hello", "World"}));
    }
}
