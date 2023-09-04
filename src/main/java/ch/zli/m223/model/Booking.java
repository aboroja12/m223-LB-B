package ch.zli.m223.model;
import javax.persistence.*;
import java.util.Date;



@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String bookingPeriod;
    private Boolean isCancelled;
    private Boolean isAccepted;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

	@ManyToOne
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBookingPeriod() {
		return bookingPeriod;
	}
	public void setBookingPeriod(String bookingPeriod) {
		this.bookingPeriod = bookingPeriod;
	}
	public Boolean getIsCancelled() {
		return isCancelled;
	}
	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	public Boolean getIsAccepted() {
		return isAccepted;
	}
	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}


    


    
}
