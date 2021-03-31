package leetcode.greedy;

/**
 * @author sven (bjwthwu@cn.ibm.com)
 * @date 2020/12/11
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        if(!senate.contains("R") || !senate.contains("D")) {
            return senate.contains("R") ? "Radiant" : "Dire";
        }

        int n = senate.length();
        for(int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                if (senate.substring(i,n).contains("D")) {
                    senate = senate.substring(0,i) + senate.substring(i,n).replaceFirst("D","");
                    n --;
                }else {
                    if (senate.substring(0,i).contains("D")) {
                        senate = senate.replaceFirst("D","");
                        i --;
                        n--;
                    }
                }
            } else {
                if (senate.substring(i,n).contains("R")) {
                    senate = senate.substring(0,i) + senate.substring(i,n).replaceFirst("R","");
                    n --;
                }else {
                    if (senate.substring(0,i).contains("R")) {
                        senate = senate.replaceFirst("R","");
                        i --;
                        n --;
                    }
                }
            }
        }

        return predictPartyVictory(senate);
    }

    public static void main(String[] args) {
        System.out.println(new Dota2Senate().predictPartyVictory("RDD"));
    }
}
