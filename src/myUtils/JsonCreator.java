package myUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import myUtils.setterClass.JsonTemp;

public class JsonCreator {
	
	public static void main(String[] args) throws IOException {
		generateTemplate();
	}
	
	/*
	 사용법
	 1. tableNm에 생성할 테이블 이름을 입력한다.
	 2. JsonTemp에 생성할 테이블의 칼럼들을 각각 변수로 선언한다.
	 3. 실행 -> resource/output에 tableInfo.json 생성
	 * */
	private static String generateTemplate() throws IOException {
		String fileName = "/jsonTemp.json";
		String path = "src/resources/jsonTemp";
		String outputPath = "src/resources/output/tableInfo.json";

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		String target = absolutePath + fileName;
		
		String tableNm = "bds_im_user_test"; //생성할 테이블 이름
		String entityNmKor = "테스트"; // Entity의 한국어 이름
		String entityNmEng = "test"; // Entity의 영문 이름
		
		Class<?> targetClass = new JsonTemp().getClass();
		try {
			
		Map<String, List<String>> datas = getListData(targetClass);
		List<String> columns = datas.get("listParams");
		List<String> paramTypes = datas.get("paramTypes");
		
		String column_temp = makeColumns(columns);
		
		String toInsert = column_temp;
		List<String> lines = Files.readAllLines(Paths.get(target));
		List<String> modifiedLines = lines.stream()
	            .map(line -> line.replace("@{tableNm}", tableNm))
	            .map(line -> line.replace("\"@{columns}\"", toInsert)) // 원하는 텍스트로 대체
	            .map(line -> line.replace("@{entityNmKor}", entityNmKor)) // 원하는 텍스트로 대체
	            .map(line -> line.replace("@{entityNmEng}", entityNmEng)) // 원하는 텍스트로 대체
	            .collect(Collectors.toList());
		String modifiedTemplate = String.join("\n", modifiedLines);
		System.out.println(modifiedTemplate);
		Files.write(Paths.get(outputPath), modifiedTemplate.getBytes());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Map<String, List<String>> getListData(Class<?> targetClass) {
		Map<String, List<String>> resultMap = new HashMap<>();
		List<String> listParams = new ArrayList<>();
		List<String> paramTypes = new ArrayList<>();
		
		Class<?> objClass = targetClass;
		for(Field field : objClass.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			listParams.add(fieldName);
			
			String fieldType = field.getType().toString().replace("class java.lang.", "");
			paramTypes.add(fieldType);
		}
		resultMap.put("listParams", listParams);
		resultMap.put("paramTypes", paramTypes);
		
		return resultMap;
	}
	
	private static String makeColumns(List<String> columns) {
		boolean isEnum = false;
		boolean isSelectType = false;
		String column_temp = "";
		String column_content = "";
		
		
		/*
		 		condition	해당 컬럼이 condition 영역에 보일지말지 결정하기 옵션
				validation	해당 컬럼의 validation(rules)을 결정하기 위한 옵션
				updateFormItem	해당 컬럼의 updateFormItem을 결정하기 위한 옵션
				
				columnType	DB SCRIPT 생성시에 사용되는 db data type을 위한 옵션	"columnType": "String"	String (문자형),int (정수형)
				columnSize	DB SCRIPT 생성시에 사용되는 db data size를 위한 옵션	"columnSize": "30"	
				notNull	DB SCRIPT 생성시에 사용되는 NULL 여부를 위한 옵션	"notNull": "Y"	YN
				primaryKey	DB SCRIPT 생성시 기본키를 설정하기 위한 옵션	"primaryKey": "Y"	YN
				unique	DB SCRIPT 생성시 UNIQUE를 설정하기 위한 옵션	"unique": "Y"	YN
		 * */
		List<String> resultBody = new ArrayList<>();
		for(int i = 0; i < columns.size(); i ++) {
			String colName = columns.get(i);
			String formIdx = String.valueOf(i + 1);
			column_temp = "{\r\n"
					+ "				\""+ colName +"\":\r\n"
					+ "				{\r\n"
					+ "@{column_content}"
					+ "				}\r\n"
					+ "			}";
			
			column_content = "					\"columnType\": \"String\",\r\n"
					+"					\"columnSize\": \"50\",\r\n"
					+"					\"header\": \"Y\",\r\n"
					+"					\"form\": \"Y\",\r\n"
					+"					\"condition\": \"Y\",\r\n"
					+"					\"validation\": \"required\",\r\n"
					+"					\"updateFormItem\": \"Y\",\r\n"
					+"					\"updateMode\": \"invisible\",\r\n"
					+"					\"messageKr\": \"칼럼명한국어\",\r\n"
					+"					\"messageEn\": \"칼럼명영어\",\r\n"
					+"					\"formOrder\": "+ formIdx + "\r\n";
			
			if(isEnum) {
				column_content += ""
						+"					\"enumType\": \"Y\",\r\n"
						+"					\"enum\": \"REGISTER, DELETE\",\r\n"
						+"					\"enumKr\": \"등록, 삭제\",\r\n"
						+"					\"enumEn\": \"REGISTER, DELETE\",\r\n";
			}
			
			if(isSelectType) {
				column_content += ""
						+"					\"type\": \"select\",\r\n"
						+"					\"selectMultiple\": \"Y\",\r\n";
			}
			column_temp = column_temp.replace("@{column_content}", column_content);
			resultBody.add(column_temp);
		}
		
		return String.join(", ", resultBody);
	}
}
