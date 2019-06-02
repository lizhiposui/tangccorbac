package cn.kgc.tangcco.user.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;
@Data
public class Tbuser {

	private Integer userid;
	private String username,password,userroles,nickname,email,tel;
	private Date regtime;
	private Timestamp birthday;
}
