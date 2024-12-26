package code.sujal.dto;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID=1L;
    private Integer sid;
    private String sname;


    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public Integer getSid(){return sid;}

    public void setSid(Integer sid){
        this.sid=sid;
    }


    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public Student(){

    }

    public Student(Integer sid, String sname, Integer sage, String saddress) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
    }

    private Integer sage;
    private String saddress;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage='" + sage + '\'' +
                ", saddress='" + saddress + '\'' +
                '}';
    }
}
