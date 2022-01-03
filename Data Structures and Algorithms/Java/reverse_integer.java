class Solution {
    public int reverse(int x) {
        int ans=0;
    
        int r;
        while(x!=0)
        {
            r=x%10;
            x=x/10;
            if(ans>Integer.MAX_VALUE/10 || ans==Integer.MAX_VALUE/10 && r>7)
                return 0; 
            if(ans<Integer.MIN_VALUE/10 || ans==Integer.MIN_VALUE/10 && r<-8)
                return 0;
            ans=ans*10+r;
                   
           
        }
        return ans;
        
    }
}
