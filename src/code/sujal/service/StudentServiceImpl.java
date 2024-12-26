package code.sujal.service;

import code.sujal.daofactory.StudentDaoFactory;
import code.sujal.dto.Student;
import code.sujal.persistence.IStudentDao;
import code.sujal.servicefactory.StudentServiceFactory;

import java.io.InputStream;

public class StudentServiceImpl implements IStudentService{
    IStudentDao stdDao=null;
    @Override
    public String addStudent(String sname, Integer sage, String saddress) {
        stdDao= StudentDaoFactory.getStudentDao();
        return stdDao.addStudent(sname,sage,saddress);
    }

    @Override
    public Student searchStudent(Integer sid) {
        stdDao=StudentDaoFactory.getStudentDao();
        return stdDao.searchStudent(sid);
    }

    @Override
    public String updateStudent(Student student) {
          return null;
    }

    @Override
    public String deleteStudent(Integer sid) {
        stdDao=StudentDaoFactory.getStudentDao();
        return stdDao.deleteStudent(sid);
    }
}
