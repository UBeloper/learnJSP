import java.util.Arrays;
import java.util.List;

public interface Movable {

    public void move();
}

class Car implements Movable {

    @Override
    public void move() {
        System.out.println("도로로 달립니다.");
    }
}

class Airplane implements Movable {

    @Override
    public void move() {
        System.out.println("하늘을 납니다.");
    }
}

class Train implements Movable {

    @Override
    public void move() {
        System.out.println("선로로 주행합니다.");
    }
}

class Main {
	
public static void main(String[] args) {
	List<Movable> mov = Arrays.asList(new Car(), new Train(), new Airplane());
	
	System.out.print(mov.hashCode());
}
}