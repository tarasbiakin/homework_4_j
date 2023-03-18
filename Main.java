import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Student {
    private String name;
    private int age;

    private String gender;

    public Student(String name, int age,String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getGender() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                " gender=" + gender +
                '}';
    }
}

public class Main
{
    public static void main(String[] args)
    {
        List<Student> students = Arrays.asList(
                new Student("Владимир", 25, "M"),
                new Student("Кирилл", 15, "M"),
                new Student("Яков", 20, "M"),
                new Student("Антон", 10, "M"),
                new Student("Екатерина",22,"W"),
                new Student("Анастасия",24,"W")
        );



        // Использование метода Comparator.comparing()
        students.sort(Comparator.comparing(Student::getAge)
                .thenComparing(Student::getGender));

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

