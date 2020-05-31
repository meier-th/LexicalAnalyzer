import parsing.Lexer;
import parsing.YYParser;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename;
        if (args.length == 0)
            filename = "example";
        else
            filename = args[0];
        Lexer lexer = new Lexer(new FileReader(filename));
        YYParser parser = new YYParser(lexer);
        parser.parse();
    }

}
