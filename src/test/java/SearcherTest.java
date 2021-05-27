import exception.SearcherException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SearcherTest {

    @Test
    public void noExistingDirectory(){
        try {
            Searcher.main(new String[]{"src/test/ress"});
        } catch (SearcherException e) {
            assertEquals("Can not found directory. Please type correct directory.", e.getMessage());
        }

    }

}
