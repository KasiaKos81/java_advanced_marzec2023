package lab.box;

public class BoxFactory {

    public static <C> Box<C> create(C content){
        Box <C> box = new Box();
        box.setContent(content);
        return box;
    }
}
