/**
 * 
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;

/**
 * 
 * @author wentao
 */
public class ActionServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri=req.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(action);
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		
		if("/quoto".equals(action)) {
			//模拟生成几个股票的信息，以json形式返回信息
			List<Stock> stocks=new ArrayList<Stock>();
			Random r=new Random();
			for(int i=0;i<3;i++) {
				Stock s=new Stock();
				s.setCode("600877"+r.nextInt(10));
				s.setName("中国"+r.nextInt(10));
				s.setPrice(r.nextInt(1000));	
				stocks.add(s);
			}
			//转换json
			ObjectMapper pm=new ObjectMapper();
			String jsonstr;
			try {
				jsonstr = pm.writeValueAsString(stocks);
				System.out.println(jsonstr);
				out.println(jsonstr);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

}
