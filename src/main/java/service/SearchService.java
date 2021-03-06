package service;

import exception.SearcherException;
import model.Rank;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SearchService {
    private static FileService fileService;
    private static RankService rankService;
    private static UserInputService userInputService;

    public SearchService(){
        fileService = new FileService();
        rankService = new RankService();
        userInputService = new UserInputService();
    }
    public void execute(String[] args) throws SearcherException {
        String directory = args[1];

        System.out.println(fileService.showCounterOfFiles(directory, ".txt"));

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
            int limit = 0;
            for(Rank rank: ranks) {
                if (limit < 10) {
                    System.out.println(rank);
                    limit++;
                }
            }
        }
        return false;
    }
}
