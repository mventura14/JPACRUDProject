package com.skilldistillery.runlog.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "run_log")
public class RunLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	private String type;

	@Column(name = "distance_in_miles")
	private Double distanceInMiles;

	@Column(name = "time_in_minutes")
	private Integer timeInMinutes;

	private LocalDate date;

/////////////////////////////////////////////////////////////////////////////////////////////////

	public RunLog() {
	}

/////////////////////////////////////////////////////////////////////////////////////////////////	

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////	

	public Double getDistanceInMiles() {
		return distanceInMiles;
	}

	public void setDistanceInMiles(Double distanceInMiles) {
		this.distanceInMiles = distanceInMiles;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////	

	public Integer getTimeInMinutes() {
		return timeInMinutes;
	}

	public void setTimeInMinutes(Integer timeInMinutes) {
		this.timeInMinutes = timeInMinutes;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RunLog other = (RunLog) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "RunLog [id=" + id + ", description=" + description + ", type=" + type + ", distanceInMiles="
				+ distanceInMiles + ", timeInMinutes=" + timeInMinutes + ", date=" + date + "]";
	}

/////////////////////////////////////////////////////////////////////////////////////////////////	

}
