package controller.file;

import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.nio.file.Files;

public class FileReading {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public List<String> readFile() {
        List<String> lines = new ArrayList<>();

        try{
            LOGGER.log(Level.INFO, "Initializing the read file.");
            lines = Files.readAllLines(Paths.get("/tmp", "input.txt"), Charset.forName("ISO-8859-1"));
        }catch (IOException e) {
            LOGGER.log(Level.WARNING, "Please, verify if file exist in the correct path -> ", e.getMessage());
        }
        return lines;
    }
}
