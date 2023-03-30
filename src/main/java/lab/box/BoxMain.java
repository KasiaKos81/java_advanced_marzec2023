package lab.box;

public class BoxMain {

    public static void main(String[] args) {

        System.out.println("Let's box");

        // opcja 1
        Box <Integer> box11 = new Box<>();
        box11.setContent(102);
        Integer content11 = box11.getContent();
        System.out.println("content= " + content11);

        //opcja 2
        Box<Integer> box2 = new NumberBox<>();
        box2.setContent(109);
        Integer content2 = box2.getContent();
        System.out.println("content= " + content2);

        // opcja 3
        Box <Integer> box3 = new IntegerBox();
        box3.setContent(107);
        Integer content3 = box3.getContent();
        System.out.println("content= " + content3);

        // opcja 4
        Box <Integer> box = BoxFactory.create(104);
        Box <String> boxBox = BoxFactory.create("104");


        System.out.println("done");

    }
}
