class Solution {
    public int bitwiseComplement(int n) {

        if(n==0)
        {
            return 1;
        }
         int mask=0;
        int m=n;
        while(n!=0)
        {
            mask=(mask<<1)|1;
            n=n>>1;
        }
        int ans=(~m)&mask;
        return ans;
    }
}
