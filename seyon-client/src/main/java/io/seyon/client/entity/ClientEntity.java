package io.seyon.client.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
public class ClientEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2658424664266410103L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@NonNull
	@Size(min = 3, message = "Please enter the Client name")
	@Column
	String name;
	
	@NonNull
	@Size(min = 3, message = "Please enter the Address")
	@Column
	String addrLine1;
	
	@Column
	String addrLine2;
	
	@NonNull
	@Size(min = 3, message = "Please enter the City")
	@Column
	String city;
	
	@NonNull
	@Size(min = 2, message = "Please enter the State")
	@Column
	String state;
	
	@NonNull
	@Size(min = 6, max = 6, message = "Please enter the Pincode")
	@Column
	String pinCode;

	@NonNull
	@Size(min = 10, max = 12, message = "Please enter the Primary phone")
	@Column
	String phonePrimary;

	@Column
	String phoneSecondary;
	
	@Column
	String faxNo;

	@NonNull
	@Size(min = 10, message = "Please enter the PAN")
	@Column
	String pan;
	
	@NonNull
	@Size(min = 15,max=20, message = "Please enter the GSTIN")
	@Column
	String gstin;
	
	@NonNull
	@Size(min=15,max=20,message="Please enter the Primary phone" )
	@Column
	String ServiceTaxRegNo;
	
	@NonNull
	@Size(min=3,message="Please enter the Primary phone" )
	@Column
	String accountingType;
	
	@NonNull
	@Lob
	String logoImg;
	
	@Lob
	@Column
	String signatureImg;
	
	@NonNull
	@Email(message="Please enter the valid email id")
	@Column
	String email;
	
	@NonNull
	@Size(min=3,message="Please enter the Bank Name")
	@Column
	String bankName;
	
	@NonNull
	@Size(min=5,max=20,message="Please enter the Bank Account Number")
	@Column
	String bankAcctNumber;
	
	@NonNull
	@Size(min=9,max=15,message="Please enter the IFSC CODE")
	@Column
	String ifscCode;
	
	@NonNull
	@Size(min=3,max=15,message="Please enter the Bank Branch")
	@Column
	String bankBranch;
	
	@NonNull
	@Size(min=3,max=15,message="Please enter the Account Type")
	@Column
	String accountType;
	
	@NonNull
	@Size(min=3,max=15,message="Please enter the Shift Code")
	@Column
	String swiftCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getPhonePrimary() {
		return phonePrimary;
	}

	public void setPhonePrimary(String phonePrimary) {
		this.phonePrimary = phonePrimary;
	}

	public String getPhoneSecondary() {
		return phoneSecondary;
	}

	public void setPhoneSecondary(String phoneSecondary) {
		this.phoneSecondary = phoneSecondary;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getServiceTaxRegNo() {
		return ServiceTaxRegNo;
	}

	public void setServiceTaxRegNo(String serviceTaxRegNo) {
		ServiceTaxRegNo = serviceTaxRegNo;
	}

	public String getAccountingType() {
		return accountingType;
	}

	public void setAccountingType(String accountingType) {
		this.accountingType = accountingType;
	}

	public String getLogoImg() {
		return logoImg;
	}

	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}

	public String getSignatureImg() {
		return signatureImg;
	}

	public void setSignatureImg(String signatureImg) {
		this.signatureImg = signatureImg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAcctNumber() {
		return bankAcctNumber;
	}

	public void setBankAcctNumber(String bankAcctNumber) {
		this.bankAcctNumber = bankAcctNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

}
