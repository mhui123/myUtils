package myUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class setterGen {
	
	public static void main(String[] args) throws IOException {
		generateTemplate();
	}
	
	private static void generateTemplate() throws IOException {
		String setTarget = "userdetail";
		String resource = "vo";
		List<String> vars = Arrays.asList("id","password","name","email","handphone","groupId","kaistUid","userType","flagDispatch","flagTemp","oldPassword","encNewPassword","userId","koreanName","englishName","lastName","firstName","birthday","nationCodeUid","sexCodeUid","emailAddress","chMail","mobileTelephoneNumber","officeTelephoneNumber","oweHomeTelephoneNumber","faxTelephoneNumber","postNumber","address","addressDetail","personId","employeeNumber","stdNo","acadOrg","acadName","acadKstOrgId","acadEbsOrgId","acadEbsOrgNameEng","acadEbsOrgNameKor","campusUid","ebsOrganizationId","ebsOrgNameEng","ebsOrgNameKor","ebsGradeNameEng","ebsGradeNameKor","ebsGradeLevelEng","ebsGradeLevelKor","ebsPersonTypeEng","ebsPersonTypeKor","ebsUserStatusEng","ebsUserStatusKor","positionEng","positionKor","stuStatusEng","stuStatusKor","acadProgCode","acadProgKor","acadProgEng","personTypeCodeUid","progEffdt","stdntTypeId","stdntTypeClass","stdntCategoryId","advrEbsPersonId","advrName","advrNameAc","entranceDate","resignDate","progStartDate","progEndDate","advrKaistUid","creatorId","createdAt","updatorId","updatedAt","niceCi","emplid","kaistSuid","flagPermanentDeleted","flagLocked","flagUse","flagJoin","initPassword","clCampus","clBuilding","clFloor","clRoomNo","outerStartDate","outerEndDate","registerDate","flagDormancy","engPostal","engAddress1","engAddress2","authenticationNumber","authenticationNumberToServer","loginedUserId");
		
		try {
			for(int i = 0; i < vars.size(); i ++) {
				String fieldName = vars.get(i);
				String setterName = ".set" + fieldName.substring(0,1).toUpperCase()  + fieldName.substring(1);
				String getterName = resource + ".get" + fieldName.substring(0,1).toUpperCase()  + fieldName.substring(1) + "()";
				String sentence = setTarget + setterName + "(" + getterName + ");";
				System.out.println(sentence);
				
				if(i % 10 == 0 && i > 0) {
					System.out.println("\n");
				}
			}
		}
		catch(Exception e) {
			System.out.println();
		}
	}
	
}
