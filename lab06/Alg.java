public class Alg {
    public static boolean lessThan(Student left, Student right, String sortby){
        //Determine which one is smalled between left and right

        if(sortby.equals("name"))
          return (left.studentName.compareTo(right.studentName) < 0) ? true : false;
        else if(sortby.compareTo("ID") == 0)
          return (left.studentID.compareTo(right.studentID) < 0) ? true : false;
        else if (left.letterGrade < right.letterGrade)
          return true;
        return false;
        }
    
    public static void bubblesort (Student[] arrayList, int counter, String sortby){
        for (int i = 0; i < counter; i++){
            for (int j=counter-1; j > i; j--){
                //Compare two items and consider whether swapping is needed.
                //if item a is larger than item a+1, you should swap them
              if(Alg.lessThan(arrayList[j], arrayList[j-1], sortby))
                Alg.swap(arrayList[j], arrayList[j-1]);
            }
        }
    }
    
    public static void swap (Student left, Student right){
        //Swap the content of left with the content of right
        String name = left.studentName;
        String ID = left.studentID;
        char grade = left.letterGrade;
        
        left.studentName = right.studentName;
        left.studentID = right.studentID;
        left.letterGrade = right.letterGrade;
        right.studentName = name;
        right.studentID = ID;
        right.letterGrade = grade;
    }
}