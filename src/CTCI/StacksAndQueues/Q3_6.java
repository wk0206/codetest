package CTCI.StacksAndQueues;

import java.util.LinkedList;

public class Q3_6 {
	
	private LinkedList<oneAnimal> shelter = new LinkedList<>();
	
	private class oneAnimal{
		Species species;
		oneAnimal next;
		
		public oneAnimal(Species s) {
			this.species = s;
		}
	}
	
	private enum Species{
		dog,cat
	} 

	public void enqeue(oneAnimal animal) {
			shelter.add(animal);
	}
	
	public void dequeueAny() {
			shelter.pop();
	}
	
	public void dequeueDog(Species s) {
		oneAnimal current = shelter.peek();
		oneAnimal previous = null;
		while(current!=null) {
			
			if(current.species==s.dog) {
				//pop this and cut
				previous.next = current.next;
				//break
				break;
			}
			previous = current;
			current = current.next;
		}
	
	}
	
	public void dequeueCat(Species s) {
		oneAnimal current = shelter.peek();
		oneAnimal previous = null;
		while(current!=null) {
			
			if(current.species==s.cat) {
				//pop this and cut
				//p--->c--->n
				//p-------->n
				previous.next = current.next;
				//break
				break;
			}
			previous = current;
			current = current.next;
		}
	}
}
