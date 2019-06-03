package cn.kgc.tangcco.grade.service.impl;

import java.sql.SQLException;

import cn.kgc.tangcco.commons.datasource.JDBCUtils;
import cn.kgc.tangcco.commons.properties.factory.PropertiesFactory;
import cn.kgc.tangcco.commons.utils.ContextUtils;
import cn.kgc.tangcco.grade.dao.GradeDao;
import cn.kgc.tangcco.grade.service.GradeService;
import cn.kgc.tangcco.student.dao.StudentDao;

public class GradeServiceImpl implements GradeService {

	private GradeDao gdao;
	private StudentDao sdao;
	public GradeServiceImpl() {
		gdao = PropertiesFactory.getInstance(ContextUtils.GRADE.getDao());
		sdao = PropertiesFactory.getInstance(ContextUtils.STUDENT.getDao());
	}
	
	@Override
	public int deleteGrade(int pk) {
		try {
			JDBCUtils.starTransaction();
			gdao.deleteGrade(pk);
			int i = 1/0;
			sdao.deleteStudentByGradeid(pk);
			JDBCUtils.commit();
		} catch (SQLException e) {
			try {
				JDBCUtils.rollBack();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return 0;
	}

}
