package code.sujal.daofactory;

import code.sujal.persistence.IStudentDao;
import code.sujal.persistence.StudentDaoImpl;

public class StudentDaoFactory {
    private StudentDaoFactory(){

    }
    private static IStudentDao studentDao=null;

    public static IStudentDao getStudentDao(){
        if(studentDao==null){
            studentDao=new StudentDaoImpl();
        }
        return studentDao;
    }
}
