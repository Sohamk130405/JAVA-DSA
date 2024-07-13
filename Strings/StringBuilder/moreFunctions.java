package Strings.StringBuilder;

public class moreFunctions {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");

        // append  xyz -->   abcxyz
        sb.append("xyz");
        System.out.println(sb);

        // insert() , delete() and deleteCharAt()
        sb.deleteCharAt(2); // delete at 2
        System.out.println(sb);

        sb.delete(1, 3);  // delete from 1 to 3 (not 3)
        System.out.println(sb);

        sb.insert(1, "bcx"); // insert  "bcx" at 1 to ...((3)
        System.out.println(sb);

        // reverse() 
        sb.reverse();  // reverse whole string without creating extra space
        System.out.println(sb);

        
    }
}
