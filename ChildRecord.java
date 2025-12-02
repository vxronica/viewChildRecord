/**
 * Class ChildRecord contain information related to a child's academic progress
 */
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

    public void printChildRecord() {
        System.out.println("\n--- Child Record ---");
        System.out.println("Name: " + this.getName());
        System.out.println("Grade: " + this.getGrade());
        System.out.println("Attendance: " + this.getAttendance());
        System.out.println("(End of record – read only)\n");
    }
}