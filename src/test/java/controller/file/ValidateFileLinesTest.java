package controller.file;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateFileLinesTest {

    private FileReading fileReading = new FileReading();
    private ValidateFileLines validateFileLines = new ValidateFileLines(fileReading.readFile());

    @Before
    public void setUp(){
        fileReading = new FileReading();
        validateFileLines = new ValidateFileLines(fileReading.readFile());
    }


    @Test
    public void validFiles(){
        assertEquals(3, validateFileLines.validateFileLinesAcrossByPattern().size());
    }





}