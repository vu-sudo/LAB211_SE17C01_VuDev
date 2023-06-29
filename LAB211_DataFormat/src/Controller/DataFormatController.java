package Controller;

import Common.InputsLibrary;

public class DataFormatController {
    private final InputsLibrary inputsLibrary = new InputsLibrary();

    public void handleInputPhoneNumber() {
        inputsLibrary.inputPhoneNumber();
    }

    public void handleInputEmail() {
        inputsLibrary.inputEmail();
    }

    public void handleInputDate() {
        inputsLibrary.inputDate();
    }
}
