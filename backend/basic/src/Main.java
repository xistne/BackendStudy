import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//      DESC : 조건문
        int number = 3;

        if (number == 1) {
            System.out.println("if 블록입니다.");
        } else if (number == 2) {
            System.out.println("else if 블록입니다.");
        } else {
            System.out.println("else 블록입니다.");
        }
//      DESC : 반복문
        int[] array = {1, 2, 3, 4, 5};

        for (int i = 0; i < array.length; i++) {
            System.out.println("i = " + array[i]);
        }
//      DESC : 컬렉션 List
        List list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        System.out.println(list1.get(1));

        List list2 = new ArrayList<String>();
        list2.add("pubilc");
        list2.add("static");
        list2.add("void");

        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        list2.remove(1);
        int voidIndex = list2.indexOf("void");
        System.out.println("void의 index = " + voidIndex);
//      DESC : 동일성 동등성
        String str1 = new String("is same?");
        String str2 = new String("is same?");

//      DESC : 동일성 비교
        System.out.println(str1 == str2);
//      DESC : 동등성 비교
        System.out.println(str1.equals(str2));
    }
}