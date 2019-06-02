package cn.kgc.tangcco.commons.base.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.kgc.tangcco.commons.datasource.JDBCUtils;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class BaseDao {

	private QueryRunner queryRunner;
	public BaseDao() {
		this.queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	}
	
	//查询多条记录
	public <T>List<T> selectAll(String sql,Class<T> clazz,Object...params){
		try {
			return this.queryRunner.query(sql, new BeanListHandler<>(clazz), params);
		} catch (SQLException e) {
			log.error("对不起，查询多条记录方法出错");
		}
		return null;
	}
	//根据一条记录
	public <T>T selectOne(String sql,Class<T> clazz,Object...params){
		try {
			return this.queryRunner.query(sql, new BeanHandler<>(clazz), params);
		} catch (SQLException e) {
			log.error("对不起，查询一条记录方法出错");
		}
		return null;
	}
	//count求和
	public Long selectCount(String sql,Object...params) {
		try {
			return this.queryRunner.query(sql, new ScalarHandler<>(), params);
		} catch (SQLException e) {
			log.error("对不起，count方法出错");
		}
		return 0l;
	}
	
	//新增修改删除
	public int executeUpdate(String sql,Object... params) {
		try {
			return this.queryRunner.update(sql, params);
		} catch (SQLException e) {
			log.error("对不起，新增修改删除方法出错");
		}
		return 0;
	}
	//新增后获得PK
	public Long insert(String sql,Object... params) {
		try {
			return this.queryRunner.insert(sql, new ScalarHandler<>(), params);
		} catch (SQLException e) {
			log.error("对不起，新增修改删除方法出错");
		}
		return 0l;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
