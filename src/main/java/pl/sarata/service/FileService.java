package pl.sarata.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileService {

    public Map<String, List<String>> readFile(String pathName){
        Map<String, List<String>> worldsMap = new HashMap<>();
        File directory = new File(pathName);
        File[] fileList = directory.listFiles();
        Scanner scanner = null;
        if(fileList != null)
        for(File file: fileList){
            System.out.println("file: " + file.getName());
            List<String> textInFileList = new ArrayList<>();
            try {
                scanner = new Scanner(file);
                String text;

                while(scanner.hasNext()) {
                    text = scanner.next();
                    textInFileList.add(text.replaceAll("\\s+",""));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            worldsMap.put(file.getName(), textInFileList);

        }
        return worldsMap;
    }
}
