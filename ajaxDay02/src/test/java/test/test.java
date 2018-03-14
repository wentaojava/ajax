/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.youkuEntity;

/**
 * 调用优酷api
 * @author wentao
 */
public class test {
	
	public String test1() {
		String result = "";  
        BufferedReader in = null;  
        try {  
            URL realUrl = new URL("https://api.youku.com/videos/show.json?client_id=ce0b6377521c452c"
            		+ "&video_id=XMTMxODE1MzU5Ng==");  
            // 打开和URL之间的连接    
            URLConnection connection = realUrl.openConnection();  
            // 设置通用的请求属性    
            connection.setRequestProperty("accept", "*/*");  
            connection.setRequestProperty("connection", "Keep-Alive");  
            connection.setRequestProperty("user-agent",  
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
            // 建立实际的连接    
            connection.connect();  
            // 定义 BufferedReader输入流来读取URL的响应    
            in = new BufferedReader(new InputStreamReader(connection  
                    .getInputStream(), "utf-8"));  
            String line;  
            while ((line = in.readLine()) != null) {  
                result += line;  
            } 
           //System.out.println(result);
        } catch (Exception e) {  
            System.out.println("发送GET请求出现异常！" + e);  
            e.printStackTrace();  
        }  
        // 使用finally块来关闭输入流    
        finally {  
            try {  
                if (in != null) {  
                    in.close();  
                }  
            } catch (Exception e2) {  
                e2.printStackTrace();  
            }  
        }
		return result;  
       
}

	@Test
	public void test2() {
		// 正则表达式去除视频id  
		String path = "http://v.youku.com/v_show/id_XMTMxODE1MzU5Ng==.html"; 
		String p=path.replace("http://v.youku.com/v_show/id_", "").replace(".html", "");
		
		//Pattern p = Pattern.compile("#v_show/id_(.*?)\\.html#i");  
		//Matcher m = p.matcher(path);  
		//String id = "";  
		//if (m.find()) {  
		//    id = m.group(1);  
		//}
		System.out.println(p);
		String s=test1();
		JSONObject  a= (JSONObject) JSONObject.parse(s);
		System.out.println(a);
		
		
		
	}

}

