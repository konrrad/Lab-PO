package agh.cs.lab1;

public enum Direction {
	
    FORWARD {
		@Override
		public void write() {
			System.out.println("Zwierzak idzie do przodu,");
			
		}
	} ,
    BACKWARD {
		@Override
		public void write() {
			System.out.println("Zwierzak idzie do tyłu,");
			
		}
	},
    LEFT {
		@Override
		public void write() {
			System.out.println("Zwierzak idzie w lewo,");
			
		}
	},
    RIGHT {
		@Override
		public void write() {
			System.out.println("Zwierzak idzie w prawo,");
			
		}
	};
    public static Direction convert(String el) {
		if(el.equals("f")) return FORWARD;
		else if(el.equals("b")) return BACKWARD;
		else if(el.equals("l")) return LEFT;
		else if(el.equals("r")) return RIGHT;
		return null;
	}

	public abstract void write();

}
