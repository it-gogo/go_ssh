package com.sb.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.core.util.Base64Encoder;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Util {
	public static String Encryption(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] buf = md.digest(str.getBytes());
		return new Base64Encoder().encode(buf);
	}


	/**
	 * src文件拷贝到dest文件
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public static boolean copy(File src, File dest) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			byte[] bts = new byte[1024];
			int len = -1;
			while ((len = bis.read(bts)) != -1) {
				bos.write(bts, 0, len);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 删除文件
	 * 
	 * @return
	 */
	public static boolean deleteUpload(String imgurl) {
		if (!(imgurl == null || imgurl.length() == 0)) {// 用于删除旧的文件
			imgurl = ServletActionContext.getServletContext().getRealPath(
					imgurl.substring(2, imgurl.length()));
			File ifile = new File(imgurl);
			if (ifile.exists()) {
				ifile.delete();
				return true;
			}
		}
		return false;
	}

	/**
	 * 合并数组
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static <T> T[] concat(T[] first, T[] second) {
		if (first == null || second == null) {
			return null;
		}
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	/**
	 * 扩容
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public static <T> T[] expansion(T[] arr, T value) {
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[arr.length - 1] = value;
		return arr;
	}

	/**
	 * 获得昨日日期
	 * 
	 * @return
	 */
	public static String getYesterday() {
		Date date = new Date();
		date.setTime(date.getTime() - 24 * 60 * 60 * 1000);
		String dateStr = ExtendDate.getYMD(date);
		return dateStr;
	}

	/**
	 * 获取权限url集合
	 * 
	 * @param menuidList
	 * @return
	 * @throws Exception
	 */
	public static Map getPrivilegesUrl(List menuidList) throws Exception {
		List list = new ArrayList();
		List all = new ArrayList();
		menuidList = new ArrayList(menuidList);
		SAXReader reader = new SAXReader();
		try {
			InputStream fis = Util.class.getClassLoader().getResourceAsStream(
					"privilege.xml");
			Document doc = reader.read(fis);
			List<Element> elements = doc.getRootElement().elements();
			for (Element element : elements) {
				String url = element.element("url").getStringValue();
				all.add(url);
				Integer id = Integer.parseInt(element.attributeValue("id"));
				Iterator it = menuidList.iterator();
				while (it.hasNext()) {
					Integer i = (Integer) it.next();
					// System.out.println(id.equals(i));
					if (id.equals(i)) {

						list.add(url);
						it.remove();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("读取权限报错", e);
		}
		Map m = new HashMap();
		m.put("list", list);
		m.put("all", all);
		return m;
	}

	public static Map operateSns(String sns) {
		String[] arr = sns.split(",");
		Object[] parame = new Object[arr.length];
		StringBuffer hql = new StringBuffer(" in ( ");
		for (int j = 0; j < arr.length; j++) {
			String id = arr[j];
			id = id.trim();
			Integer i = Integer.valueOf(id);
			// Object i =id;
			parame[j] = i;
			if (j != arr.length - 1) {
				hql.append(" ?, ");
			} else {
				hql.append("? )");
			}
		}
		Map map = new HashMap();
		map.put("parame", parame);
		map.put("hql", hql.toString());
		return map;
	}

	public static Map<String,Object> operateStr(String sns) {
		String[] arr = sns.split(",");
		Object[] parame = new Object[arr.length];
		StringBuffer hql = new StringBuffer(" in ( ");
		for (int j = 0; j < arr.length; j++) {
			String id = arr[j];
			id = id.trim();
			// Integer i = Integer.valueOf(id);
			Object i = id;
			parame[j] = i;
			if (j != arr.length - 1) {
				hql.append(" ?, ");
			} else {
				hql.append("? )");
			}
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parame", parame);
		map.put("hql", hql.toString());
		return map;
	}


	/**
	 * 深度拷贝list
	 * @param src
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static List copyBySerialize(List src) throws IOException,ClassNotFoundException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(src);

		ByteArrayInputStream byteIn = new ByteArrayInputStream(
				byteOut.toByteArray());
		ObjectInputStream in = new ObjectInputStream(byteIn);
		List dest = (List) in.readObject();
		return dest;
	}
	
	public static String operationTips(String status,String msg,String href){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("status", status);
		map.put("msg", msg);
		map.put("href", href);
		ContextUtil.setHttpRequestVal("operation", map);
		return "operationTips";
	}

	public static void main(String[] args) throws Exception {
//		String html="<html xmlns=\"http://www.w3.org/1999/xhtml\" ><head><link rel=\"stylesheet\" type=\"text/css\" href=\"../css/masterstyle.css?t=201406091112\" /><title></title></head><body><form name=\"form1\" method=\"post\" action=\"service.aspx\" id=\"form1\"><div><input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"/wEPDwUKLTU0NTAzMzgxMQ8WAh4IQ2FsbFBhZ2UFCkxvZ2luLmFzcHgWAgIDD2QWAgIBDw8WAh4EVGV4dAUM6aqM6K+B5oiQ5YqfZGRkUYwFm3cZhzupt0ZtBfTKlkAQYuk=\" /></div><span id=\"rsltMsg\">验证成功</span></form></body></html>";
//		org.jsoup.nodes.Document doc=Jsoup.parse(html);
//		System.out.println(doc.select("#rsltMsg").html());
		
//		File f=new File("E:\\陈海彬\\省市区\\area.txt");
//        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream( "E:\\陈海彬\\省市区\\area.txt"), "gbk"));
//        String str,s="";
//        while ((str = in.readLine()) != null){
//             s+=str;
//        }
//        in.close();
//        System.out.println(s);
//        System.out.println(JSONUtil.strToJSONObj("{0:{'1':'北京市','22':'天津市'}}"));
//        System.out.println(JSONUtil.strToJSONObj(s));
		
		System.out.println(Encryption("aaa111222"));
        
	}

	public static ByteArrayOutputStream  baleZip(File[] files,String zipname) throws Exception{
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(bout);
		ZipEntry ze=null;
		for(int i=0;i<files.length;i++){
			File f=files[i];
			if(f==null){
				continue;
			}
			FileInputStream fis = new FileInputStream(f);
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte[] buf = new byte[1024];
			int len;
			ze = new  ZipEntry(f.getName());//这是压缩包名里的文件名
//			ze = new  ZipEntry(URLEncoder.encode(f.getName(),"utf-8"));//这是压缩包名里的文件名
//			String name=f.getName();
//			ze = new  ZipEntry(new String(name.getBytes("iso-8859-1"),"utf-8"));//这是压缩包名里的文件名
			zos.putNextEntry(ze);//写入新的ZIP文件条目并将流定位到条目数据的开始处
			while((len=bis.read(buf))!=-1){
				zos.write(buf,0,len);
				zos.flush(); 
			}
			fis.close();
		}
		zos.setEncoding("gbk");
		zos.close();
		return bout;
	}
	
	/**
	 * 
	 * @param fltName模板名称
	 * @param root 数据
	 * @return
	 * @throws Exception
	 */
	public static String getFLT(String fltName,Map<String, Object> root) throws Exception{
		Configuration cfg = new Configuration();
		String  path = ServletActionContext.getServletContext().getRealPath("temp\\");
		cfg.setDirectoryForTemplateLoading(new File(path+"\\"));
		Template temp = cfg.getTemplate(fltName,"UTF-8");
		
		ByteArrayOutputStream bao = new ByteArrayOutputStream();  
		Writer out = new PrintWriter(bao);
		temp.process(root, out);
		byte[]  book = bao.toByteArray();
		String str = new String(book);
		return str;
	}
	
}
