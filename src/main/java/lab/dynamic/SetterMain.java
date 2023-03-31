package lab.dynamic;

import lab.dev.TeamMember;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

public class SetterMain {

    public static void main(String[] args) throws IllegalAccessException{

        Class clazz = TeamMember.class;

        TeamMember tm = new TeamMember(null);

//        TODO 1: detect fields without setters
//        TODO 2: detect fields without setters and having value
//        TODO 3: detect fields without setters and having no value and annotated with @DefaultVale


         for (Field field : clazz.getDeclaredFields()) {
            String setterMethodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1).toUpperCase();
            Class setterParameterType = field.getType();

            boolean found = false;
            try {
                Method method = clazz.getDeclaredMethod(setterMethodName, setterParameterType);
                if (method.getReturnType() == void.class) {
                    found = true;
                }
            } catch (NoSuchMethodException e) {
            }
            if (!found) {
                field.setAccessible(true);
                Object value = field.get(tm);
                if(value==null){
                    System.out.println("field " + field.getName() + " found " + found);
                }
            }
             if (!found) {
                 field.setAccessible(true);
                 Object value = field.get(tm);
                 if(value==null)
                     System.out.println("field " + field.getName() + " found " + found);
                 DefaultValue defaultValue = field.getAnnotation(DefaultValue.class);
                 if(defaultValue!=null) {
                     System.out.println("Default value is detected");
                     field.set(tm, defaultValue.value());
                 }
                 }

        }

    }

}
