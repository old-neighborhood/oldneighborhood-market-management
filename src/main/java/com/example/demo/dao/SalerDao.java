  
    /**    
    * @Title: SalerDao.java  
    * @Package com.example.demo.dao  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月26日  
    * @version V1.0    
    */  
    
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Saler;

/**  
    * @ClassName: SalerDao  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月26日  
    *    
    */

public interface SalerDao extends JpaRepository<Saler, String> {
	
	

}
