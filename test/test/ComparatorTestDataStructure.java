package test;

import java.io.Serializable;

public class ComparatorTestDataStructure implements Serializable{

		int A;
		int B;
		String S;
		
		protected ComparatorTestDataStructure() {
			
		}
		
		protected ComparatorTestDataStructure(int i , String s) {
			this.A = i;
			this.B = 0;
			this.S = s;
		}
		
		@Override
		public String toString() {
			System.out.println(""+this.A+"----"+this.B+this.S);
			return "";
		}
		
}
