package scheduler;

public class NameAndTime {
	String desc;
	Double time;
	
	NameAndTime(String desc, Double time){
		this.desc=desc;
		this.time=time;
	}
	public Double getTime() {
		return time;
	}
	public String getDesc() {
		return desc;
	}
}
