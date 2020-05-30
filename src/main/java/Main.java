import parsing.Lexer;
import parsing.YYParser;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer(new FileReader("example"));
        YYParser parser = new YYParser(lexer);
        parser.parse();
    }

}
