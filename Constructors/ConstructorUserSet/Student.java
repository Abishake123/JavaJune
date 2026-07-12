package Constructors.ConstructorUserSet;

public class Student {

    String name;
    Integer regNo;
    Boolean isPassGradded;


    public Student(String name, Integer regNo, Boolean isPassGradded) {
        this.name = name;
        this.regNo = regNo;
        this.isPassGradded = isPassGradded;
    }


    public Student(String name, Integer regNo) {
        this.name = name;
        this.regNo = regNo;
    }

    public Student(){
        
    }




    @Override
    public String toString() {
        return "Student [name=" + name + ", regNo=" + regNo + ", isPassGradded=" + isPassGradded + "]";
    }

    
    
}
