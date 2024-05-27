package myUtils.setterClass;

import java.sql.Date;
import java.sql.Timestamp;

public class ApiVo {
	
	private String id;
	
	private String password;
	
	private String name;

	private String email;

	private String handphone;
	
	private String groupId;
	
	private String kaistUid;
	
	private String userType;
	
	private String flagDispatch;
	
	private String flagTemp;
	
	private String oldPassword;
	
	private String encNewPassword;
	
	//userdetail
//	private String kaistUid;

	private String userId;

	private String koreanName;

	private String englishName;

	private String lastName;

	private String firstName;
	
	private Date birthday;

	private String nationCodeUid;

	private String sexCodeUid;

	private String emailAddress;

	private String chMail;

	private String mobileTelephoneNumber;

	private String officeTelephoneNumber;

	private String oweHomeTelephoneNumber;

	private String faxTelephoneNumber;

	private String postNumber;

	private String address;

	private String addressDetail;

	private String personId;

	private String employeeNumber;

	private String stdNo;

	private String acadOrg;

	private String acadName;

	private String acadKstOrgId;

	private String acadEbsOrgId;

	private String acadEbsOrgNameEng;

	private String acadEbsOrgNameKor;

	private String campusUid;

	private String ebsOrganizationId;

	private String ebsOrgNameEng;

	private String ebsOrgNameKor;

	private String ebsGradeNameEng;

	private String ebsGradeNameKor;

	private String ebsGradeLevelEng;

	private String ebsGradeLevelKor;

	private String ebsPersonTypeEng;

	private String ebsPersonTypeKor;

	private String ebsUserStatusEng;

	private String ebsUserStatusKor;

	private String positionEng;

	private String positionKor;

	private String stuStatusEng;

	private String stuStatusKor;

	private String acadProgCode;

	private String acadProgKor;

	private String acadProgEng;

	private String personTypeCodeUid;
	
	private Date progEffdt;

	private String stdntTypeId;

	private String stdntTypeClass;

	private String stdntCategoryId;

	private String advrEbsPersonId;

	private String advrName;

	private String advrNameAc;
	
	private Date entranceDate;

	private Date resignDate;
	
	private Date progStartDate;
	
	private Date progEndDate;

	private String advrKaistUid;

	private String creatorId;

	private Timestamp createdAt;

	private String updatorId;

	private Timestamp updatedAt;

	private String niceCi;

	private String emplid;

	private String kaistSuid;

	private String flagPermanentDeleted;

	private String flagLocked;

	private String flagUse;

//	private String userType;

	private String flagJoin;

//	private String id;

	private String initPassword;

	private String clCampus;

	private String clBuilding;

	private String clFloor;

	private String clRoomNo;

	private String outerStartDate;

	private String outerEndDate;

	private String registerDate;

	private String flagDormancy;

	private String engPostal;

	private String engAddress1;

	private String engAddress2;

	private String authenticationNumber;
	private String authenticationNumberToServer;
	private String loginedUserId;

	private String encBirthday;
	private String encEntranceDate;
	private String encResignDate;
	private String encProgStartDate;
	private String encProgEndDate;
	private String encProgEffdt;
	
	private String encChMail;
	private String encMobileTelephoneNumber;
	private String encStdNo;
	private String encId;
	private String encKaistUid;
	private String encKoreanName;
	private String encEmployeeNumber;
	private String type;
	
	private Boolean isQrCode;
	private Boolean isHandPhone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHandphone() {
		return handphone;
	}

	public void setHandphone(String handphone) {
		this.handphone = handphone;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getKaistUid() {
		return kaistUid;
	}

	public void setKaistUid(String kaistUid) {
		this.kaistUid = kaistUid;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFlagDispatch() {
		return flagDispatch;
	}

	public void setFlagDispatch(String flagDispatch) {
		this.flagDispatch = flagDispatch;
	}

	public String getFlagTemp() {
		return flagTemp;
	}

	public void setFlagTemp(String flagTemp) {
		this.flagTemp = flagTemp;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getKoreanName() {
		return koreanName;
	}

	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationCodeUid() {
		return nationCodeUid;
	}

	public void setNationCodeUid(String nationCodeUid) {
		this.nationCodeUid = nationCodeUid;
	}

	public String getSexCodeUid() {
		return sexCodeUid;
	}

	public void setSexCodeUid(String sexCodeUid) {
		this.sexCodeUid = sexCodeUid;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getChMail() {
		return chMail;
	}

	public void setChMail(String chMail) {
		this.chMail = chMail;
	}

	public String getMobileTelephoneNumber() {
		return mobileTelephoneNumber;
	}

	public void setMobileTelephoneNumber(String mobileTelephoneNumber) {
		this.mobileTelephoneNumber = mobileTelephoneNumber;
	}

	public String getOfficeTelephoneNumber() {
		return officeTelephoneNumber;
	}

	public void setOfficeTelephoneNumber(String officeTelephoneNumber) {
		this.officeTelephoneNumber = officeTelephoneNumber;
	}

	public String getOweHomeTelephoneNumber() {
		return oweHomeTelephoneNumber;
	}

	public void setOweHomeTelephoneNumber(String oweHomeTelephoneNumber) {
		this.oweHomeTelephoneNumber = oweHomeTelephoneNumber;
	}

	public String getFaxTelephoneNumber() {
		return faxTelephoneNumber;
	}

	public void setFaxTelephoneNumber(String faxTelephoneNumber) {
		this.faxTelephoneNumber = faxTelephoneNumber;
	}

	public String getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getAcadOrg() {
		return acadOrg;
	}

	public void setAcadOrg(String acadOrg) {
		this.acadOrg = acadOrg;
	}

	public String getAcadName() {
		return acadName;
	}

	public void setAcadName(String acadName) {
		this.acadName = acadName;
	}

	public String getAcadKstOrgId() {
		return acadKstOrgId;
	}

	public void setAcadKstOrgId(String acadKstOrgId) {
		this.acadKstOrgId = acadKstOrgId;
	}

	public String getAcadEbsOrgId() {
		return acadEbsOrgId;
	}

	public void setAcadEbsOrgId(String acadEbsOrgId) {
		this.acadEbsOrgId = acadEbsOrgId;
	}

	public String getAcadEbsOrgNameEng() {
		return acadEbsOrgNameEng;
	}

	public void setAcadEbsOrgNameEng(String acadEbsOrgNameEng) {
		this.acadEbsOrgNameEng = acadEbsOrgNameEng;
	}

	public String getAcadEbsOrgNameKor() {
		return acadEbsOrgNameKor;
	}

	public void setAcadEbsOrgNameKor(String acadEbsOrgNameKor) {
		this.acadEbsOrgNameKor = acadEbsOrgNameKor;
	}

	public String getCampusUid() {
		return campusUid;
	}

	public void setCampusUid(String campusUid) {
		this.campusUid = campusUid;
	}

	public String getEbsOrganizationId() {
		return ebsOrganizationId;
	}

	public void setEbsOrganizationId(String ebsOrganizationId) {
		this.ebsOrganizationId = ebsOrganizationId;
	}

	public String getEbsOrgNameEng() {
		return ebsOrgNameEng;
	}

	public void setEbsOrgNameEng(String ebsOrgNameEng) {
		this.ebsOrgNameEng = ebsOrgNameEng;
	}

	public String getEbsOrgNameKor() {
		return ebsOrgNameKor;
	}

	public void setEbsOrgNameKor(String ebsOrgNameKor) {
		this.ebsOrgNameKor = ebsOrgNameKor;
	}

	public String getEbsGradeNameEng() {
		return ebsGradeNameEng;
	}

	public void setEbsGradeNameEng(String ebsGradeNameEng) {
		this.ebsGradeNameEng = ebsGradeNameEng;
	}

	public String getEbsGradeNameKor() {
		return ebsGradeNameKor;
	}

	public void setEbsGradeNameKor(String ebsGradeNameKor) {
		this.ebsGradeNameKor = ebsGradeNameKor;
	}

	public String getEbsGradeLevelEng() {
		return ebsGradeLevelEng;
	}

	public void setEbsGradeLevelEng(String ebsGradeLevelEng) {
		this.ebsGradeLevelEng = ebsGradeLevelEng;
	}

	public String getEbsGradeLevelKor() {
		return ebsGradeLevelKor;
	}

	public void setEbsGradeLevelKor(String ebsGradeLevelKor) {
		this.ebsGradeLevelKor = ebsGradeLevelKor;
	}

	public String getEbsPersonTypeEng() {
		return ebsPersonTypeEng;
	}

	public void setEbsPersonTypeEng(String ebsPersonTypeEng) {
		this.ebsPersonTypeEng = ebsPersonTypeEng;
	}

	public String getEbsPersonTypeKor() {
		return ebsPersonTypeKor;
	}

	public void setEbsPersonTypeKor(String ebsPersonTypeKor) {
		this.ebsPersonTypeKor = ebsPersonTypeKor;
	}

	public String getEbsUserStatusEng() {
		return ebsUserStatusEng;
	}

	public void setEbsUserStatusEng(String ebsUserStatusEng) {
		this.ebsUserStatusEng = ebsUserStatusEng;
	}

	public String getEbsUserStatusKor() {
		return ebsUserStatusKor;
	}

	public void setEbsUserStatusKor(String ebsUserStatusKor) {
		this.ebsUserStatusKor = ebsUserStatusKor;
	}

	public String getPositionEng() {
		return positionEng;
	}

	public void setPositionEng(String positionEng) {
		this.positionEng = positionEng;
	}

	public String getPositionKor() {
		return positionKor;
	}

	public void setPositionKor(String positionKor) {
		this.positionKor = positionKor;
	}

	public String getStuStatusEng() {
		return stuStatusEng;
	}

	public void setStuStatusEng(String stuStatusEng) {
		this.stuStatusEng = stuStatusEng;
	}

	public String getStuStatusKor() {
		return stuStatusKor;
	}

	public void setStuStatusKor(String stuStatusKor) {
		this.stuStatusKor = stuStatusKor;
	}

	public String getAcadProgCode() {
		return acadProgCode;
	}

	public void setAcadProgCode(String acadProgCode) {
		this.acadProgCode = acadProgCode;
	}

	public String getAcadProgKor() {
		return acadProgKor;
	}

	public void setAcadProgKor(String acadProgKor) {
		this.acadProgKor = acadProgKor;
	}

	public String getAcadProgEng() {
		return acadProgEng;
	}

	public void setAcadProgEng(String acadProgEng) {
		this.acadProgEng = acadProgEng;
	}

	public String getPersonTypeCodeUid() {
		return personTypeCodeUid;
	}

	public void setPersonTypeCodeUid(String personTypeCodeUid) {
		this.personTypeCodeUid = personTypeCodeUid;
	}

	public Date getProgEffdt() {
		return progEffdt;
	}

	public void setProgEffdt(Date progEffdt) {
		this.progEffdt = progEffdt;
	}

	public String getStdntTypeId() {
		return stdntTypeId;
	}

	public void setStdntTypeId(String stdntTypeId) {
		this.stdntTypeId = stdntTypeId;
	}

	public String getStdntTypeClass() {
		return stdntTypeClass;
	}

	public void setStdntTypeClass(String stdntTypeClass) {
		this.stdntTypeClass = stdntTypeClass;
	}

	public String getStdntCategoryId() {
		return stdntCategoryId;
	}

	public void setStdntCategoryId(String stdntCategoryId) {
		this.stdntCategoryId = stdntCategoryId;
	}

	public String getAdvrEbsPersonId() {
		return advrEbsPersonId;
	}

	public void setAdvrEbsPersonId(String advrEbsPersonId) {
		this.advrEbsPersonId = advrEbsPersonId;
	}

	public String getAdvrName() {
		return advrName;
	}

	public void setAdvrName(String advrName) {
		this.advrName = advrName;
	}

	public String getAdvrNameAc() {
		return advrNameAc;
	}

	public void setAdvrNameAc(String advrNameAc) {
		this.advrNameAc = advrNameAc;
	}

	public Date getEntranceDate() {
		return entranceDate;
	}

	public void setEntranceDate(Date entranceDate) {
		this.entranceDate = entranceDate;
	}

	public Date getResignDate() {
		return resignDate;
	}

	public void setResignDate(Date resignDate) {
		this.resignDate = resignDate;
	}

	public Date getProgStartDate() {
		return progStartDate;
	}

	public void setProgStartDate(Date progStartDate) {
		this.progStartDate = progStartDate;
	}

	public Date getProgEndDate() {
		return progEndDate;
	}

	public void setProgEndDate(Date progEndDate) {
		this.progEndDate = progEndDate;
	}

	public String getAdvrKaistUid() {
		return advrKaistUid;
	}

	public void setAdvrKaistUid(String advrKaistUid) {
		this.advrKaistUid = advrKaistUid;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatorId() {
		return updatorId;
	}

	public void setUpdatorId(String updatorId) {
		this.updatorId = updatorId;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getNiceCi() {
		return niceCi;
	}

	public void setNiceCi(String niceCi) {
		this.niceCi = niceCi;
	}

	public String getEmplid() {
		return emplid;
	}

	public void setEmplid(String emplid) {
		this.emplid = emplid;
	}

	public String getKaistSuid() {
		return kaistSuid;
	}

	public void setKaistSuid(String kaistSuid) {
		this.kaistSuid = kaistSuid;
	}

	public String getFlagPermanentDeleted() {
		return flagPermanentDeleted;
	}

	public void setFlagPermanentDeleted(String flagPermanentDeleted) {
		this.flagPermanentDeleted = flagPermanentDeleted;
	}

	public String getFlagLocked() {
		return flagLocked;
	}

	public void setFlagLocked(String flagLocked) {
		this.flagLocked = flagLocked;
	}

	public String getFlagUse() {
		return flagUse;
	}

	public void setFlagUse(String flagUse) {
		this.flagUse = flagUse;
	}

	public String getFlagJoin() {
		return flagJoin;
	}

	public void setFlagJoin(String flagJoin) {
		this.flagJoin = flagJoin;
	}

	public String getInitPassword() {
		return initPassword;
	}

	public void setInitPassword(String initPassword) {
		this.initPassword = initPassword;
	}

	public String getClCampus() {
		return clCampus;
	}

	public void setClCampus(String clCampus) {
		this.clCampus = clCampus;
	}

	public String getClBuilding() {
		return clBuilding;
	}

	public void setClBuilding(String clBuilding) {
		this.clBuilding = clBuilding;
	}

	public String getClFloor() {
		return clFloor;
	}

	public void setClFloor(String clFloor) {
		this.clFloor = clFloor;
	}

	public String getClRoomNo() {
		return clRoomNo;
	}

	public void setClRoomNo(String clRoomNo) {
		this.clRoomNo = clRoomNo;
	}

	public String getOuterStartDate() {
		return outerStartDate;
	}

	public void setOuterStartDate(String outerStartDate) {
		this.outerStartDate = outerStartDate;
	}

	public String getOuterEndDate() {
		return outerEndDate;
	}

	public void setOuterEndDate(String outerEndDate) {
		this.outerEndDate = outerEndDate;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFlagDormancy() {
		return flagDormancy;
	}

	public void setFlagDormancy(String flagDormancy) {
		this.flagDormancy = flagDormancy;
	}

	public String getEngPostal() {
		return engPostal;
	}

	public void setEngPostal(String engPostal) {
		this.engPostal = engPostal;
	}

	public String getEngAddress1() {
		return engAddress1;
	}

	public void setEngAddress1(String engAddress1) {
		this.engAddress1 = engAddress1;
	}

	public String getEngAddress2() {
		return engAddress2;
	}

	public void setEngAddress2(String engAddress2) {
		this.engAddress2 = engAddress2;
	}

	public String getAuthenticationNumber() {
		return authenticationNumber;
	}

	public void setAuthenticationNumber(String authenticationNumber) {
		this.authenticationNumber = authenticationNumber;
	}

	public String getAuthenticationNumberToServer() {
		return authenticationNumberToServer;
	}

	public void setAuthenticationNumberToServer(String authenticationNumberToServer) {
		this.authenticationNumberToServer = authenticationNumberToServer;
	}

	public String getLoginedUserId() {
		return loginedUserId;
	}

	public void setLoginedUserId(String loginedUserId) {
		this.loginedUserId = loginedUserId;
	}

	public String getEncBirthday() {
		return encBirthday;
	}

	public void setEncBirthday(String encBirthday) {
		this.encBirthday = encBirthday;
	}

	public String getEncChMail() {
		return encChMail;
	}

	public void setEncChMail(String encChMail) {
		this.encChMail = encChMail;
	}

	public String getEncMobileTelephoneNumber() {
		return encMobileTelephoneNumber;
	}

	public void setEncMobileTelephoneNumber(String encMobileTelephoneNumber) {
		this.encMobileTelephoneNumber = encMobileTelephoneNumber;
	}

	public String getEncStdNo() {
		return encStdNo;
	}

	public void setEncStdNo(String encStdNo) {
		this.encStdNo = encStdNo;
	}

	public String getEncId() {
		return encId;
	}

	public void setEncId(String encId) {
		this.encId = encId;
	}

	public String getEncKaistUid() {
		return encKaistUid;
	}

	public void setEncKaistUid(String encKaistUid) {
		this.encKaistUid = encKaistUid;
	}

	public String getEncKoreanName() {
		return encKoreanName;
	}

	public void setEncKoreanName(String encKoreanName) {
		this.encKoreanName = encKoreanName;
	}

	public String getEncEmployeeNumber() {
		return encEmployeeNumber;
	}

	public void setEncEmployeeNumber(String encEmployeeNumber) {
		this.encEmployeeNumber = encEmployeeNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsQrCode() {
		return isQrCode;
	}

	public void setIsQrCode(Boolean isQrCode) {
		this.isQrCode = isQrCode;
	}

	public Boolean getIsHandPhone() {
		return isHandPhone;
	}

	public void setIsHandPhone(Boolean isHandPhone) {
		this.isHandPhone = isHandPhone;
	}

	public String getEncNewPassword() {
		return encNewPassword;
	}

	public void setEncNewPassword(String encNewPassword) {
		this.encNewPassword = encNewPassword;
	}

	public String getEncEntranceDate() {
		return encEntranceDate;
	}

	public void setEncEntranceDate(String encEntranceDate) {
		this.encEntranceDate = encEntranceDate;
	}

	public String getEncResignDate() {
		return encResignDate;
	}

	public void setEncResignDate(String encResignDate) {
		this.encResignDate = encResignDate;
	}

	public String getEncProgStartDate() {
		return encProgStartDate;
	}

	public void setEncProgStartDate(String encProgStartDate) {
		this.encProgStartDate = encProgStartDate;
	}

	public String getEncProgEndDate() {
		return encProgEndDate;
	}

	public void setEncProgEndDate(String encProgEndDate) {
		this.encProgEndDate = encProgEndDate;
	}

	public String getEncProgEffdt() {
		return encProgEffdt;
	}

	public void setEncProgEffdt(String encProgEffdt) {
		this.encProgEffdt = encProgEffdt;
	}
	
	
}
