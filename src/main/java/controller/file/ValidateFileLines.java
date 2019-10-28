package controller.file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidateFileLines {

    private final Collection<String> listOfValidatedFileLines, listOfFileLines, listOfInvalidatedLines;
    private final Logger LOGGER;

    public ValidateFileLines(Collection<String> listOfFileLines) {
        this.listOfFileLines = listOfFileLines;
        listOfValidatedFileLines = new ArrayList<>();
        listOfInvalidatedLines = new ArrayList<>();
        LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public Collection<String> validateFileLinesAcrossByPattern() {
        String REGEX = "((([a-zA-Z]+:)?([0-9]{2})([a-zA-Z]{3})([0-9]{4})\\(([a-z]{3,4})\\)[,]?){3,})\\n?"; // https://regexr.com/;
        Pattern PATTERN = Pattern.compile(REGEX);

        getListOfFileLinesWithoutSpaces(listOfFileLines).forEach(s -> {
            if (PATTERN.matcher(s).matches()) {
                listOfValidatedFileLines.add(s);
            } else {
                listOfInvalidatedLines.add(s);
            }
        });
        LOGGER.log(Level.INFO, "The file was processing successfully.");
        return processingMessage();
    }

    private Collection<String> getListOfFileLinesWithoutSpaces(Collection<String> entryFile) {
        return entryFile.stream()
                .map(s -> s.replace(" ", "").trim())
                .collect(Collectors.toList());
    }

    private Collection<String> processingMessage(){
        if(listOfInvalidatedLines.size() > 0){
            LOGGER.log(Level.SEVERE, "Correct format: 'Rewards:99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa),99Aaa999(aaaa). Fix the follow lines: ");
            listOfInvalidatedLines.forEach(System.out::println);
        }return listOfValidatedFileLines;
    }
}
