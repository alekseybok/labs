import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    private static Properties properties;

    private void downloadProperties() throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream ( "src/main/resources/config.properties" );
        properties= new Properties (  );
        properties.load ( fileInputStream );
    }

    public <T> T inject(T object) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException
    {
        downloadProperties();
        Field[] fields = object.getClass().getDeclaredFields ();
        for (Field field:fields)
        {
            if(field.getAnnotation ( AutoInjectable.class )!=null)
            {
                field.setAccessible ( true );
                String fieldClassname=field.getType().toString().split ( " " )[1];
                String injectedClassName = properties.getProperty(fieldClassname);
                Object value = Class.forName( injectedClassName).newInstance ( );
                field.set(object, value);
            }
        }
        return object;
    }
}