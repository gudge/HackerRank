import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


class Line {
	// y = mx + c
	int m1;
	int m2;
	double m;
	double c;

	Line(int m1, int m2, double c) {
		this.m = 1.0 * m1/m2;
		this.c = c;
		this.m1 = m1;
		this.m2 = m2;
	}

	Line(int x1, int y1, int x2, int y2) {
		this.m1 = y2 -y1;
		this.m2 = x2 - x1;
		this.c = (1.0 * (x1 * (y2 - y1) + y1 * (x2 - x1)))/(x2-x1);
		this.m = 1.0 * m1 / m2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(m);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c))
			return false;
		if (Double.doubleToLongBits(m) != Double.doubleToLongBits(other.m))
			return false;
		return true;
	}

	void print() {
		System.out.println(" Slope = " + this.m + " constant = " + c);
	}
}

class TestingHashMapHashCode {
	public static void main(String[] args) {
		HashMap<Line, Integer> hm = new HashMap<>();
		Line l1 = new Line(2, 3, 4);
		Line l2 = new Line(4, 6, 4);
		Line l3 = new Line(6, 9, 8);

		hm.put(l1, 100);
		hm.put(l2, 200);
		hm.put(l3, 300);

		Set<Line> ks = hm.keySet();
		for (Iterator<Line> it = ks.iterator(); it.hasNext();) {
			Line l4 = it.next();
			l4.print();
		}
	}
}



public class Solution {

	//	public interface Power extends Iterator<Long> {
	//		
	//		
	//	}


	public static void main(String[] args) throws FileNotFoundException {


		//favouriteSequence();


		//somethings2();
		//checkInt2();

		// LinkedIn Interview question
		// http://www.geeksforgeeks.org/linkedin-intership-interview-software-development-engineer/

		//permutation();
		//findtriplets();
		//subset();

		// conditional signalling
		//conditionsignalling();

		//allcombinations();

		//priorityQueue();

		//interfaceimplementation();

		//findpairnumber();

		// leftrightjustified();
		//editdistance();

		//smallestchacaterlargerthansearch();

		//distancebetweenbigwords();

		//repeatedsubstring();

		//integerrange();

		//levelordertraversal();

		//trieexample();

		//wordconversion();

		//kpointconversion();

		//fastpower();

		// https://www.hackerrank.com/contests/zenhacks/challenges/strange-grid
		//smartgrid2();

		//foo2();

		//subsetsumproblem();

		//isomorphic();

		//maximumsumsubarray();

		//ipow();

		//iterator2();

		//hindutoroman();

		//kclosestpoint();

		//colleinearpoints();
		//productmax();

		//smalleswindowsubstring();

		//smalleswindowsubstring2();

		//printfactors();

		//Solution x =  new Solution();
		//x.busywait();

		//blockingqueue();
		
		//palindrome();
		
		longestincreasingsubsequence3();
	}

	
	private static void longestincreasingsubsequence3() {
		// https://www.hackerrank.com/challenges/longest-increasing-subsequent
		// nlogn
		
		int[] a = new int[] { 15, 27, 14, 38, 26, 55, 46, 65, 85 };
		// {15, 27, 38, 55, 65, 85};
		
		int len = 0;
		//int[] arr2 = new int[];
	}

	

	private static void palindrome() {
		String str = "HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE";
		
		
	}

	private static void blockingqueue() {

		class BlockingQueue2 {
			private List<Integer> queue;
			private int limit;
			public BlockingQueue2(int limit) {
				this.queue = new LinkedList<>();
				this.limit = limit;
			}
			synchronized public void enqueue(int v) throws InterruptedException {
				boolean pmsg = false;
				while( this.queue.size() == limit) {
					if (!pmsg) {
						System.out.println("Queue is full (enquque) : wait");
						pmsg = true;
					}
					wait();
				}
				if (this.queue.size() == 0) {
					System.out.println("Queue is empty (enqueue) : wake up every one");
					notifyAll();
				}
				this.queue.add(v);
				System.out.println("Enqueue : " + v);
			}
			synchronized public int dequeue() throws InterruptedException {
				while (this.queue.size() == 0) {
					System.out.println("Queue is empty (dequeue)");
					wait();
				}
				if (this.limit == this.queue.size()) {
					System.out.println("Queue is full (dequeue)");
					notifyAll();
				}
				System.out.println("Dequeue : " + this.queue.get(0));
				return this.queue.remove(0);
			}
		}
	

		class MyThread extends Thread {
			BlockingQueue2 bq;
			boolean p;
			public MyThread(BlockingQueue2 bq, boolean p) {
				this.bq = bq;
				this.p = p;
			}
			public void run() {
				final int iter = 10;
				if (this.p) {
					for (int i = 0; i < iter; i++)
						try {
							bq.enqueue(i);
							if (i == 3) sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				} else {
					for (int i = 0; i < iter; i++)
						try {
							if (i == 3) sleep(10);
							bq.dequeue();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		}

		BlockingQueue2 bq = new BlockingQueue2(5);
		MyThread t1 = new MyThread(bq, false);
		MyThread t2 = new MyThread(bq, true);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {}
		System.out.println("Done");
	}

	private void busywait() {


	}

	private static void printfactors() {
		int num = 12;
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 1; i < num; i++) {
			if (num % i != 0) continue; 
			if (hs.contains(i) || hs.contains(num/i)) continue;
			hs.add(i); hs.add(num/i);	
			printfactors2(i, num/i);
		}
	}

	private static void printfactors2(int num, int f) {
		HashSet<Integer> hs = new HashSet<>();

	}

	private static void printfactors2(int i) {
		// TODO Auto-generated method stub

	}



	private static int findpivot2(int[] a, int l, int h) {
		if (l > h) return -1;
		if (l == h) return l;
		int mid = l + (h - l)/2;
		if (a[mid] < a[mid + 1]) return mid;
		if (a[mid-1] < a[mid]) return mid-1;
		if (a[l] >= a[mid]) return findpivot2(a, l, mid-1);
		else return findpivot2(a, mid+1, h);
	}

	private static void smalleswindowsubstring2() {
		String S = "ADOBECODEBANC";
		String T = "ABC";

		int sLen = S.length();
		int tLen = T.length();
		int needToFind[] = new int[256];
		Arrays.fill(needToFind, 0);

		for (int i = 0; i < tLen; i++) needToFind[T.charAt(i)]++;
		int[] hasFound = new int[256];
		Arrays.fill(hasFound, 0);
		int minWindowLen = sLen + 1;
		int count = 0;
		for (int begin = 0, end = 0; end < sLen; end++) {
			Character c = S.charAt(end);
			if (needToFind[c] == 0) continue;
			hasFound[c]++;
			if (hasFound[c] <= needToFind[c]) count++;
			if (count == tLen) {
				c = S.charAt(begin);
				while (needToFind[c] == 0 || hasFound[c] > needToFind[c] ) {
					if (hasFound[c] > needToFind[c]) hasFound[c]--;
					c = S.charAt(begin++);
				}
				int windowlen = end - begin + 1;
				if (windowlen < minWindowLen) {
					minWindowLen = windowlen;
				}
			}
		}

		if (count == tLen) {
			System.out.println("Found");
			System.out.println(minWindowLen);
		}
	}

	private static void smalleswindowsubstring() {
		// http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/

		//String str1 = "this is a test string";
		//String str2 = "tist";
		// Answer : "t stri"

		String str1 = "ADOBECODEBANC";
		String str2 = "ABC";


		if (str2 == null || str2.length() == 0) return;
		if (str1 == null || str1.length() == 0) return;

		HashMap<Character, Integer> charcnt  = getcharcntmap2(str1, 0 , str1.length()-1);
		HashMap<Character, Integer> charcnt2 = getcharcntmap2(str2, 0 , str2.length()-1);
		if (charcnt == null || charcnt2 == null)
			return;
		boolean isMatch = charactercntmatch2(charcnt2, charcnt);
		if (!isMatch) return; 

		// Where the begin string starts
		int beginindex = findstartbeginidex2(str1, charcnt2, 0);

		// end string ends
		int endindex = findendindex2(str1, new HashMap<>(charcnt2), beginindex);

		// do I need to shift begin
		beginindex = findshiftbeginindex(str1, beginindex, endindex, charcnt2);

		String tmp = str1.substring(beginindex, endindex+1);
		ArrayList<Integer> arrayval = new ArrayList<>();
		arrayval.add(beginindex);
		arrayval.add(endindex);

		for (int l = str1.length(), l2 = str2.length();endindex <= l - 1 && beginindex < l  &&
				beginindex <= endindex && endindex - beginindex + 1 >= l2;) {
			Character c = str1.charAt(beginindex);
			int tmpendindex = endindex + 1;
			if (tmpendindex == l) break;
			String tmp2 = str1.substring(beginindex, tmpendindex + 1);
			for (;tmpendindex < l; tmpendindex++) {
				Character c2 = str1.charAt(tmpendindex);
				String tmp3 = str1.substring(beginindex, tmpendindex + 1);
				if (c == c2) break;
			}
			if (tmpendindex == l) break;
			endindex = tmpendindex;
			beginindex = findshiftbeginindex(str1, beginindex + 1, endindex, charcnt2);
			tmp = str1.substring(beginindex, endindex+1);
			arrayval.add(beginindex);
			arrayval.add(endindex);
		}

		int min = arrayval.get(1) - arrayval.get(0);
		int index = 0;
		for (int i = 0, l = arrayval.size(); i < l; i += 2) {
			if (min > arrayval.get(i+1) - arrayval.get(i)) {
				min = arrayval.get(i+1) - arrayval.get(i);
				index = i;
			}
		}
		int dist = min + 1;
		System.out.println("Distance = " + dist + " " + str1.substring(arrayval.get(index), arrayval.get(index+1) + 1));
		System.out.println("Done");
	}

	private static int findshiftbeginindex(String str, int beginindex, int endindex, HashMap<Character, Integer> tmap) {
		String tmp = str.substring(beginindex, endindex + 1);
		HashMap<Character, Integer> charcnt = getcharcntmap2(str, beginindex , endindex);
		for(int l = str.length();beginindex < l && endindex < l && beginindex <= endindex;beginindex++) {
			Character c = str.charAt(beginindex);
			String tmp2 = str.substring(beginindex, endindex + 1);
			if (!tmap.containsKey(c)) continue;
			int v1 = charcnt.get(c);
			int v2 = tmap.get(c);
			if (v1 > v2) {
				charcnt.put(c, v1-1);
				continue;
			}
			break;
		}
		return beginindex;
	}

	private static int findstartbeginidex2(String str, HashMap<Character, Integer> target, int startindex) {
		int beginindex;
		for (beginindex = startindex;;beginindex++) {
			Character c = str.charAt(beginindex);
			if (target.containsKey(c)) break;
		}
		return beginindex;
	}

	private static int findendindex2(String str, HashMap<Character, Integer> charcnt, int beginindex) {
		Character c = str.charAt(beginindex);
		int v = charcnt.get(c);
		if (v == 1) charcnt.remove(c);
		else charcnt.put(c, v - 1);

		int endindex = beginindex + 1;
		for (;;endindex++) {
			c = str.charAt(endindex);
			if (!charcnt.containsKey(c)) continue;
			v = charcnt.get(c);
			if (v == 1) charcnt.remove(c);
			else charcnt.put(c, v-1);
			if (charcnt.isEmpty()) break;
		}
		return endindex;
	}

	private static HashMap<Character, Integer> getcharcntmap2(String str, int bindex, int eindex) {
		HashMap<Character, Integer> charcnt = new HashMap<>();
		for (int i = bindex < 0 ? 0 : bindex, 
				l = str.length() -1 > eindex ? eindex : str.length() - 1; i <= l; i++) {
			char c = str.charAt(i);
			if (charcnt.containsKey(c))	charcnt.put(c, charcnt.get(c) + 1);
			else charcnt.put(c, 1);
		}
		if (charcnt.isEmpty()) return null;
		return charcnt;
	}

	private static boolean charactercntmatch2(HashMap<Character, Integer> src, 
			HashMap<Character, Integer> dst) {
		Set<Character> k = src.keySet();
		for (Iterator<Character> it = k.iterator(); it.hasNext();) {
			Character c = it.next();
			if (!dst.containsKey(c)) return false;
			if (dst.get(c) < src.get(c)) return false;
		}
		return true;
	}

	private static void allpermutations() {
		String a = "abc";
		allpermutations2(a, 0);
	}

	private static void allpermutations2(String a, int start) {
		System.out.println(a);
		for (int i = start; i < a.length(); i++) {
			char[] a1 = a.toCharArray();

			char c = a1[i];
			a1[i] = a1[a.length() -1];
			a1[a.length() -1] = c;

			allpermutations2(new String(a1), i+1);

			c = a1[i];
			a1[i] = a1[a.length() -1];
			a1[a.length() -1] = c;
		}
	}

	private static void allcombinations() {
		// http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
		int []a = new int[]{1, 2, 3};
		a = new int[] {1, 3, 2, 3};
		allcombinations2(a);
	}

	private static void allcombinations2(int[] a) {
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.println();
		for (int i = 1, l = a.length; i <= l; i++) {
			allcombinations3(a, i);
		}
		System.out.println("X");
	}

	private static void allcombinations3(int[] a, int r) {
		int[] data = new int[r];
		allcombinations4(a, data, 0, r, 0);
	}

	private static void allcombinations4(int[] a, int[] data, int start, int  r, int index) {
		if (index == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(data[i]);
				System.out.print(' ');
			}
			System.out.println();
			return;
		}	
		for (int i = start; i < a.length && i <= a.length - (r - index); i++) {
			data[index] = a[i];
			allcombinations4(a, data, i+1, r, index + 1);
			while (i < a.length -1 && a[i+1] == a[i]) i++;
		}
	}


	private static void productmax() {
		int[] a = new int[] {1, -2, -3, 0, 7, -8, -2};

		int p = a[0];
		int tp = a[0];
		for (int i = 1; i < a.length;) {
			if (a[i] > 0) {
				tp = tp * a[i];
				i++;
				if (tp > p) p = tp;
			} else if (a[i] == 0) {
				tp = 1;
				i++;
			} else {
				int j = i+1;
				int p3 = 1;
				while (j < a.length && a[j] != 0 && a[j] > 0) {
					p3 = p3 * a[j];
					j++;
				}
				if (j == a.length) {
					if (p3 > p) p = p3;
					break;
				} else if (a[j] == 0) {
					if (p3 > p) p = p3;
					tp = 1;
					i = j + 1;
				} else {
					tp = p3 * a[i] * a[j] * tp;
					if (tp > p) p = tp;
					i = j + 1;
				}


			}
		}
		System.out.println(p);
	}


	private static void colleinearpoints() {
		// TODO Auto-generated method stub

	}


	private static void kclosestpoint() {
		List<HashMap<Double, HashSet<Integer>>> hm = new ArrayList<>();

	}


	private static void hindutoroman() {
		// TODO Auto-generated method stub

	}


//	private static void closestPoint2(Point2[] p) {
//		Point2[] Px = new Point2[p.length];
//		Point2[] Py = new Point2[p.length];
//
//	}

	private static void iterator2() {
		class X2 implements Iterable<X2> {

			@Override
			public Iterator<X2> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<X2>() {

					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public X2 next() {
						// TODO Auto-generated method stub
						return null;
					}
				};
			}
		}
	}

	private static void ipow() {
		Long base = (long) 15;
		Long exp = (long) 8;

		Long result2 = (long) Math.pow(base, exp);
		System.out.println(result2);
		Long result3 = pow3(base, exp);
		System.out.println(result3);
		if (result2.compareTo(result3) == 0)
			System.out.println("Equal");
		else
			System.out.println("Non equal");
	}

	private static Long pow3(long base, long exp) {
		if (exp == 0) return (long) 1;
		Long result2 = (long) 1;
		if (((Long)(exp % 2)).compareTo((long) 1) == 0) {
			result2 = base * pow3(base * base, (exp-1)/2);
		} else {
			result2 = pow3(base * base, exp/2);
		}
		return result2;
	}

	private static Long pow2(Long base, Long exp) {
		if (exp == 0) return (long) 1;
		return base * pow2(base, --exp);
	}

	private static void maximumsumsubarray() {
		int[] a = new int[] {-2, -5, 6, -2, -3, 1, 5, -6};

		boolean allneg = true;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) allneg = false;
		}
		if (allneg) return;
		boolean allpos = true;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) allpos = false;
		}
		if (allpos) return;

		int sum = 0, i = 0;
		for (i = 0; i < a.length; i++) {
			if (a[i] > 0) break;
		}

		sum = a[i]; i += 1;
		int tsum = sum;
		for (;i < a.length; i++) {
			tsum += a[i];
			if (tsum < 0) tsum = 0;
			if (tsum > sum) sum = tsum;
		}


		System.out.println(sum);
	}

	private static void isomorphic() {
		String str1 = "foo";
		String str2 = "app";

		HashMap<Integer, Integer> hs1 = findcharcnt2(str1);
		HashMap<Integer, Integer> hs2 = findcharcnt2(str2);

		Set<Integer> hs3 = hs1.keySet();
		boolean istrue = true;
		for (Iterator<Integer> it = hs3.iterator(); it.hasNext();) {
			Integer i = it.next();
			int cnt1 = hs1.get(i);
			if (!hs2.containsKey(i)) { istrue = false; break;}
			if (hs2.get(i) != cnt1) {istrue = false; break;}
		}

		if (istrue) {
			System.out.println("Yes");
		} else {
			System.out.println("False");
		}
	}

	private static HashMap<Integer, Integer> findcharcnt2(String str) {
		HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (hs.containsKey(c)) {
				hs.put(c, hs.get(c) + 1);
			} else {
				hs.put(c, 1);
			}
		}
		HashMap<Integer, Integer> hs2 = new HashMap<Integer, Integer>();
		Collection<Integer> hs3 = hs.values();
		for (Iterator<Integer> it = hs3.iterator(); it.hasNext();) {
			Integer j = it.next();
			if (hs2.containsKey(j)) hs2.put(j, hs2.get(j) + 1);
			else hs2.put(j, 1);
		}
		return hs2;
	}

	private static void subsetsumproblem() {
		// http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/

		int a[] = {3, 34, 4, 12, 5, 2}, sum = 9;

		boolean[][] subset = new boolean[sum+1][a.length+1];

		for (int i = 0; i <= sum; i++) {
			subset[i][0] = false;
		}

		for (int i = 0; i <= a.length; i++) {
			subset[0][i] = true;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= a.length; j++) {
				subset[i][j] = subset[i][j-1];
				if (i >= a[j-1]) {
					subset[i][j] = subset[i][j] || subset[i - a[j-1]][j-1];
				}
			}
		}
	}

	private static void foo2() {
		Long l = (long) (2 * 173 * Math.pow(3, 18765));
		//System.out.println(l);

		//System.out.println(x);
	}

	private static void smartgrid2() {
		Scanner in = new Scanner(System.in);
		String l = in.nextLine();
		String[] l2 = l.split(" ");
		Long r = Long.parseLong(l2[0]);
		int c = Integer.parseInt(l2[1]);
		l = null; l2 = null; in.close();


	}

	private static void fastpower() {
		// http://stackoverflow.com/questions/101439/the-most-efficient-way-to-implement-an-integer-based-power-function-powint-int

		int num1 = 111;
		int num2 = 78;
		long result = (long) Math.pow(num1, num2);
		System.out.println(result);

		long r2 = 1;
		long num2_2 = (long) num2;
		long num1_1 = (long) num1;
		while (num2_2 >= 1) {
			if (num2_2 %2 == 1) {
				r2 = r2 * num1;
			}
			num2_2 = num2_2 >> 1;
		num1_1 = num1_1 * num1_1;
		}
		System.out.println(r2);
	}

	private static void kpointconversion() {
		// http://www.careercup.com/question?id=4751976126480384

		class Point {
			int x, y;
			int dist;
			Point(int x, int y) {
				this.x = x;
				this.y = y;
				this.dist = x * x + y * y;
			}
			public void print() {
				System.out.println("x : " + this.x + " y : " + this.y + "dist : " + this.dist);

			}
		}
		List<Point> l = new ArrayList<Point>();
		l.add(new Point(1, 1));
		l.add(new Point(1, 3));
		l.add(new Point(-1, 1));
		l.add(new Point(-1, 3));
		l.add(new Point(1, -1));
		l.add(new Point(3, -1));
		l.add(new Point(-1, -1));
		l.add(new Point(-1, 3));
		l.add(new Point(2, 2));


		Comparator<Point> comp = new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.dist - o2.dist;
			}
		};
		PriorityQueue<Point> q = new PriorityQueue<Point>(5, comp);
		for (int i = 0; i < l.size(); i++)
			q.add(l.get(i));

		for (;!q.isEmpty();) {
			Point p = q.poll();
			p.print();
		}
	}

	private static void wordconversion() {
		// http://www.programcreek.com/2012/12/leetcode-word-ladder/
		// http://stackoverflow.com/questions/1521958/shortest-path-to-transform-one-word-into-another

		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		List<String> dict2 = new LinkedList<String>();
		for (Iterator<String> it = dict.iterator(); it.hasNext(); dict2.add(it.next()));
		Collections.sort(dict2);
		boolean[][] g = new boolean[dict2.size()][dict2.size()];

		for (int i = 0; i < dict2.size() - 1; i++) {
			boolean[] diff = new boolean[dict2.get(0).length()];
			for (int j = i+1; j < i+dict2.get(0).length() && j < dict2.size(); j++) {
				String str1 = dict2.get(i);
				String str2 = dict2.get(j);

				for (int k = 0; k < dict2.get(0).length(); k++) {
					char c1 = str1.charAt(k);
					char c2 = str2.charAt(k);
					diff[k] = c1 == c2 ? true : false;
				}

				int cntdiff = 0;
				for (int k = 0; k < dict2.get(0).length(); k++) if (!diff[k]) cntdiff++;		
				boolean related = cntdiff == 1 ? true : false;
				if (related) {
					g[i][j] = true; g[j][i] = true;
				}
			}
		}
		//printdetails1(g, dict2);

		String start = "hit";
		String end = "cog";

		List<Integer> startv = getneighbors2(dict2, start);
		List<Integer> endv = getneighbors2(dict2, end);

		if (startv == null || endv == null)
			return;

		//printdetails3(start, startv, dict2);
		//printdetails3(end, endv, dict2);

		Deque<Integer> path = null;
		for (int i = 0; i < startv.size(); i++) {
			Deque<Integer> bfs = new ArrayDeque<Integer>();
			Deque<Integer> bfsPath = new ArrayDeque<Integer>();
			boolean[] visited = new boolean[dict2.size()];
			int bfstart = startv.get(i);
			bfs.add(bfstart);
			visited[bfstart] = true;
			bfsloop: while (!bfs.isEmpty()) {
				int v2 = bfs.poll();
				bfsPath.add(v2);
				for (int j = 0 ; j < dict2.size(); j++) {
					if (v2 == j) continue;
					if (!g[v2][j]) continue;
					if (visited[j]) continue;
					bfs.add(j);
					visited[j] = true;
					for (int k = 0; k < endv.size(); k++) {
						if (j == endv.get(k)) {
							bfsPath.add(j);
							break bfsloop;
						}
					}
				}
			}
			if (bfsPath.size() != 0) {
				if (path == null) path = bfsPath;
				else if (bfsPath.size() < path.size()) path = bfsPath;
			}
		}		
		if (path == null) return;
		System.out.print("Path :  ");
		System.out.print(start);
		System.out.print(" -> ");
		for (Iterator<Integer> it = path.iterator(); it.hasNext();) {
			System.out.print(dict2.get(it.next()));
			System.out.print(" -> ");
		}
		System.out.print(end);
		System.out.println();
	}

	private static void printdetails3(String str, List<Integer> target, List<String> dict2) {
		System.out.print(str);
		System.out.print("  : ");
		for (int i = 0; i < target.size(); i++) {
			System.out.print(dict2.get(target.get(i)));
			System.out.print(' ');
		}
		System.out.println();
	}

	private static List<Integer> getneighbors2(List<String> dict2, String target) {
		List<Integer> neighbors = new ArrayList<Integer>();
		for (int i = 0; i < dict2.size(); i++) {
			boolean[] diff = new boolean[dict2.get(0).length()];
			String str1 = dict2.get(i);
			for (int j = 0; j < target.length(); j++) {
				char c1 = str1.charAt(j);
				char c2 = target.charAt(j);
				diff[j] = c1 == c2 ? true : false;
			}

			int cntdiff = 0;
			for (int k = 0; k < dict2.get(0).length(); k++) if (!diff[k]) cntdiff++;		
			boolean related = cntdiff == 1 ? true : false;
			if (related) {
				neighbors.add(i);
			}
		}
		return neighbors.size() == 0 ? null : neighbors;
	}

	private static void printdetails1(boolean [][] g, List<String> dict2) {
		for (int i = 0; i < dict2.size(); i++) {
			System.out.print(dict2.get(i));
			System.out.print(' ');
		}
		System.out.println();
		for (int i = 0; i < dict2.size(); i++) System.out.print(' ');
		for (int i = 0; i < dict2.size(); i++) {
			System.out.print(dict2.get(i));
			for (int j = 0; j < dict2.size()-1; j++)
				System.out.print(' ');
		}
		System.out.println();
		for (int i = 0; i < dict2.size(); i++) {
			System.out.print(dict2.get(i));
			for (int j = 0; j < 3; j++)
				System.out.print(' ');
			for (int j = 0; j < dict2.size(); j++) {
				if (i == j) System.out.print('-');
				else if (g[i][j]) System.out.print('1');
				else System.out.print('0');
				System.out.print(' ');
				for (int k = 0; k < dict2.size(); k++) System.out.print(' ');
			}
			System.out.println();
		}
	}

	private static void trieexample() {
		class TrieN {
			TrieN[] node = new TrieN[256];
			boolean end1 = true;
			boolean end2 = false;
		}

		class Trie {
			TrieN root;

			void insert(String v) {
				TrieN n = this.root;
				for (int i = 0, l = v.length(); i < l; i++) {
					char c = v.charAt(i);
					int v1 = c - 'a';
					if (n.node[v1] == null) {
						n.end1 = false;
						n = n.node[v1];
					} else {
						TrieN n2 = new TrieN();
						n.node[v1] = n2;
						n.end1 = false;
						n = n2;
					}
				}
				n.end2 = true;
			}

			boolean search(String v) {
				TrieN n = this.root;
				for (int i = 0, l = v.length(); i < l; i++) {
					char c = v.charAt(i);
					int v1 = c - 'a';
					if (n.node[v1] == null)
						return false;
					n = n.node[v1];
				}
				if (n.end1)
					return true;
				else if (!n.end1) {
					if (n.end2)
						return true;
				}	
				return false;
			}
		}
	}

	private static void levelordertraversal() {

		class Node {
			int d;
			Node l = null;
			Node r = null;;
			Node(int d) {
				this.d = d;
			}
			Node (int d, Node l, Node r) {
				this(d);
				this.l = l;
				this.r = r;
			}
			void print() {
				System.out.print(this.d);
				System.out.print(' ');
			}
		}

		Node node_4 = new Node(4);
		Node node_5 = new Node(5);
		Node node_3 = new Node(3);
		Node node_2 = new Node(2, node_4, node_5);
		Node node_1 = new Node(1, node_2, node_3);

		boolean[] visited = new boolean[5];
		Arrays.fill(visited, false);
		Queue<Node> q = new LinkedList<Node>();
		q.add(node_1);
		visited[0] = true;
		while (!q.isEmpty()) {
			Node n = q.poll();
			n.print();
			Node l = n.l;
			if (l != null) {
				if (!visited[l.d-1])
					q.add(l);
			}
			Node r = n.r;
			if (r != null) {
				if (!visited[r.d-1]) 
					q.add(r);
			}
		}
	}

	private static void repeatedsubstring() {
		// http://www.careercup.com/question?id=6495932900179968
		String input = "ABCACBABC";
		Set<String> set2 = new HashSet<>();

		for (int i = 0, l = input.length(); i < l; i++) {
			set2.add(input.substring(0, i+1));
		}
		Set<String> set3 = new TreeSet<String>();

		for (Iterator<String> it = set2.iterator(); it.hasNext();) {
			String str = it.next();
			int index = input.indexOf(str, input.indexOf(str)+1);
			if (index != -1) {
				set3.add(str);
			}
		}
		for (Iterator<String> it = set3.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

	private static void distancebetweenbigwords() {
		// http://www.careercup.com/question?id=6051601991073792

		String str = "hello how are you"; //3 
		str = "hello how are hello you"; //1
		str = "you are hello"; //1 
		//str = "hello how are hello"; //-1

		String x1 = "hello";
		String x2 = "you";

		String[] copies = str.split("[ \t]+");
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0, l = copies.length; i < l; i++) {
			if (copies[i].compareTo(x1) == 0) cnt1++;
			else if (copies[i].compareTo(x2) == 0) cnt2++;
		}
		if (cnt1 == 0 || cnt2 == 0) {
			System.out.println(-1);
			return;
		}
		int[] ind1 = new int[cnt1];
		int[] ind2 = new int[cnt2];

		for (int i = 0, l = copies.length, j = 0, k = 0; i < l; i++) {
			if (copies[i].compareTo(x1) == 0) ind1[j++] = i;
			else if (copies[i].compareTo(x2) == 0) ind2[k++] = i;
		}

		int min = str.length();
		for (int i = 0, j = 0; i < cnt1  && j < cnt2;) {
			if (min > Math.abs(ind1[i]-ind2[j]))
				min = Math.abs(ind1[i]-ind2[j]);
			if (ind1[i] < ind2[j]) i++;
			else j++;
		}
		System.out.println(min);
	}

	private static void smallestchacaterlargerthansearch() {
		// http://www.careercup.com/question?id=5726366532108288


	}

	private static void editdistance() {
		// DP

		String str1 = "SUNDAY";
		String str2 = "SATURDAY";

		int l1 = str1.length() + 1;
		int l2 = str2.length() + 1;
		int[][] T = new int[l1][l2];

		for (int i = 0; i < l1; i++) T[i][0] = i;
		for (int i = 0; i < l2; i++) T[0][i] = i;

		for (int i = 1; i < l1; i++) {
			for (int j = 1; j < l2; j++) {
				char c1 = str1.charAt(i-1);
				char c2 = str2.charAt(j-1);

				int ci = T[i-1][j] + 1;
				int cd = T[i][j-1] + 1;
				int c = c1 == c2 ? T[i-1][j-1] : T[i-1][j-1] + 1;

				c = c < ci ? c : ci;
				c = c < cd ? c : cd;
				T[i][j] = c;
			}
		}
		System.out.println(T[l1-1][l2-1]);
	}

	private static void leftrightjustified() {
		String input = "Cracking the Coding Interview: 150 Programming Interview Questions " +
				"and Answers focuses on mastering the programming interview. " +
				"Topics include: strategies to handle tough algorithm questions, " +
				"preparation techniques, behavioral questions, and 150 programming" +
				"interview questions and answers.";
		int width = 20;
		StringBuilder sb = new StringBuilder();
		String[] words = input.split(" ");
		int pos = 0;
		for (String w : words) {
			if (pos + w.length() > width) {
				sb.append(w);
				sb.append(' ');
			}
		}
	}

	private static void findpairnumber() {
		// http://www.careercup.com/question?id=10166688
		// http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
		int[] a = new int[] {1, 4, 45, 6, 10, -8};
		int sum = 16;
		int num1 = -1; int num2 = -1;

		Set<Integer> hs = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (hs.contains(sum -a[i])) {num1 = sum - a[i]; num2 = a[i];} 
			if (!hs.contains(a[i])) hs.add(a[i]);
		}

		System.out.println(num1);
		System.out.println(num2);

	}

	private static void interfaceimplementation() {
		// http://www.careercup.com/question?id=8591375
		class StringData {
			public StringData(int i) {
				// TODO Auto-generated constructor stub
			}
			int cnt;
			boolean inPq;
			String data;
		}

		Comparator<StringData> comp = new Comparator<StringData>() {
			public int compare(StringData x, StringData y) {
				return x.cnt - y.cnt;
			}
		};

		HashMap<String, StringData> hs = new HashMap<String, StringData>();
		PriorityQueue<StringData> pq = new PriorityQueue<StringData>(100, comp);


		String key = "";

		if (hs.containsKey(key)) {
			StringData sd = hs.get(key);
			sd.cnt++;
			if (!sd.inPq) {
				if (pq.peek().cnt < sd.cnt) {
					pq.poll().inPq = false;
					pq.add(sd);
					sd.inPq = true;
				}
			} else {
				sd.cnt += 1;
			}
		} else {
			StringData sd = new StringData(1);
			sd.data = key;
			hs.put(key, sd);
			if (pq.size() < 100 - 1) {
				pq.add(sd);
				sd.inPq = true;
			}
		}

	}

	private static void priorityQueue() {


		Comparator<Integer> comp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1- o2;
			}

		};

		AbstractQueue<Integer> p = new PriorityQueue<Integer>(10, comp);
		p.add(20);
		p.add(30);
		p.add(15);
		p.add(9);
		System.out.println(p.size() + " " + p.poll());
		System.out.println(p.size() + " " + p.poll());
		System.out.println(p.size() + " " + p.poll());
		System.out.println(p.size() + " " + p.poll());

	}

	private static void conditionsignalling() {
		// http://www.careercup.com/question?id=5140138881449984
		// Very complicated

		class Job implements Delayed {
			int id;
			long time;
			//TimeUn
			Job(int i, long time) {
				this.id = i;
				this.time = time;
			}
			void print() {
				System.out.println("Job with Job id: " + this.id);
			}
			@Override
			public int compareTo(Delayed o) {
				Job j = (Job) o;
				//if (this.time )
				return 0;
			}
			@Override
			public long getDelay(TimeUnit unit) {
				// TODO Auto-generated method stub
				return 0;
			}
		}


		class Client {
			private BlockingQueue<Job> bq = new DelayQueue<Job>();
		}

		class Server {

		}




	}

	private static void subset() {

		// http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/

		// set[] = {3, 34, 4, 12, 5, 2}, sum = 9 (4 , 5)

		int[] a = {3, 34, 4, 12, 5, 2};
		final int sum = 9;

		//		Set<Integer> set = new HashSet<Integer>(a.length);
		//		boolean foundsum = false;
		//		for (int i = 0, l = a.length; i < l; i++) {
		//			if (set.contains(sum - a[i])) {
		//				foundsum = true;
		//				break;
		//			}	
		//			set.add(a[i]);
		//		}
		//		if (foundsum) {
		//			System.out.println("Yes");
		//		}

		boolean subset[][] = new boolean[sum+1][a.length+1];
		for (int i = 0; i <= a.length; i++) subset[0][i] = true; // You do not pick any elements
		for (int i = 1; i <= sum; i++) subset[i][0] = false;
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= a.length; j++) {
				subset[i][j] = i >= a[j-1] ? subset[i][j-1] || subset[i - a[j-1]][j-1] : subset[i][j-1];
			}
		}
		System.out.println(subset[sum][a.length]);
	}
	private static void findtriplets() {
		// http://www.careercup.com/page?pid=linkedin-interview-questions
		// Given a array of positive integers, find all possible triangle triplets that can be formed from this array. 
		// eg: 9 8 10 7 
		// ans: 9 8 10, 9 8 7, 9 10 7, 7 8 10 
		// Note : array not sorted, there is no limit on the array length

		int[] a = new int[] {9, 8, 10, 7};
		triplet2(a, 0);
	}

	private static void triplet2(int[] a, int s) {
		triplet(a[0], a[1], a[2]);
		for (int i = s; i <= a.length - 1; i++) {
			swapInt(a, i, a.length-1);
			triplet2(a, i+1);
			swapInt(a, i, a.length-1);
		}
	}

	private static void swapInt(int[] a, int i, int j) {
		int k = a[i];
		a[i] = a[j];
		a[j] = k;
	}

	private static void triplet(int a1, int a2, int a3) {
		if (a1 + a2 > a3 && a1 + a3 > a2 && a2 + a3 > a1) {
			System.out.println("Triplet : " + a1 + " " + a2 + " " + a3);
		}
	}
	private static void permutation() {
		StringBuilder str = new StringBuilder("abcd");

		permute(str, 0, str.length()-1);

	}

	private static void permute(StringBuilder str, int n, int l) {

		for (int i = n; i <= l; i++) {
			swap(str, i, n);
			permute(str, i+1, l);
			swap(str, i, n);
		}

	}

	private static void swap(StringBuilder str, int i, int n) {
		char c = str.charAt(i);
		str.setCharAt(i, str.charAt(n));
		str.setCharAt(n, c);
	}

	// Check if  string is integer or not;
	private static void checkInt2() {
		//String num = "1234567";
		//		for (int i = 0, l = num.length(); i < l; i++) {
		//			if (num.charAt(i) >= '0' && num.charAt(i) <= '9')
		//				continue;
		//			else {
		//				System.out.println("Not a number;");
		//				return;
		//			}	
		//		}
		//		System.out.println("Number");
		String num = ".23";
		String pattern = "(\\+|-)?[\\d]+\\.?[\\d]+";
		if (num.matches(pattern)) System.out.println(num +  " : Number");
		else System.out.println(num + " : Not a number");
	}

	private static void somethings2() {
		Long noofURL = (long) Math.pow(10, 12);
		System.out.println(noofURL);
		int i = 1;
		while ((long) Math.pow(62, i) < noofURL) i++;
		System.out.println(i);
		i = 1;
		while ((long) Math.pow(2, i) < noofURL) i++;
		System.out.println(i);
		// 7 characters it is possible to encode all URLS's
		long x = (long) (8 * Math.pow(2, i));
		i = 1;
		while (Math.pow(1024, i) < x) i++;
		System.out.println(i);
		System.out.println(Math.pow(2, 40));
		System.out.println(Long.MAX_VALUE);

	}

	private static int favouriteSequenceInsert(final int [] dense, final int [] sparse, int cnt, int elem) {
		dense[cnt] = elem;
		sparse[elem] = cnt;
		cnt++;
		return cnt;
	}
	private static int favouriteSequenceSearch(final int [] dense, final int [] sparse, int cnt, int elem) {
		int s = sparse[elem];
		if (s >= cnt)
			return -1;
		if (dense[s] == elem)
			return s;
		return -1;
	}
	private static void favouriteSequenceExchange(int[] dense, int[] sparse, int cnt, int pos, int pos2) {
		int t = dense[pos];
		dense[pos] = dense[pos2];
		dense[pos2] = t;

		t = sparse[dense[pos]];
		sparse[dense[pos]] = sparse[dense[pos2]];
		sparse[dense[pos2]] = t;
	}
	private static void favouriteSequence() throws FileNotFoundException {
		// https://www.hackerrank.com/contests/w12/challenges/favourite-sequence
		//Scanner sc = new Scanner(System.in);
		File file = new File("C:\\tmp\\Input1.txt");
		Scanner sc = new Scanner(file);
		String l = sc.nextLine();
		final int N = Integer.parseInt(l);
		if (N == 0) {
			sc.close();
			return;
		}
		int[] sparse = new int[(int) Math.pow(10, 6) + 1];
		int[] dense = new int[(int) Math.pow(10, 6) + 1]; // Max distinct integers
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			l = sc.nextLine();
			final int K = Integer.parseInt(l);
			l = sc.nextLine();
			String[] l2 = l.split(" ");
			int[] a = new int[K];
			for (int j = 0, len2 = l2.length;j < len2; j++) {
				a[j] = Integer.parseInt(l2[j]);
			}
			for (int j = 0; j < K; j++) {
				int v = a[j];


			}
		}
		sc.close();
		sparse = null;
		for (int i = 0; i < cnt; i++) {
			if (i != 0)
				System.out.print(' ');
			System.out.print(dense[i]);
		}
		return;
	}
}
