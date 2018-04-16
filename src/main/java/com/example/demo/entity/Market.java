  
    /**    
    * @Title: Market.java  
    * @Package com.example.demo.entity  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月27日  
    * @version V1.0    
    */  
    
package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**  
    * @ClassName: Market  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月27日  
    *    
    */
@Entity
@Table(name="market")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Market implements Serializable {

	  
	      
	    /**  
	     * 创建一个新的实例 Market.  
	     *  
	     * @param m_ID
	     * @param m_name
	     * @param s_ID
	     * @param m_image
	     * @param m_address
	     * @param m_type
	     * @param m_tele
	     * @param m_email
	     * @param m_intro
	     * @param m_state
	     * @param m_score
	     * @param m_date  
	     */  
	    
	
		/**  
	    * @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	    */  
	    
	private static final long serialVersionUID = -5550874273577685972L;
	@Id
	@NonNull
	private String m_ID;
	@NonNull
	private String m_name;
	@NonNull
	private String s_ID;
	@NonNull
	private String m_image;
	@NonNull
	private String m_address;
	@NonNull
	private String m_type;
	@NonNull
	private String m_tele;
	private String m_email;
	@NonNull
	private String m_intro;
	@NonNull
	private String m_state;
	@NonNull
	private Integer m_score;
	@Column(columnDefinition = "timestamp not null default now()", updatable = false)
	private Timestamp m_date;
	  
	    /**  
	     * 创建一个新的实例 Market.  
	     *  
	     * @param m_ID
	     * @param m_name
	     * @param s_ID
	     * @param m_image
	     * @param m_address
	     * @param m_type
	     * @param m_tele
	     * @param m_email
	     * @param m_intro
	     * @param m_state
	     * @param m_score  
	     */  
	    
	public Market(String m_ID, String m_name, String s_ID, String m_image, String m_address, String m_type,
			String m_tele, String m_email, String m_intro, String m_state, Integer m_score) {
		super();
		this.m_ID = m_ID;
		this.m_name = m_name;
		this.s_ID = s_ID;
		this.m_image = m_image;
		this.m_address = m_address;
		this.m_type = m_type;
		this.m_tele = m_tele;
		this.m_email = m_email;
		this.m_intro = m_intro;
		this.m_state = m_state;
		this.m_score = m_score;
	}
	
	
}
