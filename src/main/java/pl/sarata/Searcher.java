package pl.sarata;

import pl.sarata.model.Rank;
import pl.sarata.service.FileService;
import pl.sarata.service.RankService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Searcher {
    private static FileService fileService;
    private static RankService rankService;
    public static void main(String[] args) {
        fileService = new FileService();
        rankService = new RankService();

        String directory = args[0];
        Map<String, List<String>> textMap = fileService.readFile(directory);
        textMap.forEach((k,v)->{
            System.out.println("key: " + k + " value: " + v);
        });
        List<String> wordsSearched = new ArrayList<>();
        wordsSearched.add("the");
        List<Rank> ranks = rankService.rankOfFiles(textMap, wordsSearched);

        ranks.forEach(value->{
            System.out.println("rank: " + value);
        });
    }
}
