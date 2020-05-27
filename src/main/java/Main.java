import parsing.Lexer;
import parsing.YYParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Lexer lexer = new Lexer(new FileReader("kek"));
        YYParser parser = new YYParser(lexer);

        System.out.println("250 тысяч солдат Ирака:");
        for (int j = 0; j < 10; ++j) {
            for (int i = 0; i < 25000; ++i)
                System.out.printf("Солдат Ирака %d ", i);
            System.out.println();
        }
    }

}
