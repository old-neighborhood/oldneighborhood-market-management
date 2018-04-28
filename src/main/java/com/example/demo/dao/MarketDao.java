  
    /**    
    * @Title: MarketDao.java  
    * @Package com.example.demo.dao  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月27日  
    * @version V1.0    
    */  
    
package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Market;


/**  
    * @ClassName: MarketDao  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月27日  
    *    
    */

public interface MarketDao extends JpaRepository<Market, String> {
	@Query(value="select m_ID, m_name, s_ID, m_image, m_address, "
			+ "m_type, m_tele, m_email, m_intro, m_state,m_view,m_score,m_date"
			+ " from market where s_ID=? order by m_date desc" , nativeQuery=true)
	List<Market> findByS_ID(String s_ID);

	@Transactional
	@Modifying
	@Query(value="update market as m set m.m_state='zhuxiao' where m.m_ID=?" ,
			nativeQuery=true)
	void update(String m_ID);
	
	@Transactional
	@Modifying
	@Query(value="update market as m set m.m_name=?,m_address=?,m_tele=?,m_email=?,m_intro=? where m.m_ID=?" ,
			nativeQuery=true)
	void update(String m_name, String m_address, String m_tele, String m_email, String m_intro, String m_ID);

	@Query(value="select m_ID "
			+ " from market order by m_date desc limit 1" , nativeQuery=true)
	String getM_ID();

	@Transactional
	@Modifying
	@Query(value="update market as m set m.m_state='zhengchang' where m.m_ID=?" ,
			nativeQuery=true)
	void recover(String m_ID);

}
