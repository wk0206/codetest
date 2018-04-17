package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorTest {
	
	public static class incComparator implements Comparator<ComparatorTestDataStructure>{

		@Override
		public int compare(ComparatorTestDataStructure o1, ComparatorTestDataStructure o2) {
			// TODO Auto-generated method stub
			if(o1.A >= o2.A) {
				return 1;
			}else {
				return -1;
			}
		}
		
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComparatorTestDataStructure d1 = new ComparatorTestDataStructure();
		
		ComparatorTestDataStructure d2 = new ComparatorTestDataStructure();
		
		d1.A = 30;
		d2.A = 20;
		
		TreeSet<ComparatorTestDataStructure> t1 = new TreeSet<ComparatorTestDataStructure>( new incComparator());
		t1.add(d1);
		t1.add(d2);
		
		ComparatorTestDataStructure d3 = new ComparatorTestDataStructure();
		
		ComparatorTestDataStructure d4 = new ComparatorTestDataStructure();
		d3.A = 110;
		d4.A = 14;
		
		t1.add(d3);
		t1.add(d4);

		
		t1.toString();
		
		TreeSet<ComparatorTestDataStructure> t2 = new TreeSet<ComparatorTestDataStructure>( new Comparator<ComparatorTestDataStructure>() {
			@Override
			public int compare(ComparatorTestDataStructure o1, ComparatorTestDataStructure o2) {
				// TODO Auto-generated method stub
				if(o1.B >= o2.B) {
					return 1;
				}else {
					return -1;
				}
			}
		});
		d1.B = 1;
		d2.B = 20;
		d3.B = 15;
		d4.B = 99;
		
		t2.add(d1);
		t2.add(d2);
		t2.add(d3);
		t2.add(d4);
		
		t2.toString();

	}
}

class Teacher implements Comparable<Teacher>{  
    private Long id;  
      
    public Teacher() {  
    }  
    public Teacher(Long id) {  
        this.id = id;  
    }  
  
    public Long getId() {  
        return id;  
    }  
    public void setId(Long id) {  
        this.id = id;  
    }  
      
    @Override  
    public int compareTo(Teacher o) {  
        return (int) (this.id - o.getId());  
    }  
}  


class Student {  
	  
    private Long id;  
  
    public Student() {  
    }  
    public Student(Long id) {  
        this.id = id;  
    }  
  
    public Long getId() {  
        return id;  
    }  
    public void setId(Long id) {  
        this.id = id;  
    }  
} 


class StudentComparator implements Comparator<Student> {  
    @Override  
    public int compare(Student o1, Student o2) {  
        return (int) (o1.getId() - o2.getId()); 
    }  
}  