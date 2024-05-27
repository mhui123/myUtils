package myUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import myUtils.setterClass.ApiVo;

public class setterGen {
	
	public static void main(String[] args) throws IOException {
		generateTemplate();
	}
	
	
	/*
	 * setTarget : setter 대상
	 * resource : getter로 데이터를 불러올 객체
	 * vars : setter를 작성할 변수목록
	 * 
	 * 결과 : 콘솔창에 출력된 setter 목록을 확인 
	 * 
	 * */
	private static void generateTemplate() throws IOException {
		String setTarget = "userdetail";
		String resource = "vo";
		List<String> vars = makeListParams();
		
		try {
			for(int i = 0; i < vars.size(); i ++) {
				String fieldName = vars.get(i);
				String setterName = ".set" + fieldName.substring(0,1).toUpperCase()  + fieldName.substring(1);
				String getterName = resource + ".get" + fieldName.substring(0,1).toUpperCase()  + fieldName.substring(1) + "()";
				String sentence = setTarget + setterName + "(" + getterName + "); \r\n";
				System.out.print(sentence);
				
				if(i % 10 == 0 && i > 0) {
					System.out.println();
				}
			}
		}
		catch(Exception e) {
			System.out.println();
		}
	}
	
	private static List<String> makeListParams() {
		List<String> listParams = new ArrayList<>();
		ApiVo vo = new ApiVo();
		Class<? extends ApiVo> objClass = vo.getClass();
		for(Field field : objClass.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			listParams.add(fieldName);
		}
		
//		String listParam = "";
//		for(int i = 0; i < listParams.size(); i++) {
//			String fieldName = listParams.get(i);
//			if(i == listParams.size() -1) {
//				listParam += "\"" + fieldName + "\"";
//			} else {
//				listParam += "\"" + fieldName + "\",";
//			}
//		}
		return listParams;
	}
}