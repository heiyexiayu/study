import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复最长子串
 */
public class Solution3 {
//滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int l=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
              left=Math.max(left,map.get(s.charAt(i))+1);
            }
              map.put(s.charAt(i),i);
              l=Math.max(l,i-left+1);
        }
        return l;
    }
    //常规
    public int lengthOfLongestSubstring2(String s) {
        if("".equals(s)){
            return 0;
        }
        char []chars=s.toCharArray();
        Map<Character,Integer> map=new HashMap();
        int[] lo=new int[chars.length];
        lo[0]=1;
        int j=1;
        int max=1;
        map.put(chars[0],0);
        for(int i=1;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                int tem=i-map.get(chars[i]);
                lo[j]=tem<lo[j-1]+1?tem:lo[j-1]+1;//取前一个+1和相同字符间隔距离中 小的一个
                if(max<lo[j]){
                    max=lo[j];
                }
                j++;
                map.put(chars[i],i);
            }else {
                map.put(chars[i],i);
                lo[j]=lo[j-1]+1;
                if(max<lo[j]){
                    max=lo[j];
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s="abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    public static int longest(String s ){
        int i=0;
        Map<Character,Integer>map=new HashMap<>();
        int left=0;
        int l=0;
        while(i<s.length()){
            if(map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i)+1));
            }
            l=Math.max(l,i-left+1);
            i++;
            map.put(s.charAt(i),i);
        }
        return l;
    }
}
