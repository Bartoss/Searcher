package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInputService {

    public List<String> readSearchingWords(){
        List<String> readedWords = new ArrayList<>();

        System.out.print("search> ");
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        if(line == null || line.isEmpty()){
            System.out.println("Please type some words.");
        }else{
            String[] words = line.trim().split("\\s+");
            readedWords = Arrays.asList(words);
        }
        return readedWords;
    }
}
