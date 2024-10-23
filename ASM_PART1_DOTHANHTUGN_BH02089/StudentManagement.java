import java.util.Arrays;
import java.util.Comparator;

class StudentManagement {
    private StudentStack studentStack;

    public StudentManagement(int size) {
        studentStack = new StudentStack(size);
    }

     
    public void addStudent(Student s) {
        studentStack.push(s);
    }

     
    public Student removeStudent() {
        return studentStack.pop();
    }

     
    public Student searchStudentById(String studentId) {
        for (int i = 0; i < studentStack.size(); i++) {
            Student student = studentStack.peek();
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

      
    public void updateStudentMarks(String studentId, double newMarks) {
        for (int i = 0; i < studentStack.size(); i++) {
            Student student = studentStack.peek();
            if (student.getStudentId().equals(studentId)) {
                student.setMarks(newMarks);
                return;
            }
        }
        System.out.println("Student not found.");
    }

     
    public void sortStudentsByMarks() {
        Student[] students = new Student[studentStack.size()];
        for (int i = 0; i < studentStack.size(); i++) {
            students[i] = studentStack.pop();
        }
        Arrays.sort(students, Comparator.comparingDouble(Student::getMarks));
        for (Student s : students) {
            studentStack.push(s);
        }
    }

     
    public void printStudents() {
        studentStack.printStack();
    }
}
