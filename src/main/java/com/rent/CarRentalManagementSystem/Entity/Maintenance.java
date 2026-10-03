package com.rent.CarRentalManagementSystem.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="maintenance")
public class Maintenance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="maintain_id")
	private int maintainId;
	
	@ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
	
	@Column(columnDefinition="TEXT")
	private String problem;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name = "status")
    private String status;
	
	public int getMaintainId() {
		return maintainId;
	}
	
    public Maintenance() {
		
	}


	public void setMaintainId(int maintainId) {
		this.maintainId = maintainId;
	}



	public Car getCar() {
		return car;
	}



	public void setCar(Car car) {
		this.car = car;
	}



	public String getProblem() {
		return problem;
	}



	public void setProblem(String problem) {
		this.problem = problem;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	 // Display ID (UI Console)
    public String getDisplayMaintainId() {
        return String.format("M-%04d", maintainId);
    }
	
	@Override
	public String toString() {
	    return "Maintenance ID  : " + getDisplayMaintainId() +
	           "\nCar ID        : " + car.getDisplayCarId() +
	           "\nProblem       : " + problem +
	           "\nStart Date    : " + startDate +
	           "\nEnd Date      : " + endDate +
	           "\nStatus        : " + status;
	}

}
