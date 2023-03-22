package SWEA;

import java.util.Scanner;

public class P2817_Combi {
    static  int resultSum;
    static int numCount;
    static int[] numList;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++){
            numCount = sc.nextInt();
            resultSum = sc.nextInt();

            numList = new int[numCount];

            for(int i=0;i<numCount;i++){
                numList[i] = sc.nextInt();
            }
            for(int totalSelectCount = 1;totalSelectCount<=numCount;totalSelectCount++){

                combination(new int[totalSelectCount],0,0);
            }

            System.out.println("#"+tc+" "+answer);
        }
    }

    private static void combination(int[] selectList, int selectCount, int currentIdx) {
        // 1. 다 뽑았을 때
        // 2. 모든 원소를 다 확인했을 때

        if(selectCount == selectList.length){
            return;
        }

        if(currentIdx == numList.length) {
            return;
        }

        selectList[selectCount] = numList[currentIdx];
        combination(selectList,selectCount+1,currentIdx+1);

        selectList[selectCount] = 0;
        combination(selectList,selectCount,currentIdx+1);
    }
}
