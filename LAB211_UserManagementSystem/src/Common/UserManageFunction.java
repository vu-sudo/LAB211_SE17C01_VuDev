package Common;

import java.nio.file.Paths;
import java.util.ArrayList;

import Model.User;
public class UserManageFunction {
    DataFuncions dataFuncions = new DataFuncions();
    InputLibrary inputLibrary = new InputLibrary();

    public void useLoadDataFromFile(ArrayList<User> userList) {
        String path = Paths.get("").toAbsolutePath().toString();
        dataFuncions.readDataFromFile(path + "/src/Data/user.dat", userList);
    }

    public void useSaveDataToFile(ArrayList<User> userList) {
        String path = Paths.get("").toAbsolutePath().toString();
        dataFuncions.saveDataToFile(path + "/src/Data/user.dat", userList);
    }

    public void createNewUserAccount(ArrayList<User> userList) {
        useLoadDataFromFile(userList);
        String userName = inputLibrary.inputUserName("Enter user name: ", userList);
        String userPassWord = inputLibrary.inputPassWord("Enter user password: ");
        String path = Paths.get("").toAbsolutePath().toString();
        dataFuncions.saveDataToFileAppend(path + "/src/Data/user.dat", new User(userName, userPassWord));
        userList.clear();
    }
    
    public void login(ArrayList<User> userList) {
        useLoadDataFromFile(userList);
        User checkingUser = inputLibrary.inputLogUserName("Enter user name: ", userList);
        boolean isSucessfullLogInUser = false;
        if(checkingUser != null) {
            isSucessfullLogInUser = isSucessfullLogIn(checkingUser, inputLibrary.inputPassWord("Enter user password: "));
        }
        if(isSucessfullLogInUser) {
            System.out.println("LOG IN SUCCESFULLY!");
        } else {
            System.out.println("LOG IN FAILED!");
        }
        userList.clear();
    }

    public boolean isSucessfullLogIn(User user, String pass) {
        if(user.getUserPassWord().equals(pass)) return true;
        return false;
    }
}
