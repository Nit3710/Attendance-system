import java.util.*;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getid() {
        return id;
    }

    public String getname() {
        return name;
    }

}

class Course {
    private int courseid;
    private String coursename;

    public Course(int courseid, String coursename) {
        this.courseid = courseid;
        this.coursename = coursename;

    }

    public int getcid() {
        return courseid;
    }

    public String getcourse() {
        return coursename;
    }
}

class Attendance {
    private Student student;
    private Course course;
    private Date date;
    private boolean ispresent;

    public Attendance(Student student, Course course, Date date, boolean ispresent) {
        this.student = student;
        this.course = course;
        this.date = date;
        this.ispresent = ispresent;
    }

    public Student getstudent() {
        return student;

    }

    public Course getcourse() {
        return course;
    }

    public Date getdate() {
        return date;
    }

    public boolean ispresent() {
        return ispresent;
    }

}

public class AttendanceManagementSystem {

    private List<Student> students;
    private List<Course> courses;
    private List<Attendance> records;

    public AttendanceManagementSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        records = new ArrayList<>();

    }

    public void addstudent(int id, String name) {
        students.add(new Student(id, name));
    }

    public void addcourse(int courseid, String coursname) {
        
        courses.add(new Course(courseid, coursname));

    }

    public void markpresent(Student student, Course course, Date date, Boolean ispresent) {

        records.add(new Attendance(student, course, date, ispresent));
    }

    public List<Attendance> getstudentrecord(Student student) {
        List<Attendance> studentAttendance = new ArrayList<>();
        for (Attendance record : records) {
            if (record.getstudent().equals(student)) {
                studentAttendance.add(record);
            }

        }
        return studentAttendance;
    }

public static void main(String[] args) {
    AttendanceManagementSystem ams=new AttendanceManagementSystem();
    ams.addstudent(1,"rahul");
    ams.addstudent(2,"sunil");

    ams.addcourse(101, "math");
    ams.addcourse(102, "history");
    Student rahul=ams.students.get(0);
    Student sunil=ams.students.get(1);
    Course math = ams.courses.get(0);
    Course history = ams.courses.get(1);
    Date today=new Date();
    ams.markpresent(rahul,math,today,true);
    ams.markpresent(sunil, history, today, false);
    ams.markpresent(sunil, math, today, true);
    List<Attendance>sunilAttendance=ams.getstudentrecord(rahul);
        System.out.println("Sunil attendance record: ");

 for (Attendance record : sunilAttendance) {
            System.out.println("Course: " + record.getcourse().getcourse() +
                               ", Date: " + record.getdate() +
                               ", Present: " + record.ispresent());
        }
    }


}
