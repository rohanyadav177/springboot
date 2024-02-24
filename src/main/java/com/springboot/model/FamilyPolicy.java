package com.springboot.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "family_member")
public class FamilyPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;

	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id")	
	private List<User> user; // Reference to the user to which this family member belongs

	@Column(name = "full_name")
	private String fullName;
	
	private String mobileNo;
	
	private String relationship;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	private String gender;

	private String occupation;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
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

	@Override
	public String toString() {
		return "FamilyPolicy [memberId=" + memberId + ", user=" + user + ", fullName=" + fullName + ", mobileNo="
				+ mobileNo + ", relationship=" + relationship + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", occupation=" + occupation + "]";
	}

	

	
	

}
