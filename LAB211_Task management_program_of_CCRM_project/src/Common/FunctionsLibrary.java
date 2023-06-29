package Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.Task;

public class FunctionsLibrary {
    private InputLibrary inputLibrary = new InputLibrary();


    public void addNewTask(ArrayList<Task> taskList) {
        String name = inputLibrary.setStringValue("Requirement name: " , "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$");
        Integer taskId = inputLibrary.setIntegerValue("Task Type: ");
        String date = inputLibrary.setStringValue("Date: ", "^(0[1-9]|1\\d|2\\d|3[01])-(0[1-9]|1[0-2])-(\\d{4})$");
        Double from = inputLibrary.setDoubleValue("From: ", "^[-+]?\\d*\\.?\\d+$");
        Double to = inputLibrary.setDoubleValue("To: ", "^[-+]?\\d*\\.?\\d+$");
        String assignee = inputLibrary.setStringValue("Assignee: ", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$");
        String review = inputLibrary.setStringValue("Reviewer", "^[a-zA-Z]{1,}(?: [a-zA-Z]+){0,3}$");
        taskList.add(new Task(name, taskId, date,from, to, assignee, review));
    }
    public Task search(Integer searchId, ArrayList<Task> taskList) {
        for (Task task : taskList) {
            if (task.getId() == searchId) {
                return task;
            }
        }
        return null;
    }
    public void removeTask(ArrayList<Task> taskList) {
        Task task = null;
        Integer removeId = null;
        if (taskList.isEmpty()) {
            System.out.println("LIST OF CONTACT IS EMPTY!");
        } else {
            removeId = inputLibrary.setIntegerValue("Enter contact ID to remove: ");
            task = search(removeId, taskList);
            if (task == null) {
                System.out.println("Contact " + removeId + " doesn't exist!");
            } else {
                taskList.remove(task);
                System.out.println("Remove successfully!");
                for (int i = 0; i < taskList.size(); i++) {
                    taskList.get(i).setId(i + 1);
                }
            }
        }
    } 

    public ArrayList<Task> sort(ArrayList<Task> taskList) {
        ArrayList<Task> tempTaskList = taskList;
        Collections.sort(tempTaskList, new Comparator<Task>(){

            @Override
            public int compare(Task o1, Task o2) {
                return o1.getId().compareTo(o2.getId());
            }

        });
        return tempTaskList;
    }

    public void display(ArrayList<Task> tasksList, String msg) {
        if(tasksList.isEmpty()) {
            System.out.println("TASK LIST IS EMPTY! PLEASE INPUT COUNTRY TO SHOW!");
        } else {
            System.out.println("\n" + msg); 
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.format("| %5s | %18s | %10s | %10s | %10s | %10s | %10s |","ID", "NAME", "TASK TYPE", "DATE", "TIME", "ASSIGNEE", "REVIEWER");
            System.out.println("\n---------------------------------------------------------------------------------------------");
            for(Task task : tasksList) {
                String taskName;
                if(task.getId() == 1) {
                    taskName ="Code";
                } else if(task.getId() == 2) {
                    taskName = "Test";
                } else if(task.getId() == 3) {
                    taskName = "Design";
                } else {
                    taskName = "Review";
                }
                System.out.format("| %5d | %18s | %10s | %10s | %10.1f | %10s | %10s |", task.getId(), task.getName(), taskName, task.getDate(), task.getTo() - task.getFrom(), task.getAssignee(), task.getReview());
                System.out.println("\n---------------------------------------------------------------------------------------------");
            }
        }
    }
}
