package com.example.demo.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ReserveVO {
	private int r_no;
	private Date r_date;
	private Date r_start;
	private Date r_end;
	private int r_person;
	private String m_id;
	private String g_id;
}
