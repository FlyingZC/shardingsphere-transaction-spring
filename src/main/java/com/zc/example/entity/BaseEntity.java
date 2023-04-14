package com.zc.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BaseEntity implements Serializable {
	
	protected static final long serialVersionUID = 1L;
	
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;
	
	/**
	 * 更新时间
	 */
	@TableField(value = "update_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateTime;
	
	/**
	 * 删除状态
	 */
	@TableField(value = "is_deleted")
	private Boolean deleted;
}
