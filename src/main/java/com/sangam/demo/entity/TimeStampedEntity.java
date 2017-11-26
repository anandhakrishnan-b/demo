package com.sangam.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@JsonIgnoreProperties(value = { "dateCreated", "dateUpdated"}, allowGetters=true)
public class TimeStampedEntity {

	@Column(name = "DATE_CREATED")
	private LocalDateTime dateCreated;

	@Column(name = "DATE_UPDATED")
	private LocalDateTime dateUpdated;

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	
	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}

	
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}


	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}


	@Override
	public String toString() {
		return "TimestampedEntity [dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeStampedEntity other = (TimeStampedEntity) obj;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
			return false;
		return true;
	}
	
	

}
