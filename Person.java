import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private String firstname, middlename, lastname, sex;
    private LocalDate date_birthday;
    private long age;

    public Person(String fname, String mname, String lname, LocalDate date) {
        this.firstname = fname;
        this.middlename = mname;
        this.lastname = lname;
        this.date_birthday = date;
    }

    public void printInfo(){
        System.out.printf("%s %c.%c.\n%s\n%d", this.lastname,
                this.firstname.charAt(0),
                this.middlename.charAt(0),
                this.sex,
                this.age);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public long getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void defineSex() {
        if (middlename.charAt(middlename.length() - 1) == 'а'){
            this.sex = "Женский";
        }else {
            this.sex = "Мужской";
        }
    }

    public void defineAge() {
        LocalDate date = LocalDate.now();

        this.age = Period.between(date_birthday, date).getYears();

        /*this.age = date.get(Calendar.YEAR) - this.date_birthday.get(Calendar.YEAR);
        if( date.get(Calendar.MONTH)<=date_birthday.get(Calendar.MONTH)) {
            if (date.get(Calendar.DAY_OF_MONTH) <= date_birthday.get(Calendar.DAY_OF_MONTH))
                this.age--;
        }*/


    }
}
