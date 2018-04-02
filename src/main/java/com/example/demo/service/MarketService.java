  
    /**    
    * @Title: MarketService.java  
    * @Package com.example.demo.service  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月27日  
    * @version V1.0    
    */  
    
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Market;

/**  
    * @ClassName: MarketService  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月27日  
    *    
    */

public interface MarketService {
	public List<Market> getMarkets(String s_ID);
	public void AddMarket(Market market);
	public void modifyMarket(
			String m_name,
			String m_address,
			String m_tele,
			String m_email,
			String m_intro,
			String m_ID
			);
	public void deleteMarket(String m_name);
	public String getM_ID();
	public Market getMarket(String m_ID);
}
