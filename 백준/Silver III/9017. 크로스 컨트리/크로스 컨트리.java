import java.io.*;
import java.util.*;

public class Main {        
	static int N,T;
	static int cnt[];
	static int score[];
	static int maxTeamNum;
	static int fifth[];
	static int playerCnt[];
	static boolean isCheck[];
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        T = Integer.parseInt(st.nextToken());
        
        for(int i=0; i< T; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	cnt = new int[201];
        	score = new int[201];
        	playerCnt = new int[201];
        	maxTeamNum = 0;
        	fifth = new int[201];
        	isCheck = new boolean[201];
        	String[] player = br.readLine().split(" ");
        	for(int j=0; j< N; j++) {
        		int team = Integer.parseInt(player[j]);
        		cnt[team]++;
        		if(cnt[team] == 5) {
        			fifth[team] = j;
        		}
        		if(maxTeamNum < team)maxTeamNum = team;
        	}
        	
        	int complete = 0;
        	for(int j=0; j <N ;j++) {
        		int team = Integer.parseInt(player[j]);
        		if(cnt[team] == 6) {
        			complete+=1;
        			if(playerCnt[team] < 4) {
        				score[team] += complete;
        				playerCnt[team]++;
        			}
        			if(j == fifth[team] && !isCheck[team]) {
        				fifth[team] = complete;
        				isCheck[team]= true;
        			}
        		}
        	}
        	
        	int answerTeam = 0;
        	int answerScore = Integer.MAX_VALUE;
        	int fifthScore = 0;
        	
        	for(int j=1; j<= maxTeamNum ;j++) {
        		if( score[j] > 0 && answerScore > score[j]) {
        			answerTeam = j;
        			answerScore = score[j];
        			fifthScore = fifth[j];
        		}
        		else if ( score[j] > 0 && answerScore == score[j] && fifthScore > fifth[j]) {
        			answerTeam = j;
        			fifthScore = fifth[j];
        		}
        	}
        	System.out.println(answerTeam);
        }
    }
}
