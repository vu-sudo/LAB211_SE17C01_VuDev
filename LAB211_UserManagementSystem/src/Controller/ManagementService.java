package Controller;


import java.util.ArrayList;

import Common.UserManageFunction;
import Model.User;

public class ManagementService {
    protected ArrayList<User> userList = new ArrayList<>();
    
    private UserManageFunction userManageFunction = new UserManageFunction();

    public void handleCreateNewUserAccount() {
        userManageFunction.createNewUserAccount(userList);
    }
    public void handeLogin() {
        userManageFunction.login(userList);
    }
}
