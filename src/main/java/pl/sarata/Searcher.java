package pl.sarata;

import pl.sarata.model.Rank;
import pl.sarata.service.FileService;
import pl.sarata.service.RankService;
import pl.sarata.service.UserInputService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Searcher {

    private static FileService fileService;
    private static RankService rankService;
    private static UserInputService userInputService;

    public static void main(String[] args) {
        fileService = new FileService();
        rankService = new RankService();
        userInputService = new UserInputService();

        String directory = args[0];
        fileService.showCounterOfFiles(directory, ".txt");

        Map<String, List<String>> textMap = fileService.readFile(directory, ".txt");
        while(true){
            if(calculateResult(textMap)){
                break;
            }
        }
    }

    public static boolean calculateResult(Map<String, List<String>> contentOfFiles){
        List<String> wordsSearched = userInputService.readSearchingWords();
        if(wordsSearched.size() == 1 && wordsSearched.contains(":quit")){
            return true;
        }

        List<Rank> ranks = rankService.rankOfFiles(contentOfFiles, wordsSearched);
        Collections.sort(ranks,Collections.reverseOrder());
        long noWordsFound = 0;
        for(Rank rank: ranks){
            if(rank.getScore().compareTo(BigDecimal.ZERO) == 0){
                noWordsFound++;
            }
        }
        if(noWordsFound == ranks.size()){
            System.out.println("no matches found");
        }else{
            ranks.forEach(value->{
                System.out.println(value);
            });
        }
        return false;
    }
}
