public class StringManipulator {
    public static void main(String[] args) {
        String str = "Hello world";
        String searchString = "ell";
        String result = str.replaceFirst(searchString, "");
        System.out.println(result);
    }
}
