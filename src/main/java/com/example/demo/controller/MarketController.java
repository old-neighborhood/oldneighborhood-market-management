  
    /**    
    * @Title: MarketController.java  
    * @Package com.example.demo.controller  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月27日  
    * @version V1.0    
    */  
    
package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.Market;
import com.example.demo.service.MarketService;

import sun.misc.BASE64Decoder;

/**  
    * @ClassName: MarketController  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月27日  
    *    
    */
@SuppressWarnings("restriction")
@Controller
public class MarketController {
	@Resource
	private MarketService marketService;
	@RequestMapping("/")
	@ResponseBody
	public String test1() {
		return "/MarketList";
	}
	
	
	
	@RequestMapping("/getMarket")
	@ResponseBody
	public Market getMarket(@RequestBody String m_ID) {
		
		return marketService.getMarket(m_ID);
	}
	
	@RequestMapping("/getMarkets")
	@ResponseBody
	public List<Market> getMarketList(@RequestBody String s_ID){
		List<Market> markets = marketService.getMarkets(s_ID);
		return markets;
	}
	
	@RequestMapping("/modifyMarket")
	@ResponseBody
	public String modifyMarket(@RequestBody Map<String,Object> reqMap) {
		System.out.println(reqMap.get("m_name").toString()+" "+
				reqMap.get("m_address").toString()+" "+
				reqMap.get("m_tele").toString()+" "+
				reqMap.get("m_email").toString()+" "+
				reqMap.get("m_intro").toString()+" "+
				reqMap.get("m_ID").toString()
				);
		marketService.modifyMarket(
				reqMap.get("m_name").toString(),
				reqMap.get("m_address").toString(),
				reqMap.get("m_tele").toString(),
				reqMap.get("m_email").toString(),
				reqMap.get("m_intro").toString(),
				reqMap.get("m_ID").toString()
				);
		
		if(reqMap.get("m_image")!=null&&reqMap.get("m_image").toString().length()>1000) {
			String imgStr = reqMap.get("m_image").toString();
			System.out.println("base64:"+imgStr);
			String path = "C:\\pc\\workspace\\oldneighborhood-frontUI\\src\\main\\resources\\img\\market\\"+reqMap.get("m_ID").toString()+".jpg";
			imgStr = imgStr.replaceAll("data:image/jpeg;base64,", ""); 
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				byte[] b = decoder.decodeBuffer(imgStr);
				for (int i = 0; i < b.length; ++i) {
					if (b[i] < 0) {
						b[i] += 256;
					}
				}
				System.out.println(path);
				 File imageFile = new File(path);
		            imageFile.createNewFile();
		               if(!imageFile.exists()){
		                   imageFile.createNewFile();
		                }
		                OutputStream imageStream = new FileOutputStream(imageFile);
		                imageStream.write(b);
		                imageStream.flush();
		                imageStream.close();           
				} catch (Exception e) {
				}
			}
		
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping("/addMarket")
	@ResponseBody
	public String addMarket(@RequestBody Map<String,Object> reqMap) {
		//System.out.println(key);
		String ID = UUID.randomUUID().toString().replaceAll("-", "");
		
		System.out.println(reqMap.get("m_image").toString());
		
		String imgStr = reqMap.get("m_image").toString();
		System.out.println("base64:"+imgStr);
		String path = "C:\\pc\\workspace\\oldneighborhood-frontUI\\src\\main\\resources\\img\\market\\"+ID+".jpg";
		imgStr = imgStr.replaceAll("data:image/jpeg;base64,", ""); 
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			System.out.println(path);
			 File imageFile = new File(path);
	            imageFile.createNewFile();
	               if(!imageFile.exists()){
	                   imageFile.createNewFile();
	                }
	                OutputStream imageStream = new FileOutputStream(imageFile);
	                imageStream.write(b);
	                imageStream.flush();
	                imageStream.close();           
			} catch (Exception e) {
			}
		
		Market market = new Market(
				ID,
				reqMap.get("m_name").toString(),
				reqMap.get("s_ID").toString(),
				"/market/"+ID+".jpg",
				reqMap.get("m_address").toString(),
				reqMap.get("m_type").toString(),
				reqMap.get("m_tele").toString(),
				reqMap.get("m_email").toString(),
				reqMap.get("m_intro").toString(),
				"shenqing",
				0
				);
		market.setM_score(300);
		marketService.AddMarket(market);
		return "{\"result\":\"success\"}";
	}
	@RequestMapping("/deleteMarket")
	@ResponseBody
	public String deleteMarket(@RequestBody String m_ID) {
		System.out.println(m_ID);
		marketService.deleteMarket(m_ID);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping("/recoverMarket")
	@ResponseBody
	public String recoverMarket(@RequestBody String m_ID) {
		System.out.println(m_ID);
		marketService.recoverMarket(m_ID);
		return "{\"result\":\"success\"}";
	}
}
