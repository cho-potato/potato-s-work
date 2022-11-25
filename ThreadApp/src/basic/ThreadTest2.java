package basic;

// 메인도 쓰레드이기에  sleep이 가능하다.
// 메엔 쓰레드는 프로그램 운영을 담당한다. 
// 개발자가 생성한 것이 아니라, 시스템이 지원하는 실행부이다.
// GUI 프로그램에서는 만일 메인 쓰레드를 루프나 대기상태에 두면 이벤트나 그래픽처리가 먹통이 되어 버림
// 일반적인 응용프로그래밍 분야에서는 금지사항이다
public class ThreadTest2 {

	public static void ThreadTest2() {
		while (true) {
			System.out.println("★");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
