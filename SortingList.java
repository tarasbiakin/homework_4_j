import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class SortingList {
    static LinkedList<ArrayList<String>> contacts = new LinkedList<>();
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        GetData();
        PrintContacts();
//        contacts.sort(Comparator.comparing(contacts.get(0)).thenComparing());
        Comparator<ArrayList<String>> cmprAge = new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> t1, ArrayList <String>t2) {
                if(Integer.parseInt(t1.get(3).toString())> Integer.parseInt(t2.get(3).toString())) return 1;
                else if (Integer.parseInt(t1.get(3))< Integer.parseInt(t2.get(3)))  return -1;
                return 0;
            }
        };

        System.out.println("Сортировка по году рождения");
        contacts.sort(cmprAge);
        PrintContacts();
        contacts.sort(cmprAge);
        Comparator<ArrayList<String>> cmprGender = new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> t1, ArrayList <String>t2) {
                if(t1.get(4).charAt(0)>t2.get(4).charAt(0)) return 1;
                else if (t1.get(4).charAt(0)<t2.get(4).charAt(0)) return -1;
                return 0;
            }
        };

        contacts.sort(cmprGender);
        System.out.println("Сортировка по полу");

        PrintContacts();

    }

    private static void PrintContacts(){
        for (ArrayList<String>record:contacts){
            System.out.print(record.get(0)+" ");
            System.out.print(record.get(1).toUpperCase().charAt(0)+". ");
            System.out.print(record.get(2).toUpperCase().charAt(0)+". ");
            System.out.print(record.get(3)+" ");
            System.out.println(record.get(4)+" ");

        }
    }



    private static void GetData(){
        String command;
        System.out.println("Введите '1' для ввода новой записи \n Введите '2' для завершения ввода \n ");
        command = myScanner.nextLine();
        while (command.equals("1")) {
            contacts.add(GetRecord());
            System.out.println("Введите '1' для ввода новой записи \n Введите '2' для завершения ввода \n ");
            command = myScanner.nextLine();
        }


    }
    private static ArrayList<String>GetRecord(){
        ArrayList<String>newRecord = new ArrayList<>();
        System.out.println("Введите фамилию: ");
        String lastname = myScanner.nextLine();
        newRecord.add(lastname);
        System.out.println("Введите имя: ");
        String firstname = myScanner.nextLine();
        newRecord.add(firstname);
        System.out.println("Введите отчество: ");
        String middllname = myScanner.nextLine();
        newRecord.add(middllname);
        System.out.println("Введите год рождения: ");
        String age = myScanner.nextLine();
        newRecord.add(age);
        System.out.println("Введите пол: ");
        String gender = myScanner.nextLine();
        newRecord.add(gender);
        return newRecord;
    }
}
