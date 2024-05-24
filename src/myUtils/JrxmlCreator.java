package myUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class JrxmlCreator {
	private String parameterTag = "<parameter name=\"@{paramName}\" class=\"@{paramType}\"/>";
	private String fieldTag = "<field name=\"@{fieldName}\" class=\"@{fieldType}\"/>";
	private String stringType = "java.lang.String";
	private String longType = "java.lang.Long";
	
	public static void main(String[] args) throws IOException {
		generateTemplate();
	}
	
	private static String generateTemplate() throws IOException {
		String fileName = "/jrxml_template.jrxml";
		String path = "src/resources/jrxmlTemplate";
		String outputPath = "src/resources/output/output.jrxml";

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		String target = absolutePath + fileName;
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(target));
			List<String> modifiedLines = lines.stream()
		            .map(line -> line.replace("@{reportName}", "newText")) // 원하는 텍스트로 대체
		            .collect(Collectors.toList());
			String modifiedTemplate = String.join("\n", modifiedLines);
			System.out.println(modifiedTemplate);
			Files.write(Paths.get(outputPath), modifiedTemplate.getBytes());
		}
		catch(Exception e) {
			System.out.println();
		}
		return null;
	}
	
	
	
	/*
	 public static void main(String[] args) {
        String jsonFileName = "example.json";
        
        // JSON 객체 생성
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "John");
        jsonObject.put("age", 30);
        jsonObject.put("city", "New York");
        
        // JSON 배열 생성
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        
        try (FileWriter writer = new FileWriter(jsonFileName)) {
            // JSON 파일에 데이터 쓰기
            writer.write(jsonArray.toString());
            System.out.println("JSON 파일이 생성되었습니다.");
        } catch (IOException e) {
            System.out.println("JSON 파일 생성 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
	 * */
}
