package service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class UserInputServiceTest {

    private static UserInputService userInputService;
    private static ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static ByteArrayOutputStream err = new ByteArrayOutputStream();
    private static PrintStream originalOut = System.out;
    private static PrintStream originalErr = System.err;

    @BeforeAll
    public static void setup(){
        userInputService = new UserInputService();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterAll
    public static void restoreInitialStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void shouldReturnSearch(){
        try{
            userInputService.readSearchingWords();
        }catch(NoSuchElementException e){
            assertEquals("search> ",out.toString());
        }

    }

    @Test
    public void shouldReturnSearchAndSomeText() throws UnsupportedEncodingException {
        List<String> searchedWords;
        String data = "the text you want to send";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn(testInput);
        searchedWords = userInputService.readSearchingWords();
        assertEquals(Arrays.asList("the", "text", "you", "want", "to", "send"), searchedWords);
    }
}
