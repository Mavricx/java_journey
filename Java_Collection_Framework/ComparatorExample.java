package Java_Collection_Framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MyComparator implements Comparator<Integer>{//for integer comparison
    @Override
    public int compare(Integer o1, Integer o2){
        //if negative o1-->o2
        //if zero o1==o2
        //if positive o2-->o1
        //if you want to sort in ascending order then return negative(take and example of o1=5 and o2=7)
        //if you want to sort in descending order then return positive;
       return o1-o2;//for ascending order
       //return o2-o1;//for descending order

    }
}
class MyStringLengthComparator implements Comparator<String>{ //for string comparison by length
    @Override
    public int compare(String o1, String o2){
        return o1.length()-o2.length();
    }
}

class  Student{
    private String name;
    private double gpa;

    public Student(String name, double gpa){
        this.name=name;
        this.gpa=gpa;
    }
    public String getName(){
        return name;
    }   
    public double getGpa(){
        return gpa;
    }
}
public class ComparatorExample {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(34);
        
        // list.sort(new MyComparator());
        //in lambda expression
        // list.sort((a,b)->a-b);
        // System.out.println(list);
        

        List <String> words=Arrays.asList("banana", "apple", "date");
        // words.sort(new MyStringLengthComparator()); 
        //or we can use lambda expression
        words.sort((a,b)->a.length()-b.length());
        System.out.println(words);

        //---------------------------
        List<Student> student=new ArrayList<>();
        student.add(new Student("Alice", 3.8));
        student.add(new Student("Bob", 3.6));
        student.add(new Student("Charlie", 3.9));
        student.add(new Student("Diana", 3.7));
        // student.sort((o1,o2)->o2.getGpa()>o1.getGpa()?1:-1);
        //or 
        student.sort((o1,o2)->{
            if(o1.getGpa()<o2.getGpa()){
                return 1;
            }
            else if(o1.getGpa()>o2.getGpa()){
                return -1;
            }
            else{
                return o1.getName().compareTo(o2.getName());
            }
        });
        // for(Student s:student){
        //     System.out.println(s.getName()+" "+s.getGpa());
        // }


        //or for java 8 we can use comparing method
        Comparator<Student> comparator=Comparator.comparing(Student::getGpa);//this is double colon operator and method referencing is used here
        student.sort(comparator);
        //for descending order
        //student.sort(comparator.reversed());
         for(Student s:student){
            System.out.println(s.getName()+" "+s.getGpa());
        }
        //using thenComparing method
        Comparator<Student> comparator1=Comparator.comparing(Student::getGpa).thenComparing(Student::getName);
        student.sort(comparator);
         for(Student s:student){
            System.out.println(s.getName()+":"+s.getGpa());
        }
    }
    
}
