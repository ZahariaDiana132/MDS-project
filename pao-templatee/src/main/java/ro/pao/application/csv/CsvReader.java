package ro.pao.application.csv;

import com.opencsv.CSVReader;
import ro.pao.exceptions.CustomFileNotFoundException;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ro.pao.application.utils.Constants.CSV_PATH_READ;

public class CsvReader {

    private static CsvReader INSTANCE;


    private CsvReader() {
    }

    public static CsvReader getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CsvReader();
        }

        return INSTANCE;
    }

    public List<String[]> readAllLines(Path filePath) throws Exception {
        if (!filePath.toFile().exists()) {
            throw new CustomFileNotFoundException("File not found!");
        }

        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

    public List<String[]> readLineByLine(Path filePath) throws Exception {
        List<String[]> list = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    list.add(line);
                }
            }
        }
        return list;
    }

    public List<String[]> executeLineByLine() throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(CSV_PATH_READ).toURI());

        return readLineByLine(path);
    }

    public List<String[]> executeAllLines() throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(CSV_PATH_READ).toURI());

        return readAllLines(path);
    }
}
