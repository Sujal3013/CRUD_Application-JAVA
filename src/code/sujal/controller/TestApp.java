package code.sujal.controller;

import code.sujal.dto.Student;
import code.sujal.service.IStudentService;
import code.sujal.service.StudentServiceImpl;
import code.sujal.servicefactory.StudentServiceFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestApp {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("1. CREATE");
            System.out.println("2. READ");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            System.out.print("ENTER YOUR CHOICE :: PRESS [1/2/3/4/5] :: ");
            String option =br.readLine();

            switch (option){
                case "1":
                    insertOperation();
                    break;
                case "2":
                    searchOperation();
                    break;
                case "3":
                    updateOperation();
                    break;
                case "4":
                    deleteOperation();
                    break;
                case "5":
                    System.out.println("********** THANKS FOR USING THE APPLICATION **********");
                    System.exit(0);
                default :
                    System.out.println("Invalid option, please try again with valid options...");
                    break;
            }

        }
    }

    private static void updateOperation() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the student id to be updated :: ");
        String sid=br.readLine();
        IStudentService studentService= StudentServiceFactory.getStudentService();
        Student std=studentService.searchStudent(Integer.parseInt(sid));
        if(std!=null){
            Student newStd=new Student();
            System.out.println("Student id is :: "+std.getSid());
            newStd.setSid(std.getSid());
            System.out.println("Student old name is :: "+std.getSname()+"Enter new name :: ");
            String newName=br.readLine();
            if(newName.equals("") || newName==""){
                newStd.setSname(std.getSname());
            }else{
                newStd.setSname(newName);
            }
            System.out.println("Student old age is :: "+std.getSage()+"Enter new age :: ");
            String newAge=br.readLine();
            if(newAge.equals("") || newAge==""){
                newStd.setSage(std.getSage());
            }else{
                newStd.setSage(Integer.parseInt(newAge));
            }
            System.out.println("Student old address is :: "+std.getSaddress()+"Enter new address :: ");
            String newAddress= br.readLine();
            if(newAddress.equals("") || newAddress==""){
                newStd.setSaddress(std.getSaddress());
            }else{
                newStd.setSaddress(newAddress);
            }
            String msg=studentService.updateStudent(newStd);
            if(msg.equalsIgnoreCase("success")){
                System.out.println("Record updated successfully");
            }else{
                System.out.println("Record updation failed...");
            }
        }else{
            System.out.println("Student record not available for given id :: "+sid+" for updation...");
        }
    }

    private static void deleteOperation(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the student id to be deleted :: ");
        int sid=scanner.nextInt();

        IStudentService studentService= StudentServiceFactory.getStudentService();
        String msg=studentService.deleteStudent(sid);
        if(msg.equalsIgnoreCase("success")){
            System.out.println("Record deleted successfully");
        }else if(msg.equalsIgnoreCase("not found")){
            System.out.println("Record not available for given id :: "+sid);
        }else{
            System.out.println("Record deletion failed...");
        }
    }

    public static void searchOperation(){
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter the student id  :: ");
        int sid=scanner.nextInt();
        IStudentService studentService= StudentServiceFactory.getStudentService();
        Student std=studentService.searchStudent(sid);
        if(std!=null){
            System.out.println(std);
            System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
            System.out.println(std.getSid()+"\t"+std.getSname()+"\t"+std.getSage()+"\t"+std.getSaddress());
        }else{
            System.out.println("Record not found for given id :: "+sid);
        }
    }
    private static void insertOperation(){
        IStudentService studentService= StudentServiceFactory.getStudentService();
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the name of student :: ");
        String name=scanner.next();
        System.out.println("Enter the age of student :: ");
        Integer age=scanner.nextInt();
        System.out.println("Enter the address of student :: ");
        String address=scanner.next();
        String msg=studentService.addStudent(name,age,address);
        if(msg.equalsIgnoreCase("success")){
            System.out.println("Record inserted successfully");
        }else{
            System.out.println("record insertion failed");
        }
    }
}
