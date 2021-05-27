package service;

import exception.SearcherException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileServiceTest {
    private static FileService fileService;

    @BeforeAll
    public static void setup(){
        fileService = new FileService();
    }

    @Test
    public void returnValueFromFile() throws SearcherException {
        Map<String,List<String>> res = fileService.readFile("src/test/resources",".txt");
        String file0="file0.txt";
        String file1="file1.txt";
        String file2="file2.txt";

        List<String> expectContent0 = new ArrayList<>();
        expectContent0.add("Search");
        expectContent0.add("words");
        expectContent0.add("in");
        expectContent0.add("file");

        List<String> expectContent1 = new ArrayList<>();
        expectContent1.add("best");
        expectContent1.add("words");
        expectContent1.add("ever");

        List<String> expectContent2 = new ArrayList<>();
        expectContent2.add("good");
        expectContent2.add("words");
        expectContent2.add("for");
        expectContent2.add("searching");
        assertEquals(Set.of(file0,file1,file2),res.keySet());
        assertEquals(expectContent0, res.get(file0));
        assertEquals(expectContent1, res.get(file1));
        assertEquals(expectContent2, res.get(file2));
    }

    @Test
    public void returnCountFiles() throws SearcherException {
        String output = fileService.showCounterOfFiles("src/test/resources", ".txt");
        assertEquals("3 files read in directory src/test/resources",output);
    }

    @Test
    public void shouldReturnEmptyMap(){
        try{
            Map<String,List<String>> res = fileService.readFile("src/test/resourcessss",".txt");
            assertTrue(res.isEmpty());
        }catch (SearcherException e){
            assertEquals("Can not found directory. Please type correct directory.", e.getMessage());
        }


    }

}
