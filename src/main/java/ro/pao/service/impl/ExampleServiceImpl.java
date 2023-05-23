package ro.pao.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.application.csv.CsvReader;
import ro.pao.application.csv.CsvWriter;
import ro.pao.model.ExampleClass;
import ro.pao.repository.ExampleRepository;
import ro.pao.service.ExampleService;
import ro.pao.model.produse.*;
import ro.pao.model.cumparator.*;
import ro.pao.model.comanda.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@RequiredArgsConstructor
@Getter
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;

    @Override
    public Optional<ExampleClass> getById(UUID id) {
        return exampleRepository.getObjectById(id);
    }

    @Override
    public Optional<ExampleClass> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<ExampleClass> getAllFromList() {
        return exampleRepository.getAll();
    }

    @Override
    public List<ExampleClass> getAllWithCondition() {
        return null;
    }

    @Override
    public void addAllFromGivenList(List<ExampleClass> exampleClassList) {
        exampleRepository.addAllFromGivenList(exampleClassList);
    }

    @Override
    public void addOnlyOne(ExampleClass exampleClass) {
        exampleRepository.addNewObject(exampleClass);
    }

    @Override
    public void removeElementById(UUID id) {
        exampleRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, ExampleClass newElement) {
        exampleRepository.updateObjectById(id, newElement);
    }

    /** Method example that reads employees from csv */
    /*
    This code will print the contents of the CSV file to the console in two different formats:
    allLines: a list of arrays, where each array represents a row in the CSV file.
    lineByLine: a list of arrays, where each array represents a single line in the CSV file.

    The output will look something like this:

    [id, first_name, last_name, email, gender, age]
    [1, John, Doe, john.doe@example.com, Male, 35]
    [2, Jane, Doe, jane.doe@example.com, Female, 30]
    [3, Bob, Smith, bob.smith@example.com, Male, 45]

    [1, John, Doe, john.doe@example.com, Male, 35]
    [2, Jane, Doe, jane.doe@example.com, Female, 30]
    [3, Bob, Smith, bob.smith@example.com, Male, 45]
    This is just a simple example, but I hope it helps you understand how you can use this CsvReader implementation in your own projects.
     */
    private void readFromCsv(List<ExampleClass> exampleClassList) throws Exception {
        try {
            CsvReader csvReader = CsvReader.getInstance();

            // Read all lines at once
            List<String[]> allLines = csvReader.executeAllLines();
            for (String[] line : allLines) {
                System.out.println(Arrays.toString(line));
            }

            // Read line by line
            List<String[]> lineByLine = csvReader.executeLineByLine();
            for (String[] line : lineByLine) {
                System.out.println(Arrays.toString(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Method example that writes employees to csv */
    private void writeToCsv(List<ExampleClass> exampleClassList) throws Exception {
        // Suppose you have a list of String[] arrays representing rows in a CSV file, like this:
        List<String[]> lines = new ArrayList<>();
        lines.add(new String[] {"id", "name", "age"});
        lines.add(new String[] {"1", "John Doe", "35"});
        lines.add(new String[] {"2", "Jane Doe", "30"});
        lines.add(new String[] {"3", "Bob Smith", "45"});

        // To write this data to a CSV file using CsvWriter, you can write the following code:

        try {
            CsvWriter csvWriter = CsvWriter.getInstance();

            // Write line by line
            Path lineByLinePath = Paths.get("line_by_line.csv");

            //String lineByLineContentsPathDefined = csvWriter.executeLineByLine(lines);
            String lineByLineContents = csvWriter.writeLineByLine(lines, lineByLinePath);
            System.out.println("Contents of line_by_line.csv:");
            System.out.println(lineByLineContents);



            // Write all lines at once
            Path allLinesPath = Paths.get("all_lines.csv");
            //String allLinesContents = csvWriter.executeAllLines(lines);
            String allLinesContents = csvWriter.writeAllLines(lines, allLinesPath);
            System.out.println("Contents of all_lines.csv:");
            System.out.println(allLinesContents);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        This code will write the contents of the lines list to two different CSV files: "line_by_line.csv" and "all_lines.csv". It will then read the contents of both files and print them to the console.
        The output will look something like this:

        Contents of line_by_line.csv:
    id,name,age
    1,John Doe,35
    2,Jane Doe,30
    3,Bob Smith,45

    Contents of all_lines.csv:
    id,name,age
    1,John Doe,35
    2,Jane Doe,30
    3,Bob Smith,45
         */
    }

//    public static void main(String[] args) {
//
//
////       testare clase:
//
//        Culegere myobj= new Culegere();
//        Manual myobj1= new Manual();
//        Carte mycarte = new Carte();
//        mycarte.setAutor("Diana");
//        mycarte.setPret(2);
//        myobj.setPret(10);
//        myobj1.setPret(5);
//        ArrayList<Produs> cumparat = new ArrayList<>();
//        cumparat.add(myobj);
//        cumparat.add(myobj1);
//        Cos trei = new Cos();
//        trei.setProduse(myobj);
//        trei.setProduse(myobj1);
//        trei.setProduse(mycarte);
//        trei.getProduse();
//        Carte mycarte2= new Carte("Calin","Cash","bine pe cash","da","paralela",20);
//        trei.setProduse(mycarte2);
//        System.out.println(trei.getProdusnr(0));
//        System.out.println(trei.getProdusnr(1));
//        System.out.println(trei.getProdusnr(2));
//        System.out.println(trei.getProdusnr(3));
//        System.out.println(mycarte2);
//        //System.out.println(trei);
//        Cos unu= new Cos();
//        Cos doi= new Cos();
//        unu.setTotal(myobj);
//        unu.setTotal(myobj1);
//        doi.setTotal(myobj);
//        Cumparator cum= new Cumparator();
//        Cumparator cum2= new Cumparator("a","b","c","d");
////        System.out.println(cum);
////        System.out.println(cum2);
////        System.out.println(cum.getId());
////        System.out.println(cum2.getId());
////        System.out.println(doi);
////        System.out.println(unu);
//
//}
}
