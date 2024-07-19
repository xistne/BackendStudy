import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//      DESC : forEach (반복문)
        Integer[] integerArray1 = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> list1 = Arrays.asList(integerArray1);
        list1.stream().forEach(value -> System.out.println(value));

//      DESC : filter (조건문)
        Integer[] integerArray2 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list2 = Arrays.asList(integerArray2);
        List evenList1 = list2.stream().filter(value -> value % 2 == 0).collect(Collectors.toList());
        evenList1.stream().forEach(value -> System.out.println(value));

//      DESC : distinct (중복 제거)
        Integer[] integerArray3 = new Integer[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        List<Integer> list3 = Arrays.asList(integerArray3);
        List<Integer> distinctList = list3.stream().distinct().toList();
        distinctList.stream().forEach(value -> System.out.println(value));

//      DESC : map (특정 연산은 적용한 새로운 스트림)
        String[] lowercaseArray = new String[]{"public", "static", "void"};
        List<String> lowercaseList = Arrays.asList(lowercaseArray);
        List<String> uppercaseList = lowercaseList.stream().map(value -> value.toUpperCase()).toList();
        uppercaseList.stream().forEach(value -> System.out.println(value));

//      DESC : collect / toList (스트림을 리스트로 변환) 위 코드 참고
    }
}