package myUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import myUtils.setterClass.ApiVo;

public class setterGen {
	
	public static void main(String[] args) throws IOException {
		generateTemplate();
	}
	
	
	/*
	 * setTarget : setter 대상
	 * 1. setter를 만들 객체를 myUtils/setterClass에 위치시킨다.
	 * 2. Class<?> targetClass 의 대상객체를 맞춰준다.
	 * 
	 * 결과 : 콘솔창에 출력된 setter 목록을 확인 
	 * 
	 * */
	private static void generateTemplate() throws IOException {
		String setTarget = "userdetail";
		String resource = "vo";
		Class<?> targetClass = new ApiVo().getClass(); //대상객체
		List<String> vars = makeListParams(targetClass);
		
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
	
	private static List<String> makeListParams(Class<?> targetClass) {
		List<String> listParams = new ArrayList<>();
		
		Class<?> objClass = targetClass;
		for(Field field : objClass.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			listParams.add(fieldName);
		}
		
		return listParams;
	}
}