import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CsvReaderExample {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "/B://!VGU//!THIRD//!JAVALAB//labs//LABA4//foreign_names.csv/";
        String currLine = "";
        String separator = ";";

        List<Person> personList = new ArrayList();
        HashSet setDepartment = new HashSet();

        try {

            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();

            while((currLine = br.readLine()) != null)
            {
                String[] line = currLine.split(separator);
                Department department = null;
                Iterator iterator = setDepartment.iterator();

                while(iterator.hasNext())
                {
                    Department currDepartment = (Department)iterator.next();
                    if (currDepartment.getTitle().equals(line[4]))
                    {
                        department = currDepartment;
                    }
                }

                if (department == null)
                {
                    department = new Department(line[4]);
                    setDepartment.add(department);
                }

                Person person = new Person(Integer.parseInt(line[0]), line[1], line[2], department, Integer.parseInt(line[5]), line[3]);
                personList.add(person);
            }

            Iterator iterator = personList.iterator();

            while(iterator.hasNext())
            {
               Person person = (Person) iterator.next();
                System.out.println(person.toString());
            }

        }
        catch (FileNotFoundException ex1)
        {
            ex1.printStackTrace();
        }

        catch (IOException ex2)
        {
            ex2.printStackTrace();
        }
    }
}