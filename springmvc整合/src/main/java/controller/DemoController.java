/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author wentao
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@RequestMapping("/ary.do")
	@ResponseBody
	//自动将返回结果的JavaBean转换成JSONS字符串发送到浏览器客户端
	public Object test() {
		System.out.println("ary.do");
		String[] ary= {"李红和","熊二","熊大"};
		return ary;
	}
	
	@RequestMapping("/bean.do")
	@ResponseBody
	public Object bean() {
		return new Foo(8,"we",2.34);
	}
	
	@ResponseBody
	@RequestMapping("/beans.do")
	public Object beans() {
		List<Foo> l=new ArrayList<Foo>();
		l.add(new Foo(8,"we",2.34));
		l.add(new Foo(8,"we1",2.34));
		l.add(new Foo(8,"we2",2.34));
		l.add(new Foo(8,"we3",2.34));
		return l;
	}
	
	@RequestMapping("/beansMap.do")
	@ResponseBody
	public Object beansMap() {
		Map<String,Foo> m=new HashMap<>();
		m.put("map1", new Foo(8,"we",2.34));
		m.put("map2", new Foo(8,"we2",44.3));
		m.put("map3", new Foo(8,"we3",33.4));
		return m;
	}

}
