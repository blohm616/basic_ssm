package maven_ssm.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtil {

	private static XmlUtil instance = null;
	
	private XmlUtil() {}
	
	public static XmlUtil getInstance() {
		if(instance == null) {
			synchronized (StringUtil.class) {
				if(instance == null)
					instance = new XmlUtil();
			}
		}
		return instance;
	}
	
	public List<Map<String,String>> parse(String xmlUrl)  {
		SAXReader saxReader = null;
		try {
			saxReader = new SAXReader();
			Document doc = saxReader.read(new File(xmlUrl));
			Element root = doc.getRootElement();
			List<Map<String,String>> lists = new ArrayList<Map<String,String>>();
			recurParse(root,lists);
			return lists;
		}  catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static void recurParse(Element ele,List<Map<String,String>> lists) {
		List<Element> elements = ele.elements();
		if(elements != null && elements.size() > 0) {
			for(Element e : elements) {
				recurParse(e,lists);
			}
		} else {
			Map<String,String> map = new HashMap<String,String>();
			map.put(ele.getName(), ele.getTextTrim());
			lists.add(map);
		}
	}
}
