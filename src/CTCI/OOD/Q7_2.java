package CTCI.OOD;

import java.util.ArrayList;
import java.util.Iterator;

public class Q7_2 {
	enum requestLevel{respondent, manager, director}
	
	public class call {
		String name;
		int difficulty;
		requestLevel rLvl;
		

		private call() {
			this.difficulty = 0;
			this.name = "a call";
			rLvl = requestLevel.respondent;
		}

		private call(int i, String s) {
			this.difficulty = i;
			this.name = s;
			rLvl = requestLevel.respondent;
		}
		
		public void escalate() {
			if(this.rLvl == requestLevel.respondent) {
				this.rLvl = requestLevel.manager;
			}else {
				this.rLvl = requestLevel.director;
			}
			
		}
	}

	public class employee {
		String name;
		int ability;
		requestLevel rLvl;
		boolean freeFlag = true;

		public boolean isFree() {

			return freeFlag;
		}

		public boolean answerCall(call c) {
			System.out.println("incoming call :"+c.name+" with "+c.rLvl + " and " + c.difficulty);
			System.out.println("this is       :"+this.name+" with "+this.rLvl+" and "+ this.ability);
			
			if (!this.isFree()) {
				escalte(c);
				System.out.println(this.getClass()+"not free");
				return false;
			}
			if(c.rLvl != this.rLvl) {
				this.freeFlag = true;
				System.out.println(c.name+" should not solve by "+this.name);
				return false;
			}
			
			if (c.difficulty < this.ability && c.rLvl==this.rLvl) {
				this.freeFlag = false;
				System.out.println(c.name+"solved by "+this.name);
				this.freeFlag = true;
				return true;
			} else {
				this.freeFlag = true;
				System.out.println(c.name+" too difficlut, escalate by " + this.name);
				escalte(c);
				return false;
			}
		}

		public void escalte(call c) {
			c.escalate();
			this.freeFlag = true;
		}
	}

	public class respondent extends employee {
		public respondent() {
			this.ability = 0;
			this.rLvl = requestLevel.respondent;
			this.name = "respondent noname";
		}

		public respondent(int i, String s ) {
			this.ability = 4;
			this.rLvl = requestLevel.respondent;
			this.name = s;
		}
	}

	public class manager extends employee {
		public manager() {
			this.ability = 0;
			this.rLvl = requestLevel.manager;
			this.name = "manager noname";;
		}

		public manager(int i, String s) {
			this.ability = 6;
			this.rLvl = requestLevel.manager;
			this.name = s;
		}
	}

	public class director extends employee {
		public director() {
			this.ability = 8;
			this.rLvl = requestLevel.director;
			this.name = "director noname";;
		}

		public director(int i, String s) {
			this.ability = i;
			this.rLvl = requestLevel.director;
			this.name = s;
		}
	}

	public void dispatchAll(ArrayList<call> c, ArrayList<employee> e) {
		Iterator<call> i = c.iterator();
		while( i.hasNext() && !e.isEmpty()) {
			
			//Iterator<call> i = c.iterator();
			for(;i.hasNext();) {
				call aCall = i.next();
				for(employee anEmployee : e) {
					if(anEmployee.isFree()) {
						if(anEmployee.answerCall(aCall)) {
							
							i.remove();
							break;
						}else {
							continue;
						}
					}
				}
			}
		}
		
		

	}

	public static void main(String[] args) {

		Q7_2 instance = new Q7_2();
		call c1 = instance.new call(3, "c1");
		call c2 = instance.new call(5,"c2");
		call c3 = instance.new call();
		call c4 = instance.new call(8,"c4");
		ArrayList<call> c = new ArrayList();
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		
		employee r1 = instance.new respondent(1,"r1");
		employee r2 = instance.new respondent(2,"r2");
		

		employee m1 = instance.new manager(6,"m1");
		employee m2 = instance.new manager(7,"m2");
		

		employee d1 = instance.new director(8,"d1");
		employee d2 = instance.new director(99,"d2");

		ArrayList<employee> e = new ArrayList();
		e.add(r1);
		e.add(r2);
		e.add(m1);
		e.add(m2);
		e.add(d1);
		e.add(d2);
		
		instance.dispatchAll(c ,e);
	}

}
