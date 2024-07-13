package OOPs;

public class Student {
    String name;
    int roll_no;
    double percent;
    private static int noOfStu;  // private to avoid external change 
    public Student(){
        noOfStu++;
    };
    
    public Student(String name , int roll_no , double percent) {
        this.name = name;
        this.roll_no = roll_no;
        this.percent = percent;
        noOfStu++;
    };

    public static int getNoOfStudents(){
        return noOfStu;  // to access it 
    }

}
