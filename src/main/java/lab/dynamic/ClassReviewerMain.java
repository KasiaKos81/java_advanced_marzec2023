package lab.dynamic;

import lab.valid.PercentagerValidator;
import lab.zoo.animals.fish.Oyster;

public class ClassReviewerMain {
    public static void main(String[] args) {

        Class clazz = getClazz();

        do {
            ClassViewer viewer = new ClassViewer(clazz);
            viewer.classInfo();
            viewer.fieldsInfo();
            viewer.methodInfo();
            viewer.constructorInfo();
            clazz = clazz.getSuperclass();
        } while (clazz != Object.class);
    }

    public static Class getClazz(){
        return Oyster.class;
                //PercentagerValidator.class;
    }
}
