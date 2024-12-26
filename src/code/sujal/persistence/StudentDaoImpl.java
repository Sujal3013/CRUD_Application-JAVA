package code.sujal.persistence;

import code.sujal.dataBaseUtils.DataBaseConnection;
import code.sujal.dto.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements IStudentDao{

    Connection connection=null;
    PreparedStatement pstmt=null;
    ResultSet resultSet=null;
    @Override
    public String addStudent(String sname, Integer sage, String saddress) {
        String sqlInsertQuery="insert into student(`name`,`age`,`address`) values(?,?,?)";
        try{
            connection= DataBaseConnection.getConnection();
            if(connection!=null){
                pstmt= connection.prepareStatement(sqlInsertQuery);
            }
            if(pstmt!=null){
                pstmt.setString(1,sname);
                pstmt.setInt(2,sage);
                pstmt.setString(3,saddress);

                int rowAffected=pstmt.executeUpdate();
                if(rowAffected==1){
                    return "success";
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return "failure";
    }

    @Override
    public Student searchStudent(Integer sid) {
        String sqlSelectQuery="select id,name,age,address from student where id=?";
        Student student=null;
        try{
            connection=DataBaseConnection.getConnection();
            if(connection!=null){
                pstmt=connection.prepareStatement(sqlSelectQuery);
            }
            if(pstmt!=null){
                pstmt.setInt(1,sid);
            }
            if(pstmt!=null){
                resultSet=pstmt.executeQuery();
            }
            if(resultSet!=null){

                if(resultSet.next()){
                    student=new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4));
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public String updateStudent(Student student) {
        String sqlUpdateQuery="Update student set name=?,age=?,address=? where id=?";
        try{
            connection=DataBaseConnection.getConnection();
            if(connection!=null){
                pstmt=connection.prepareStatement(sqlUpdateQuery);
            }
            if(pstmt!=null){
                pstmt.setString(1,student.getSname());
                pstmt.setInt(2,student.getSage());
                pstmt.setString(3,student.getSaddress());
                pstmt.setInt(4,student.getSid());
                int rowAffected=pstmt.executeUpdate();
                if(rowAffected==1){
                    return "success";
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return "failure";
    }

    @Override
    public String deleteStudent(Integer sid) {
        String sqlDeleteQuery="DELETE FROM student WHERE is=?";
        try{
            connection= DataBaseConnection.getConnection();
            if(connection!=null){
                pstmt= connection.prepareStatement(sqlDeleteQuery);
            }
            if(pstmt!=null){
                pstmt.setInt(1,sid);
                int rowAffected=pstmt.executeUpdate();
                if(rowAffected==1){
                    return "success";
                }else if(rowAffected==0){
                    return "not found";
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return "failure";

    }
}
