class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean val=false;
        if(n==1)
            return true;
            while(n>=2  && n%2==0)
            {
            if(n==2)
                val=true;
            n=n/2;
            }
        return val;
        
    }
}
