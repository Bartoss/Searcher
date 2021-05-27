package service;

import model.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RankServiceTest {
    private static RankService rankService;
    private static List<String> valuesInFile;

    @BeforeAll
    public static void setup(){
        rankService = new RankService();
        valuesInFile = new ArrayList<>();
        valuesInFile.add("one");
        valuesInFile.add("two");
        valuesInFile.add("three");
    }

    @Test
    public void shouldReturn0percent(){
        List<String> valuesSearched = new ArrayList<>();
        valuesSearched.add("four");
        valuesSearched.add("five");
        Rank rank = rankService.determineValueOfRank("text.txt", valuesInFile,valuesSearched);
        Rank newRank = new Rank();
        newRank.setNameOfFile("text.txt");
        newRank.setScore(BigDecimal.ZERO);
        assertEquals(newRank, rank);
    }

    @Test
    public void shouldReturn100percent(){
        List<String> valuesSearched = new ArrayList<>();
        valuesSearched.add("one");
        valuesSearched.add("two");
        valuesSearched.add("three");

        Rank rank = rankService.determineValueOfRank("text.txt", valuesInFile,valuesSearched);
        Rank newRank = new Rank();
        newRank.setNameOfFile("text.txt");
        newRank.setScore(new BigDecimal("1"));
        assertEquals(newRank, rank);
    }
}
