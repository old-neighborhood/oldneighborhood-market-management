  
    /**    
    * @Title: MarketServiceImpl.java  
    * @Package com.example.demo.service.Impl  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月27日  
    * @version V1.0    
    */  
    
package com.example.demo.service.Impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.MarketDao;
import com.example.demo.entity.Market;
import com.example.demo.service.MarketService;

/**  
    * @ClassName: MarketServiceImpl  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月27日  
    *    
    */
@Service("MarketService")
public class MarketServiceImpl implements MarketService {
	@Resource
	private MarketDao marketDao;
	/* (非 Javadoc)  
	*   
	*   
	* @param s_ID
	* @return  
	* @see com.example.demo.service.MarketService#getMarkets(java.lang.String)  
	*/

	@Override
	public List<Market> getMarkets(String s_ID) {
		return marketDao.findByS_ID(s_ID);
	}

	/* (非 Javadoc)  
	*   
	*   
	* @param market  
	* @see com.example.demo.service.MarketService#AddMarket(com.example.demo.entity.Market)  
	*/

	@Override
	public void AddMarket(Market market) {
		marketDao.save(market);

	}

	/* (非 Javadoc)  
	*   
	*   
	* @param m_ID  
	* @see com.example.demo.service.MarketService#deleteMarket(java.lang.String)  
	*/

	@Override
	public void deleteMarket(String m_name) {
		marketDao.update(m_name);

	}

	@Override
	public void modifyMarket(String m_name, String m_address, String m_tele, String m_email, String m_intro,
			String m_ID) {
		marketDao.update(m_name,m_address,m_tele,m_email,m_intro,m_ID);
		
	}

	@Override
	public String getM_ID() {
		return marketDao.getM_ID();
	}

	@Override
	public Market getMarket(String m_ID) {
		return marketDao.findOne(m_ID);
	}

	

	

}
