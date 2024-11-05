package Lesson4;//Azam
//05/11
//Class member to save members data 
public class Member {
    String name;
    String surname;
    double miles;
    public Member()
    {
        name="";
        surname="";
        miles=0;
    }

    public Member(String name, String surname, double miles) {
        this.name = name;
        this.surname = surname;
        this.miles = miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getMiles() {
        return miles;
    }

}
