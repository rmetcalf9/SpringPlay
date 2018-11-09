public class Palindrome {
    public static boolean isPalindrome(String word) {
        if (word.length()==0) return false;
        if (word.length()==1) return true;


        //System.out.println("word:" + word);
        int a = word.length() / 2;
        int b = word.length() / 2;
        if (word.length() % 2 != 0) {
            b++;
        }

        String startHalf = word.substring(0,(a));
        String endHalf = word.substring(b);

        StringBuilder input1 = new StringBuilder();
        input1.append(endHalf);

        input1 = input1.reverse();

        //System.out.println(String.format("start: :%s: ",startHalf));
        //System.out.println(String.format("end rev: :%s: ",input1.toString()));

        if (startHalf.equals(input1.toString())) return true;
        return false;
    }

}
