public class Student {
    private String id;
    private String name;
    private double marks;
    private String rank;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = this.calculateRank(marks);
    }

    private String calculateRank(double marks) {
        if (marks >= 0.0 && marks < 5.0) {
            return "Fail";
        } else if (marks >= 5.0 && marks < 6.5) {
            return "Medium";
        } else if (marks >= 6.5 && marks < 7.5) {
            return "Good";
        } else {
            return marks >= 7.5 && marks < 9.0 ? "Very Good" : "Excellent";
        }
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getMarks() {
        return this.marks;
    }

    public String getRank() {
        return this.rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.rank = this.calculateRank(marks);
    }
    @Override
    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", Marks: " + this.marks + ", Rank: " + this.rank;
    }

}
