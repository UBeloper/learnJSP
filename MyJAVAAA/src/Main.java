class Method {
	private static int staticNum = 1;
	
	public Method() {
		System.out.println("생성자!!!");
	}
	
	public void call () {
	staticNum++;
	System.out.println(staticNum);
	}
	
}

public class Main {
	
	public static void main(String[] args) {
		Method met = new Method();
		met.call();
		
		Method met2 = new Method();
		met.call();
		
		Method met3 = new Method();
		met.call();

	}
	

}
