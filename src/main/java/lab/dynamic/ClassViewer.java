package lab.dynamic;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ClassViewer {

    private final Class clazz;

    public void classInfo() {
        System.out.println("****************************************************");
        System.out.println("Class full name: " + clazz.getName());
        System.out.println("Class name: " + clazz.getSimpleName());
        System.out.println("Package name: " + clazz.getPackageName());
        System.out.println("modifiers: " + formatModifiers(clazz.getModifiers()));
        System.out.println("Interfaces: " + formatClassArray(clazz.getInterfaces()));
    }

    public void fieldsInfo() {
        Stream.of(clazz.getFields())
                .forEach(f -> {
                    System.out.println(
                            "field name: " + f.getName()
                                    + " ,type, " + f.getType().getSimpleName()
                                    + " ,modifiers" + formatModifiers(f.getModifiers()));
                });
    }

    public void constructorInfo(){
        Stream.of(clazz.getConstructors())
                .forEach(c -> {
                    System.out.println("constructor (" + formatClassArray(c.getParameterTypes()) + ")"
                            + "throws, " + formatClassArray(c.getExceptionTypes())
                            + "modifiers " + formatModifiers(c.getModifiers()));
                });
    }

    public void methodInfo() {
        Stream.of(clazz.getDeclaredMethods())
                .forEach(m -> {
                    System.out.println("method name: " + m.getName()
                            + "(" + formatClassArray(m.getExceptionTypes()) + ")"
                    + ", returning method: " + m.getReturnType().getName());
                      //      + ", modifiers: " + formatModifiers(m.getModifiers()));
                });


    }

    private String formatClassArray(Class[] classes) {
        return Stream.of(classes)
                .map(c -> c.getName())
                .reduce("", (s1, s2) -> s1 + " name " + s2);

        // Arrays.stream(classes)
    }

    private String formatModifiers(int modifiers) {
        StringBuilder builder = new StringBuilder();
        builder.append("[public:").append(Modifier.isPublic(modifiers)).append("]");
        builder.append("[protected:").append(Modifier.isProtected(modifiers)).append("]");
        builder.append("[private:").append(Modifier.isPrivate(modifiers)).append("]");
        builder.append("[static:").append(Modifier.isStatic(modifiers)).append("]");
        builder.append("[abstract:").append(Modifier.isAbstract(modifiers)).append("]");
        builder.append("[final:").append(Modifier.isFinal(modifiers)).append("]");
        builder.append("[interface:").append(Modifier.isInterface(modifiers)).append("]");

        return builder.toString();
    }


}
