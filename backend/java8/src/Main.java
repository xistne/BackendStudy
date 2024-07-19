import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//      DESC : 람다 표현식
        List list = new ArrayList<String>();

        list.add("public");
        list.add("static");
        list.add("void");

//      DESC : 익명 클래스 코드
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });
//      DESC : 람다 표현식 코드
        list.sort((Comparator<String>) (str3, str4) -> str3.compareTo(str4));

//      DESC : ArrayList 출력
        List list3 = new ArrayList<String>();
        list3.add("public");
        list3.add("static");
        list3.add("void");

//      DESC : for문으로 List를 순회할 수 있다.
        for (int i = 0; i < list.size(); i++) { // list.size()는 리스트의 크기를 반환한다.
            System.out.println(list.get(i)); // i번째 요소가 출력된다.
        }
//      DESC : for -> 스트림 API로 바꿀 수 있다.
        List list4 = new ArrayList<String>();

        list4.add("public");
        list4.add("static");
        list4.add("void");

        list4.stream().forEach(str -> System.out.println(str));

//      DESC : 2의 배수 리스트
        Integer[] integerArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list5 = Arrays.asList(integerArray);

        List evenList = new ArrayList<Integer>();

        for (int i = 0; i < list5.size(); i++) {
            Integer number5 = list5.get(i);
            if (number5 % 2 == 0) {
                evenList.add(number5);
            }
        }
        for (int i = 0; i < evenList.size(); i++) {
            System.out.println(evenList.get(i));
        }

        List evenList2 = list5.stream().filter(val -> val % 2 == 0).collect(Collectors.toList());
        evenList2.stream().forEach(val -> System.out.println(val));
    }
}