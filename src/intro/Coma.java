package intro;

/*
 * �����, ������� ����� �����, ���� ��� ����� �� interrupt �� �������
 */
public class Coma{
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Main: sleep!");
		Thread.currentThread().join(); //���� ����� ������, ���� ���-������ ��� �����!
		System.out.println("Main: wake up!");
	}
}
