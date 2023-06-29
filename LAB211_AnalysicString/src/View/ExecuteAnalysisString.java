package View;

import Controller.AnalysicStringController;

public class ExecuteAnalysisString {
    private final AnalysicStringController analysicStringController = new AnalysicStringController();
    public void run() {
        analysicStringController.inputString();
        analysicStringController.handleAnalyzeData();
        analysicStringController.handleShowData();
    }
}
