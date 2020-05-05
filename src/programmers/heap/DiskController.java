package programmers.heap;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * level 3
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class DiskController {

	@Test
	public void test1() {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		assertEquals(9, solution(jobs));
	}
	
	@Test
	public void test2() {
		int[][] jobs2 = {{0, 5}, {1, 2}, {5, 5}};
		assertEquals(6, solution(jobs2));
	}
	
	@Test
	public void test3() {
		int[][] jobs3 = {{0, 3}, {1, 9}, {500, 6}};
		assertEquals(6, solution(jobs3));
	}

	public static int solution(int[][] jobs) {
		PriorityQueue<Disk> pq = new PriorityQueue<Disk>();
	    List<Disk> list = new ArrayList<>();

	    for (int i = 0; i < jobs.length; i++) {
	        pq.add(new Disk(jobs[i][0], jobs[i][1]));
	    }

	    for (int i = 0; i < jobs.length; i++) {
	        list.add(pq.poll());
	    }

	    int time = 0;
	    int sum = 0;
	    while (list.size() > 0) {
	    	System.out.println(time + "ms >>>>>");
	    	// 시작 가능한 작업 가져와서 진행
	        for (int i = 0; i < list.size(); i++) {
	            if (list.get(i).reqTime <= time) {
	            	int startTime = time;
	            	System.out.println(list.get(i) + "작업 가능");
	                time += list.get(i).procTime;
	                System.out.println(time + " : " + startTime + " : " + list.get(i).reqTime);
	                sum += (time - startTime) + (startTime - list.get(i).reqTime);
	                list.remove(i);
	                break;
	            }
	            if (i == list.size() - 1) time++;
	        }
	        
	        if (time == 20) break;
	    }

	    int answer = (sum/jobs.length);
	    return answer;
	}
}

class Disk implements Comparable<Disk> {
	public int reqTime;
	public int procTime;
	
	public Disk(int reqTime, int procTime) {
		this.reqTime = reqTime;
		this.procTime = procTime;
	}
	
	@Override
	public int compareTo(Disk d) {
		return this.procTime - d.procTime;
	}
	
	@Override
	public String toString() {
		return "[" + this.reqTime + ", " + this.procTime + "]";
	}
}
