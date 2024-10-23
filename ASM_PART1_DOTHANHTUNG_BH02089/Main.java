public class Main {
    public static void main(String[] args) {
         
        StudentManagement management = new StudentManagement(5);
         
        management.addStudent(new Student("S01", "Alice", 8.5));
        management.addStudent(new Student("S02", "Bob", 7.2));
        management.addStudent(new Student("S03", "Charlie", 9.1));
        System.out.println("Current students:");
        management.printStudents();
         
        management.updateStudentMarks("S02", 8.0);
        management.sortStudentsByMarks();
        
        System.out.println("\nSorted students by marks:");
        management.printStudents();
         
        System.out.println("\nRemoved student: " + management.removeStudent());

        System.out.println("\nRemaining students:");
        management.printStudents();
    }
}
