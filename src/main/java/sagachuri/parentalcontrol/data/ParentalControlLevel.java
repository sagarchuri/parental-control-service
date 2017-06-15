package sagachuri.parentalcontrol.data;

public enum ParentalControlLevel {

	U("U",0), PG("PG",10), TWELVE("12",12), FIFTEEN("15",15), EIGHTEEN("18",18);
	
	private final String level;
	private final Integer age;
	
	ParentalControlLevel(String level, int age){
		this.level = level;
		this.age = age;	
	}
	
	public String getLevel(){
		return level;
	}
	
	public Integer getAge(){
		return age;
	}

}
