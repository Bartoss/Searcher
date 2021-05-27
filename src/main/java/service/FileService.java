package service;

import exception.SearcherException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.*;

public class FileService {

    public Map<String, List<String>> readFile(String pathName, String fileExt) throws SearcherException{
        Map<String, List<String>> worldsMap = new HashMap<>();

        File directory = new File(pathName);
        File[] fileList = null;

        if(directory.exists()){
           fileList = directory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(fileExt);
                }
            });
        }else{
            throw new SearcherException("Can not found directory. Please type correct directory.");
        }


        Scanner scanner = null;
        if(fileList != null)
        for(File file: fileList){
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

    public String showCounterOfFiles(String pathName, String fileExt) throws NullPointerException, SearcherException {
        long fileCounter;

        File directory = new File(pathName);

        File[] fileList = null;
        if(directory.exists()){
            fileList = directory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(fileExt);
                }
            });
        }else{
            throw new SearcherException("Can not found directory. Please type correct directory.");
        }


        fileCounter = fileList.length;
        String fileText = " files";
        if(fileCounter == 1){
            fileText = " file";
        }
        return fileCounter + fileText + " read in directory " + pathName;
    }
}
