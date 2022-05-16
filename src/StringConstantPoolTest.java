
/**
 * @author 전상훈
 * StringConstantPool 스트링 상수 풀에 대해서 알아보자.
 * 
 * 장점 : 같은 문자열은 같은 공간을 공유하므로, 메모리 관리의 효율이 높아진다.
 * 단점 : 문자열을 변경하게 될 때마다 새로운 공간이 생겨나므로, 메모리 낭비가 심해진다. -> 그래서 StringBuilder나 StringBuffer를 쓸 수 있다.
 *
 */
public class StringConstantPoolTest {

	//기본적으로 String 문자열끼리의 비교는 equals()메소드를 사용한다.
	public static void main(String[] args) {
		//String은 레퍼런스 타입이기 때문에 원래대로라면 new를 통해 인스턴스를 생성하여 문자열을 담을 공간을 할당받아야 한다.
		//그래서 같은 내용의 문자열을 담는다고 하더라도, 인스턴스가 다르면 가리키는 주소값이 다르기때문에 다른 값이 된다.
		String s1 = new String("바다"); //100번지라고 가정
		String s2 = new String("바다"); //20번지라고 가정
		//두개의 해시코드값이 같은 이유는 Object클래스로부터 상속받아 오버라이드 됐기 때문에, 본래의 hashCode값의 기능을 하지 못한다.
//		System.out.println((Object)s1.hashCode());
//		System.out.println((Object)s2.hashCode());
		System.out.println(s1 == s2);
		
		//아래 예제는 heap메모리에 올라가는 것이 아니라 StringConstantPool에서 관리되어지므로,
		//같은 단어가 메모리에 올라가는 것을 방지하여 메모리 관리가 편해진다.
		String s3 = "바다"; //StringConstantPool에 생성되어 같은 주소를 바라보게 된다.
		String s4 = "바다"; //StringConstantPool에 생성되어 같은 주소를 바라보게 된다.
		System.out.println(s3 == s4); //StringConstantPool에서 같은 주소를 바라보게되므로, true가 나온다.
		
		//이런식으로 단어를 만들면, StringConstantPool에서 "바다태양"이라는 공간을 새로 만들어 할당하고 s3는 해당 메모리 영역을 가리킨다.
		//만약 "바다"를 가리키는 객체가 존재하지 않으면, 자바 가비지컬렉터에 의해 해당 영역은 메모리에서 사라지게 된다.
		s3 = s3+"태양";
	}

}
