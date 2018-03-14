/**
 * 
 */
package bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author wentao
 */
public class Test {
	/**将java对象转换成json字符串*/
	public static void test1() {
		Stock s=new Stock();
		s.setCode("600877");
		s.setName("中国");
		s.setPrice(4);
		//使用jackson提供的api转换
		ObjectMapper om=new ObjectMapper();
		String jsonstr;
		try {
			jsonstr = om.writeValueAsString(s);
			System.out.println(jsonstr);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	
	}
	
	/**将多个对象组成的集合转换成json字符串*/
	public static void test2() {
		List<Stock> stocks=new ArrayList<Stock>();
		for(int i=0;i<3;i++) {
			Stock s=new Stock();
			s.setCode("600877"+i);
			s.setName("中国"+i);
			s.setPrice(4+i);	
			stocks.add(s);
		}
		//转换json
		ObjectMapper pm=new ObjectMapper();
		String jsonstr;
		try {
			jsonstr = pm.writeValueAsString(stocks);
			System.out.println(jsonstr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		test1();
		test2();
	}
}
