import javax.swing.*;

public class MyTest {
    public static void main(String[] args){
//        Polynomial p1 = new Polynomial();
//        System.out.println(p1);
//        p1.add_to_coef(1.5, 1);
//        System.out.println(p1);
//        p1.add_to_coef(4.5, 5);
//        System.out.println(p1);
//        p1.add_to_coef(0.5, 3);
//        System.out.println(p1);
//
//        Polynomial p2 = new Polynomial();
//        System.out.println(p2);
//        p2.assign_coef(7.2, 0);
//        System.out.println(p2);
//        p2.assign_coef(6.6, 2);
//        System.out.println(p2);
//        p2.assign_coef(5.8, 4);
//        System.out.println(p2);
//
//        System.out.println(p1.add(p2));
//        System.out.println(p2.add(p1));
//        System.out.println(p1.add(p1));
//        System.out.println(p2.add(p2));

        Polynomial p1 = new Polynomial();
        System.out.println(p1);
        p1.assign_coef(3.1, 0);
        System.out.println(p1);
        p1.add_to_coef(2, 0);
        System.out.println(p1);

        Polynomial p2 = new Polynomial(2.5);
        System.out.println(p2);

        Polynomial p3 = new Polynomial(p2);
        System.out.println(p3);

        p2.add_to_coef(2,1);
        System.out.println(p2);
        p3.assign_coef(3.5, 2);
        System.out.println(p3);
        Polynomial p4 = new Polynomial(p3);
        System.out.println(p4);
        p3.add_to_coef(1.1,1);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p3.coefficient(2));
        System.out.println(p3.coefficient(1));
        System.out.println(p3.coefficient(0));

        System.out.println(p3.add(p2));
        System.out.println(p2.add(p3));
        System.out.println(p3.multiply(p2));
        System.out.println(p2.multiply(p3));

    }
}
