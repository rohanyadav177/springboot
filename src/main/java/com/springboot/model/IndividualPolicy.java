package com.springboot.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "individual_policy_holder")
public class IndividualPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyHolderId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "full_name")
	private String fullName;
	
	
	private String mobileNo;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	private String gender;

	private String occupation;

	public Long getPolicyHolderId() {
		return policyHolderId;
	}

	public void setPolicyHolderId(Long policyHolderId) {
		this.policyHolderId = policyHolderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "IndividualPolicy [policyHolderId=" + policyHolderId + ", user=" + user + ", fullName=" + fullName
				+ ", mobileNo=" + mobileNo + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", occupation="
				+ occupation + "]";
	}
	
	

}
