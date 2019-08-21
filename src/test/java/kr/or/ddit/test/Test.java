package kr.or.ddit.test;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lost = {2,3,4};
		int[] reserve = {3,4,5};
		
		System.out.println(solution(5, lost, reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
		int cnt = 0;
		ArrayList<Integer> lostArr = new ArrayList<Integer>();
		for(int num : lost) {
			lostArr.add(num);
		}
		ArrayList<Integer> reserveArr = new ArrayList<Integer>();
		check : for(int num : reserve) {
			for(int i = 0; i < lostArr.size(); i++) {
				if(lostArr.get(i) == num) {
					lostArr.remove(i);
					continue check;
				}
			}
			reserveArr.add(num);
		}
		
		for(int i = 0; i < lostArr.size(); i++) {
			for(int j = 0; j < reserveArr.size(); j++) {
				if(lostArr.get(i)-1 == reserveArr.get(j) || lostArr.get(i)+1 == reserveArr.get(j)) {
					reserveArr.remove(j);
					cnt++;
					break;
				}
			}
		}
		int answer = n - lostArr.size() + cnt;
		return answer;
    }
}
