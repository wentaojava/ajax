import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @time: 2018年03月12日
 * @author: wentao
 * @copyright: Wuxi Yazuo ,Ltd.copyright 2015-2025
 */
public class test {
    @Test
    public void test1(){
        Map<String,String> s=new HashMap<>();
        s.put("1","23");
        System.out.println(s.get("1"));
    }

}
