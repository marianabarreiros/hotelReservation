package controller.file;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class FileReadingTest {

    private List<String> allLines;

    @Before
    public void setUp() throws Exception {
        allLines = Files.readAllLines(Paths.get("/tmp", "input.txt"), Charset.forName("ISO-8859-1"));
    }

    @Test
    public void whenFileWasFound_thenExpectedYourCountLines(){
        assertEquals(allLines.size(), 3);
    }

    @Test(expected = IOException.class)
    public void whenFileNotFound_thenExpectedNullPointer() throws IOException {
        allLines = Files.readAllLines(Paths.get("/tmp", "inpu.txt"), Charset.forName("ISO-8859-1"));
    }
}