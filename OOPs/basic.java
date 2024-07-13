package OOPs;

public class basic {

    public static void main(String[] args) {
        Student x = new Student();
        x.name = "Soham Kolhatkar";
        x.roll_no = 10;
        x.percent = 94.8;
        System.out.println(x.name);
        System.out.println(x.roll_no);
        System.out.println(x.percent);

        System.out.println(Student.getNoOfStudents());

        Student y = new Student("Raghav Garg", 76, 92.3);
        System.out.println(y.name);
        System.out.println(y.roll_no);
        System.out.println(y.percent);

        System.out.println(Student.getNoOfStudents());
    }
}
