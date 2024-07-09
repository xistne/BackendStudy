import java.util.Optional;

public class Main {
    private static Optional<String> getSomeString() {
        return Optional.ofNullable("public static void");
    }
    public static void main(String[] args) {
        Optional<String> str = getSomeString();

//      X
        if (str.isPresent()) {
            System.out.println(str.get().toUpperCase());
        }
//      O
        str.ifPresent((string) -> System.out.println(string.toUpperCase()));

    }
}