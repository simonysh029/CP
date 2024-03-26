package com.example.demo.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class StayVO {
	private int s_no;
	private Date s_start;
	private Date s_end;
	private int s_person;
	private String m_id;
	private String g_id;
}
