import exception.SearcherException;
import service.SearchService;

public class Searcher {
    private static SearchService service;
    public static void main(String[] args) throws SearcherException {
        if(args.length == 1){
            throw new SearcherException("Please type directory to files");
        }
        service = new SearchService();
        service.execute(args);
    }
}
