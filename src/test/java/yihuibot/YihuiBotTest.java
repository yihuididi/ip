package yihuibot;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Unit Test for YihuiBot.java
 * 
 * @author Toh Yi Hui A0259080A
 */
public class YihuiBotTest {
    private YihuiBot yihuiBot;
    private static File file;

    /**
     * Create new file before all tests.
     */
    @BeforeAll
    public static void setUp() {
        file = new File("task.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            fail();
        }
    }

    /**
     * Remove the created file 'task.txt' after testing all tests.
     */
    @AfterAll
    public static void cleanUp() {
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * Ensures that the bot is not null.
     */
    @Test
    public void constructor_notNull() {
        yihuiBot = new YihuiBot("task.txt");
        assertNotNull(yihuiBot);
    }
}
