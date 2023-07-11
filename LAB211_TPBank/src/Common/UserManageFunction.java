package Common;

import java.nio.file.Paths;
import java.util.ArrayList;
import Model.Captcha;
import Model.Translator;
import Model.User;

public class UserManageFunction {
    DataFuncions dataFuncions = new DataFuncions();
    InputLibrary inputLibrary = new InputLibrary();
    Translator translator = new Translator();

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
        // String userName = inputLibrary.inputUserName("Enter user name: ", userList);        
        String userName = inputLibrary.inputAccountNumber(translator.translate("Enter_user_name"), userList);

        String userPassWord = inputLibrary.inputPassWord(translator.translate("Enter_user_password"));
        String path = Paths.get("").toAbsolutePath().toString();
        
        boolean pass = false;
        do {
            Captcha captcha = new Captcha();
            System.out.println("Captcha: " + captcha.toString());
            if (checkingCaptcha(captcha) == true) {
                pass = true;
            }
        } while (pass == false);

        dataFuncions.saveDataToFileAppend(path + "/src/Data/user.dat", new User(userName, userPassWord));
        userList.clear();
    }
    
    public boolean checkingCaptcha(Captcha captcha) {
        String inputCaptcha = inputLibrary.inputString(translator.translate("Enter_captcha"));
        if(inputCaptcha.equals(captcha.toString())) return true;
        return false;
    }

    public void login(ArrayList<User> userList) {

        useLoadDataFromFile(userList);  
        User checkingUser = inputLibrary.inputLogAccount(translator.translate("Enter_user_name"), userList);
        boolean isSucessfullLogInUser = false;
        if(checkingUser != null) {
            isSucessfullLogInUser = isSucessfullLogIn(checkingUser, inputLibrary.inputPassWord(translator.translate("Enter_user_password")));
        }
        Captcha captcha = new Captcha();
        if(isSucessfullLogInUser) System.out.println("Captcha: " + captcha.toString());

        if(isSucessfullLogInUser && checkingCaptcha(captcha)) {
            System.out.println(translator.translate("LOG_IN_SUCCESFULLY"));
        } else {
            System.out.println(translator.translate("LOG_IN_FAILED"));
        }
        userList.clear();
    }

    public boolean isSucessfullLogIn(User user, String pass) {
        if(user.getUserPassWord().equals(pass)) return true;
        return false;
    }
}
