import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextLine().chars().filter(Character::isAlphabetic).filter(c -> c % 2 == 0).count());

        System.out.println(in.nextLine().chars().filter(c -> c % 2 == 0 && Character.isAlphabetic(c)).count());

        System.out.println(in.nextLine().chars().filter(c -> c % 2 == 0 && ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))).count());

        // String m = in.nextLine();
        // int sum = 0;
        // for (char a : m.toCharArray()) {
        //     if (Character.isAlphabetic(a) && a%2==0) {
        //         sum += 1;
        //     }
        // }
        // System.out.println(sum);
    }
}
