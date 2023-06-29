package View;

import Controller.DataFormatController;

public class DataFormatService {
    private DataFormatController dataFormatController = new DataFormatController();

    public void run() {
        dataFormatController.handleInputPhoneNumber();
        dataFormatController.handleInputEmail();
        dataFormatController.handleInputDate();
    }
}
