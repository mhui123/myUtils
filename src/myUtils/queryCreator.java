package myUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class queryCreator {
	
	public static void main(String[] args) throws IOException {
		generateTemplate();
	}
	
	/*
	 * 대상 테이블에서 NOT NULL 조건은 아니지만 반드시 값이 들어있는 칼럼을 찾는 쿼리를 생성한다.
	 * 1. tableName 에 대상 테이블이름을 입력한다.
	 * 2. targetColumns에 대상 테이블의 모든 칼럼들을 입력한다.
	 * 3. 실행
	 * 4. 콘솔 내용을 복사하거나 outputPath에 생성된 파일에서 결과물을 확인한다.
	 * 5. \n을 vscode등의 에디터로 replace하여 가시성을 좋게 한다.
	 * */
	private static void generateTemplate() throws IOException {
		String fileName = "/selectQueryTemp.txt";
		String path = "src/resources/queryTemp";
		String outputPath = "src/resources/output/output.txt";

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		String target = absolutePath + fileName;
		
		String tableName = "BDSUSERDETAIL";
		List<String> targetColumns = Arrays.asList("KAISTUID","USERID","KOREAN_NAME","ENGLISH_NAME","LAST_NAME","FIRST_NAME","BIRTHDAY","NATION_CODE_UID","SEX_CODE_UID","EMAIL_ADDRESS","CH_MAIL","MOBILE_TELEPHONE_NUMBER","OFFICE_TELEPHONE_NUMBER","OWE_HOME_TELEPHONE_NUMBER","FAX_TELEPHONE_NUMBER","POST_NUMBER","ADDRESS","ADDRESS_DETAIL","PERSON_ID","EMPLOYEE_NUMBER","STD_NO","ACAD_ORG","ACAD_NAME","ACAD_KST_ORG_ID","ACAD_EBS_ORG_ID","ACAD_EBS_ORG_NAME_ENG","ACAD_EBS_ORG_NAME_KOR","CAMPUS_UID","EBS_ORGANIZATION_ID","EBS_ORG_NAME_ENG","EBS_ORG_NAME_KOR","EBS_GRADE_NAME_ENG","EBS_GRADE_NAME_KOR","EBS_GRADE_LEVEL_ENG","EBS_GRADE_LEVEL_KOR","EBS_PERSON_TYPE_ENG","EBS_PERSON_TYPE_KOR","EBS_USER_STATUS_ENG","EBS_USER_STATUS_KOR","POSITION_ENG","POSITION_KOR","STU_STATUS_ENG","STU_STATUS_KOR","ACAD_PROG_CODE","ACAD_PROG_KOR","ACAD_PROG_ENG","PERSON_TYPE_CODE_UID","PROG_EFFDT","STDNT_TYPE_ID","STDNT_TYPE_CLASS","STDNT_CATEGORY_ID","ADVR_EBS_PERSON_ID","ADVR_NAME","ADVR_NAME_AC","ENTRANCE_DATE","RESIGN_DATE","PROG_START_DATE","PROG_END_DATE","ADVR_KAIST_UID","NICECI","EMPLID","KAIST_SUID","CREATORID","CREATEDAT","UPDATORID","UPDATEDAT","FLAGPERMANENTDELETED","CL_CAMPUS","CL_BUILDING","CL_FLOOR","CL_ROOM_NO","OUTER_START_DATE","OUTER_END_DATE","REGISTER_DATE","ENG_POSTAL","ENG_ADDRESS1","ENG_ADDRESS2");
		
		String withRow = "(SELECT COUNT(*) FROM @{table} WHERE @{col} IS NOT NULL) AS @{col}";
		String mainRow = "SELECT '@{col}' AS COLUMN_NAME FROM column_counts WHERE A = @{col} UNION ALL";
		List<String> replacedSentences = new ArrayList<>();
		List<String> replacedMainSentences = new ArrayList<>();
		
		try {
			for(int i = 0; i < targetColumns.size(); i ++) {
				String column = targetColumns.get(i);
				String temp = withRow.replace("@{col}", column);
				replacedSentences.add(temp);
				
				temp = mainRow.replace("@{col}", column);
				if(i == targetColumns.size() - 1) {
					temp = temp.replace("UNION ALL", "");
				}
				replacedMainSentences.add(temp);
			}
				
			String toInsert = String.join(",\r\n        ", replacedSentences);
			String insertToMain = String.join(" \r\n", replacedMainSentences);
			
			List<String> lines = Files.readAllLines(Paths.get(target));
			List<String> modifiedLines = lines.stream()
		            .map(line -> line.replace("@{target_columns}", toInsert)) // 원하는 텍스트로 대체
		            .map(line -> line.replace("@{table}", tableName))
		            .map(line -> line.replace("@{mainQuery}", insertToMain))
		            .collect(Collectors.toList());
			String modifiedTemplate = String.join("\n", modifiedLines);
			System.out.println(modifiedTemplate);
			Files.write(Paths.get(outputPath), modifiedTemplate.getBytes());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
