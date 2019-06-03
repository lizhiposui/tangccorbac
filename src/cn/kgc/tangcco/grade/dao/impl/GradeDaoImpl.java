package cn.kgc.tangcco.grade.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.kgc.tangcco.commons.datasource.JDBCUtils;
import cn.kgc.tangcco.grade.dao.GradeDao;

public class GradeDaoImpl implements GradeDao {

	@Override
	public int deleteGrade(int pk) {
		QueryRunner queryRunner = new QueryRunner();
		
		String sql = "delete from grade where gradeid=?";
		try {
			return queryRunner.update(JDBCUtils.getConnection(), sql, pk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
