  
    /**    
    * @Title: Saler.java  
    * @Package com.example.demo.entity  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月26日  
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
    * @ClassName: Saler  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月26日  
    *    
    */

@Entity
@Table(name = "saler")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Saler implements Serializable {

	  
	
		  
	      
	    /**  
	    * @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	    */  
	    
	private static final long serialVersionUID = -8347776094897283590L;
	
	    

	/**  
	 * 创建一个新的实例 Saler.  
	 *  
	 * @param s_ID
	 * @param s_name
	 * @param s_password
	 * @param s_image
	 * @param s_tele
	 * @param s_email
	 * @param s_address
	 * @param s_signature
	 * @param s_score
	 * @param s_date  
	 */  

	@Id
	@NonNull
	private String s_ID;
	@NonNull
	private String s_name;
	@NonNull
	private String s_password;
	@NonNull
	private String s_image;
	  
	    
	
	@NonNull
	private String s_tele;
	private String s_email;
	@NonNull
	private String s_address;
	@NonNull
	private String s_signature;
	@NonNull
	private Integer s_score;
	@Column(columnDefinition = "timestamp not null default now()", updatable = false)
	private Timestamp s_date;
}