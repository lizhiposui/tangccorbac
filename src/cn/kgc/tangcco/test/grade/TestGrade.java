package cn.kgc.tangcco.test.grade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cn.kgc.tangcco.commons.properties.factory.PropertiesFactory;
import cn.kgc.tangcco.commons.utils.ContextUtils;
import cn.kgc.tangcco.grade.service.GradeService;

public class TestGrade {

	private GradeService service;
	@Before
	public void init() {
		service = PropertiesFactory.getInstance(ContextUtils.GRADE.getService());
	}
	@Test
	public void testDelete() {
		service.deleteGrade(9);
	}
}
