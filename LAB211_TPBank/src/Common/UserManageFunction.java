package Common;

import java.nio.file.Paths;
import java.util.ArrayList;


import Model.Captcha;
import Model.LanguageSwitcher;
import Model.User;
public class UserManageFunction {
    DataFuncions dataFuncions = new DataFuncions();
    InputLibrary inputLibrary = new InputLibrary();
    LanguageSwitcher languageSwitcher = new LanguageSwitcher();

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
        String userName = inputLibrary.inputUserName(languageSwitcher.translate("Enter_user_name"), userList);

        String userPassWord = inputLibrary.inputPassWord(languageSwitcher.translate("Enter_user_password"));
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
        String inputCaptcha = inputLibrary.inputString(languageSwitcher.translate("Enter_captcha"));
        if(inputCaptcha.equals(captcha.toString())) return true;
        return false;
    }

    public void login(ArrayList<User> userList) {

        useLoadDataFromFile(userList);  
        User checkingUser = inputLibrary.inputLogUserName(languageSwitcher.translate("Enter_user_name"), userList);
        boolean isSucessfullLogInUser = false;
        if(checkingUser != null) {
            isSucessfullLogInUser = isSucessfullLogIn(checkingUser, inputLibrary.inputPassWord(languageSwitcher.translate("Enter_user_password")));
        }
        Captcha captcha = new Captcha();
        System.out.println("Captcha: " + captcha.toString());
        if(isSucessfullLogInUser && checkingCaptcha(captcha)) {
            System.out.println(languageSwitcher.translate("LOG_IN_SUCCESFULLY"));
        } else {
            System.out.println(languageSwitcher.translate("LOG_IN_FAILED"));
        }
        userList.clear();
    }

    public boolean isSucessfullLogIn(User user, String pass) {
        if(user.getUserPassWord().equals(pass)) return true;
        return false;
    }
}
