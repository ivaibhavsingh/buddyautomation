package databuddy.databuddy;

public class TestClass {
		
	public static void main(String []args) {
		int i=0;
		int start=0;
		StringBuilder sb = new StringBuilder();
		sb.append("Vaibhav,");
		sb.append("Singh,");
		sb.append("Gurgaon,");
		sb.append("Batman.");
		System.out.println(sb.length());
		
		for(i=0;i<=sb.length()-1;i++) {
			if(sb.charAt(i)==',') {
				System.out.println(sb.substring(start,i));
				start=i+1;
			}
			else if(sb.charAt(i)=='.')
				System.out.println(sb.substring(start, sb.length()-1));
		}
		
		/*String arr[] = new String[] {"Vaibhav", "Singh", "Gurgaon", "Batman"};
		System.out.println(arr[0]);*/
		
	}
}
