package ch.zli.m223.model;
import javax.persistence.*;

@Entity
public class Weekday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Weekday;

    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getWeekday() {
		return Weekday;
	}
	public void setWeekday(String weekday) {
		Weekday = weekday;
	}


    

    
}
