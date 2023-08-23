package junit;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("This is method @BeforeAll");
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("This is method @BeforeEach");
    }

    @AfterEach
    void afterEach() {
    System.out.println("This is method @AfterEach");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("This is method @AfterAll");
    }
    @Test
    void firstTest(){
        System.out.println("               This is test");
    }
}
