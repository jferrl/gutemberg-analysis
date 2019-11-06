package gutemberg;

import main.java.repository.GutembergRepository;
import main.java.strategies.WordsCount;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        GutembergRepository repository = new GutembergRepository("C:\\Git\\gutemberg-analysis\\dataset\\txt");

        WordsCount wordsCount = new WordsCount(repository);
        wordsCount.execute();
        System.out.println(wordsCount.getResult());
    }
}
