public class ChildRecord {
    private String name;
    private String grade;
    private String attendance;
    private boolean active;

    public ChildRecord(String name, String grade, String attendance, boolean active) {
        this.name = name;
        this.grade = grade;
        this.attendance = attendance;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getAttendance() {
        return attendance;
    }

    public boolean isActive() {
        return active;
    }
}