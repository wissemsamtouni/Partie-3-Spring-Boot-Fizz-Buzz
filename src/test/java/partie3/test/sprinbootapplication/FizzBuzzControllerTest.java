package partie3.test.sprinbootapplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenInputIsThree_thenReturnsCorrectList() {
        String expectedOutput = "[\"1\",\"2\",\"Fizz\"]";
        String url = "http://localhost:" + port + "/fizzbuzz/3";
        String actualOutput = this.restTemplate.getForObject(url, String.class);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void whenInputIsFive_thenReturnsCorrectList() {
        String expectedOutput = "[\"1\",\"2\",\"Fizz\",\"4\",\"Buzz\"]";
        String url = "http://localhost:" + port + "/fizzbuzz/5";
        String actualOutput = this.restTemplate.getForObject(url, String.class);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void whenInputIsFifteen_thenReturnsCorrectList() {
        String expectedOutput = "[\"1\",\"2\",\"Fizz\",\"4\",\"Buzz\",\"Fizz\",\"7\",\"8\",\"Fizz\",\"Buzz\",\"11\",\"Fizz\",\"13\",\"14\",\"FizzBuzz\"]";
        String url = "http://localhost:" + port + "/fizzbuzz/15";
        String actualOutput = this.restTemplate.getForObject(url, String.class);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

}

