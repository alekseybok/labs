public class Person
{
    int id, salary;
    String name, sex, dateOfBirth;
   Department department;

    public Person(int id, String name, String sex, Department department, int salary, String dateOfBirth)
    {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public String toString()
    {
        int currId = this.id;
        return "Id = " + currId + ", Name: " + this.name + ", Sex: " + this.sex + ", Salary: " + this.salary + "," +
                " DateOfBirth: " + this.dateOfBirth + ", Division: " + this.department.getDivision();
    }
}