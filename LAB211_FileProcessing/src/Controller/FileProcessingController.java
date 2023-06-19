package Controller;

import java.nio.file.Paths;
import java.util.ArrayList;

import Common.FuncionsLibrary;
import Common.InputFunctions;
import Model.Person;
import View.Menu;

public class FileProcessingController {
    private ArrayList<Person> personList = new ArrayList<>();

    private FuncionsLibrary funcionsLibrary = new FuncionsLibrary();
    private InputFunctions inputFunctions = new InputFunctions();
    boolean isLoadedFile = false;

    public void handleLoadDataFromFile() {
        String[] options = {
                "Load file from program default file",
                "Manual input file to load!"
        };
        Menu eMenu = new Menu("CHOOSE THE OPTION", options) {

            @Override
            public void execute(int number) {
                switch (number) {
                    case 1:
                        String path = Paths.get("").toAbsolutePath().toString();
                        funcionsLibrary.handleLoadDataFromFile(personList, path + "/src/Data/Persons.txt");
                        Double leastMoney = inputFunctions.setDoubleValue("Enter least at money: ",
                                "^[-+]?\\d*\\.?\\d+$");
                        funcionsLibrary.handleFindPersons(personList, leastMoney);
                        break;
                    case 2:
                        String inputPath = inputFunctions.getStringValue("Enter Source: ");
                        funcionsLibrary.handleLoadDataFromFile(personList, inputPath);
                        leastMoney = inputFunctions.setDoubleValue("Enter least at money: ", "^[-+]?\\d*\\.?\\d+$");
                        funcionsLibrary.handleFindPersons(personList, leastMoney);
                        break;
                    default:
                        System.out.println("Backed to main menu!");
                }
            }

        };
        eMenu.run();
    }

    public void handleSaveDataToFile() {

        String[] options = {
                "Import source file from program file",
                "Manual import source file"
        };
        Menu eMenu = new Menu("CHOOSE THE OPTION", options) {

            @Override
            public void execute(int number) {
                switch (number) {
                    case 1:
                        String path = Paths.get("").toAbsolutePath().toString();
                        funcionsLibrary.handleLoadDataFromFile(personList, path + "/src/Data/Persons.txt");
                        String inputNewFileName = inputFunctions.getStringValue("Enter new file name: ");
                        String newFileName = path + "/src/Data/" + inputNewFileName;
                        System.out.println("PATH: " + newFileName);
                        funcionsLibrary.handleSaveCopy(personList, newFileName);
                        break;
                    case 2:
                        String inputPath = inputFunctions.getStringValue("Enter Source: ");
                        funcionsLibrary.handleLoadDataFromFile(personList, inputPath);
                        inputNewFileName = inputFunctions.getStringValue("Enter new file name:");

                        String[] pathElements = inputPath.split("[/\\\\]");
                        String fileName = pathElements[pathElements.length - 1];
                        String replaceFileName = fileName.replaceFirst("[^.]+$", inputNewFileName);
                        // String replaceFileName = inputNewFileName;

                        pathElements[pathElements.length - 1] = replaceFileName;
                        String separator = inputPath.contains("/") ? "/" : "\\";
                        String newFilePath = String.join(separator, pathElements);

                        funcionsLibrary.handleSaveCopy(personList, newFilePath);
                        break;
                    default:
                        System.out.println("Backed to main menu!");
                }
            }

        };
        eMenu.run();
    }

}
