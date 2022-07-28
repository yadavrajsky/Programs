// class Solution {
//     public boolean isPalindrome(int x) {
//         String str_no=Integer.toString(x);
//         for(int i=0,j=str_no.length()-1;i!=j && j>-1;i++,j--)
//         {
//             // int compare=(str_no.charAt(i)).compareTo(str_no.charAt(j));
//             // if(compare!=0)
//             if(str_no.charAt(i)!=str_no.charAt(j))
//                 return false;
//         }

//         return true;
//     }
// }
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x % 10 == 0 && x != 0)
            return false;
        int reverted_number = 0;
        while (x > reverted_number) {
            reverted_number = reverted_number * 10 + x % 10;
            x /= 10;
        }

        return reverted_number == x || reverted_number / 10 == x;
    }
}