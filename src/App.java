public class App {
    public static void main(String[] args) throws Exception {
        char[] text = "abracadabra".toCharArray();
        char[] pattern = "cada".toCharArray();
        int index = findBrute.findBrute(text, pattern);

        System.out.println("Patron encontrado en indice: " + index);
    }
}
