package cn.kgc.tangcco.student.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.kgc.tangcco.commons.datasource.JDBCUtils;
import cn.kgc.tangcco.student.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int deleteStudentByGradeid(int gradeid) {
		QueryRunner queryRunner = new QueryRunner();

		String sql = "delete from student where gradeid=?";
		try {
			return queryRunner.update(JDBCUtils.getConnection(), sql, gradeid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
