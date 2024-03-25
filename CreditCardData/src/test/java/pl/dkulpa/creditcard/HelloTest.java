package pl.dkulpa.creditcard;

import org.junit.jupiter.api.Test;

public class HelloTest {
    @Test
    void helloFirstUnitTest(){
        //A / Arrange
        int a = 2;
        int b = 4;

        //A / Act
        var result = a + b;

        //A / Assert
        assert (result == 6);
    }
    @Test
    void helloWorldViaTest(){
        var name = "Dominika";
        var message = String.format("Hello %s", name);

        assert "Hello Dominika".equals(message);
    }
    @Test
    void failMyTest(){
        var a = 2;
        var b = 4;
        var result = a+b;
        assert result == 6;
    }
}
