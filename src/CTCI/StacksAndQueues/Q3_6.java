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
		while(shelter.peek().species != s) {
			//shelter.next();
		}
		
		
	}
	
	public void dequeueCat() {
		
	}
}
