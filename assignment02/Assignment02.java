import java.util.*;
import java.io.*;
import java.text.*;

public class Assignment02 {
  public static void main(String[] args) throws Exception {
    Course.load();
    Student.processStudents();
    Student.printStudents();
  }
}