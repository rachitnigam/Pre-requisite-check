package courseclass;

import java.util.ArrayList;

/**
 * Created by thEnigma on 5/5/16.
 */
public class CourseClass {

    private String department;
    private int classId;

    public CourseClass(String department, int classId) {
        this.department = department;
        this.classId = classId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String toString(){
        return (department+classId);
    }
}