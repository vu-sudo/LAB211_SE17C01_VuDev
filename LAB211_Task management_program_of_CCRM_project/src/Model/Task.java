package Model;

public class Task {
    private static int defaultId = 0;   

    private Integer id;
    private String name;
    private Integer taskId;
    private String date;
    private Double from;
    private Double to;
    private String assignee;
    private String review;


    public static int getDefaultId() {
        return defaultId;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public Integer getTaskId() {
        return taskId;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public String getAssignee() {
        return assignee;
    }
    public String getReview() {
        return review;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
    public void setFrom(Double from) {
        this.from = from;
    }
    public void setTo(Double to) {
        this.to = to;
    }
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
    public void setReview(String review) {
        this.review = review;
    }

    public Task(String name, Integer taskId,String date, Double from, Double to, String assignee, String review) {
        this.id = ++defaultId;
        this.name = name;
        this.taskId = taskId;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.review = review;
    }
    
    public Task() {
        super();
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name + ", taskId=" + taskId + ", from=" + from + ", to=" + to
                + ", assignee=" + assignee + ", review=" + review + "]";
    }
    
}
