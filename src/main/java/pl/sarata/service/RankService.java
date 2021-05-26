package pl.sarata.service;

import pl.sarata.model.Rank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RankService {

    public Rank determineValueOfRank(String nameOfFile, List<String> wordsInFile, List<String> searchedWords){
        Rank rank = new Rank();
        rank.setNameOfFile(nameOfFile);
        List<String> matchedWords = new ArrayList<>();
        if(wordsInFile != null && searchedWords != null){
            for(String searchedWord: searchedWords)
                for(String wordFromFile: wordsInFile){
                if(searchedWord.equals(wordFromFile)){
                    matchedWords.add(searchedWord);
                }
            }
        }

        BigDecimal sumWordsInFile = new BigDecimal(wordsInFile.size());
        BigDecimal sumMatchedWords = new BigDecimal(matchedWords.size());
        BigDecimal score = BigDecimal.ZERO;
        if(!(sumMatchedWords.compareTo(BigDecimal.ZERO) == 0)){
            score = sumWordsInFile.divide(sumMatchedWords);
        }


        rank.setScore(score);

        return rank;
    }

    public List<Rank> rankOfFiles(Map<String, List<String>> contentOfFiles,List<String> searchedWords){
        List<Rank> ranks = new ArrayList<>();
        for(Map.Entry<String, List<String>> content: contentOfFiles.entrySet()){
            ranks.add(determineValueOfRank(content.getKey(), content.getValue(), searchedWords));
        }
        return ranks;
    }


}
