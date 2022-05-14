import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String s = "AAAABBBCCDEFFG"; //in.nextLine();
        System.out.println(s.chars().mapToObj(Character::toString).reduce((a, b) -> a + (b.equals(a.substring(a.length() - 1)) ? b : " " + b)).orElse(""));


        s = "The quick brown fox"; // in.nextLine();
        System.out.println(s.chars().filter(Character::isAlphabetic).filter(c -> c % 2 == 0).count());
        System.out.println(s.chars().filter(c -> c % 2 == 0 && Character.isAlphabetic(c)).count());
        System.out.println(s.chars().filter(c -> c % 2 == 0 && ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))).count());

        int sum = 0;
        for (char a : s.toCharArray()) {
            if (Character.isAlphabetic(a) && a % 2 == 0) {
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}
