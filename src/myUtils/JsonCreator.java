package myUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
	private static String makeColumns(List<String> columns) {
		String column_temp = "";
		String column_content = "";
		
		Scanner sc = new Scanner(System.in);
		String newLine = System.lineSeparator();
		
		
		List<String> resultBody = new ArrayList<>();
		List<String> qKeys = Arrays.asList("messageKr", "messageEn", "searchYn", "listYn", "typeYn");
		List<String> orderList = new ArrayList<>(); // 아래 응답 중 listYn Y인 것들의 순서 관리용 리스트.
		List<String> questions = Arrays.asList(
				"칼럼명 한국어", "칼럼명 영어"
				, "검색조건에 포함할 것인가요? (Y/N, 미입력시 N)"
				, "리스트에 출력할 것인가요? (Y/N, 미입력시 N)"
				, "타입을 적용하실건가요? (Y/N, 미입력시 N)"
			);
		
		Map<String, String> qaMap = new HashMap<>();
		qaMap.put("typeq1", "타입을 입력해주세요. (select, date, switch ..)");
		qaMap.put("typeq1-1", "다중 select를 사용하실건가요? (Y/N, 미입력시 N)");
		
		boolean usingEnum = false;
		
		for(int i = 0; i < columns.size(); i ++) {
			Map<String, String> answers = new HashMap<>();
			String colName = columns.get(i);
			String qKey = "";
			String listYn = null;
			String searchYn = null;
			
			for(int j = 0; j < questions.size(); j ++) {
				String question = questions.get(j);
				
				System.out.println(newLine + "---------------------------------------" + newLine);
				System.out.println( colName + " " + question + " : ");
				System.out.println(newLine + "---------------------------------------" + newLine);
				
				String answer = sc.nextLine();
				qKey = qKeys.get(j);
				
				if(qKey.contains("Yn")) {
					String upperAnswer = answer.length() == 0 ? "N" : answer.toUpperCase();
					if("Y".equals(upperAnswer) || "N".equals(upperAnswer)) {
						answers.put(qKey, upperAnswer);
					} else {
						j --;
					}
				} else {
					answers.put(qKey, answer);
				} 
				
				listYn = answers.get("listYn");
				searchYn = answers.get("searchYn");
				
				if("Y".equals(listYn)) {
					orderList.add(colName);
					String formIdx = String.valueOf(orderList.indexOf(colName) + 1);
					answers.put("formIdx", formIdx);
				}
			}
			
			boolean usingType = false;
			String typeName = "";
			String multiSelect = "N";
			
			String answer = "";
			List<String> typesCan = Arrays.asList("select", "date", "switch", "textarea");
			if("Y".equals(answers.get("typeYn"))) {
				usingType = true;
				do {
					System.out.println(newLine + "---------------------------------------" + newLine);
					System.out.println( colName + " " + qaMap.get("typeq1") + " : ");
					System.out.println(newLine + "---------------------------------------" + newLine);
					answer = sc.nextLine().toLowerCase();
				} while( !typesCan.contains(answer));
				
				typeName = answer;
				
				if("select".equals(typeName)) {
					do {
						System.out.println(newLine + "---------------------------------------" + newLine);
						System.out.println( colName + " " + qaMap.get("typeq1-1") + " : ");
						System.out.println(newLine + "---------------------------------------" + newLine);
						answer = sc.nextLine().toUpperCase();
						if(answer.length() == 0) {
							answer = "N";
						}
						multiSelect = answer;
					} while( !"Y".equals(answer) && !"N".equals(answer));
					
					qaMap.put("enumq1", "ENUM을 적용하실 건가요? (Y/N DEFAULT N)");
					qaMap.put("enumq2", "사용할 ENUM을 한국어로 입력해주세요. [ex] 등록, 삭제");
					qaMap.put("enumq3", "사용할 ENUM을 영어로 입력해주세요. [ex] REGISTER, DELETE");
					String[] checkEnumAnswer = null;
					
					do {
						System.out.println(newLine + "---------------------------------------" + newLine);
						System.out.println( colName + " " + qaMap.get("enumq1") + " : ");
						System.out.println(newLine + "---------------------------------------" + newLine);
						answer = sc.nextLine().toUpperCase();
						if("Y".equals(answer)) {
							usingEnum = true;
						} else if(answer.length() == 0) {
							answer = "N";
						}
					}while(!"Y".equals(answer) && !"N".equals(answer));
					
					if(usingEnum) {
						do {
							System.out.println(newLine + "---------------------------------------" + newLine);
							System.out.println( colName + " " + qaMap.get("enumq2") + " : ");
							System.out.println(newLine + "---------------------------------------" + newLine);
							answer = sc.nextLine();
							checkEnumAnswer = answer.split(", ");
						}while(checkEnumAnswer.length == 0);
						
						qaMap.put("enumAKor", answer);
						checkEnumAnswer = null;
						
						do {
							System.out.println(newLine + "---------------------------------------" + newLine);
							System.out.println( colName + " " + qaMap.get("enumq3") + " : ");
							System.out.println(newLine + "---------------------------------------" + newLine);
							answer = sc.nextLine().toUpperCase();
							checkEnumAnswer = answer.split(", ");
						}while(checkEnumAnswer.length == 0);
						
						qaMap.put("enumAEng", answer);
					}
				}
			}
			
			column_temp = "{\r\n"
					+ "				\""+ colName +"\":\r\n"
					+ "				{\r\n"
					+ "@{column_content}"
					+ "				}\r\n"
					+ "			}";
			
			column_content = "					\"columnType\": \"String\",\r\n"
					+"					\"columnSize\": \"50\",\r\n"
					+"					\"header\": \""+listYn+"\",\r\n"
					+"					\"form\": \""+listYn+"\",\r\n"
					+"					\"condition\": \""+searchYn+"\",\r\n"
					+"					\"validation\": \"required\",\r\n"
					+"					\"updateFormItem\": \"Y\",\r\n"
					+"					\"updateMode\": \"invisible\",\r\n"
					+"					\"messageKr\": \""+answers.get("messageKr")+"\",\r\n"
					+"					\"messageEn\": \""+answers.get("messageEn")+"\",\r\n";
			
			if("Y".equals(listYn)) {
				String formIdx = answers.get("formIdx");
				column_content += "					\"formOrder\": "+ formIdx + "\r\n";
			}
			
			if(usingType) {
				column_content += ""
						+"					\"type\": \"" + typeName + "\",\r\n"
						+"					\"selectMultiple\": \"" + multiSelect + "\",\r\n";
			}
			
			if(usingEnum) {
				column_content += ""
						+"					\"enumType\": \"Y\",\r\n"
						+"					\"enum\": \""+qaMap.get("enumAEng")+"\",\r\n"
						+"					\"enumKr\": \""+qaMap.get("enumAKor")+"\",\r\n"
						+"					\"enumEn\": \""+qaMap.get("enumAEng")+"\",\r\n";
			}
			
			column_temp = column_temp.replace("@{column_content}", column_content);
			resultBody.add(column_temp);
		}
		
		return String.join(", ", resultBody);
	}
}
