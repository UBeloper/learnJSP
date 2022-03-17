public class Myjava {
	
	public int c;

	public static void main(String[] args) {
		System.out.println("안녕하세요");

		MAM mam = new MAM();
		MAM mam2 = new MAM();
		MAM mam3 = new MAM();
	
		
	}

	
	
}

class MAM {
	int a;
	static int b;
	
	public MAM() {
		this.a += 1;
		this.b += 1;
		System.out.println(a);
		System.out.println(b);
	}
}
