package leetcode.mid;

public class Q338 {
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        
        for(int i = 0; i < res.length; i ++){
            //Integer x =new Integer(i);
            res[i]=Integer.bitCount(i);
        }
        
        return res;
        
    }

    public static int[] solution(int num) {
        int[] res = new int[num+1];
        res[0]=0;
        if(num==0)return res;
        res[1]=1;
        if(num==1)return res;
        for(int i = 2; i < res.length; i ++){
            //Integer x =new Integer(i);
            res[i]=res[i>>1]+i%2;
        }
        
        return res;
        
    }


    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(10).toString());

	}

}
