import java.util.UUID; 
//found it easier to use UUID for a randomized string, didn't know about this, could be useful for other applications

public class Student{
    String id;
    String answer;

    public Student(String id){
        this.id=id;
    }

    public String getId(){
        return id;
    }

    //Created a method that can generate an ID
   public static String generateRandomID(){
    return UUID.randomUUID().toString();
   }
}