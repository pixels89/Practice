package in.barmans.practice;

public class Exponential {

	static int count = 0;

	public static void main(String[] args) {
		recurse(3);
		System.out.println("called times");
		System.out.println(count);
		System.out.println(Math.pow(3, 10));
	}

	public static void recurse(int a) {
		if (a > 0) {
			count++;
		
			int less = --a;
			recurse(less);
			recurse(less);
			recurse(less);
			
			
		}
	}

}
