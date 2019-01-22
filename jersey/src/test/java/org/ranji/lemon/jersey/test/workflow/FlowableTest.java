package org.ranji.lemon.jersey.test.workflow;

import java.sql.SQLException;

import org.flowable.engine.ProcessEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ranji.lemon.core.CoreApplication;
import org.ranji.lemon.jersey.service.flowable.prototype.IFlowableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=CoreApplication.class)  //-- 指定Spring-Boot的启动类
@WebAppConfiguration
public class FlowableTest {
	@Autowired
	private IFlowableService flowableService;
	
	@Test
	public void testFlowableEngine(){
		ProcessEngine pe = flowableService.getProcessEngineInstance();
		try {
			System.out.println(pe.getProcessEngineConfiguration().getDataSource().getConnection().getMetaData().getURL());
			System.out.println(pe.getProcessEngineConfiguration().getDataSource().getConnection().getMetaData().getUserName());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println(pe.getProcessEngineConfiguration().getDatabaseType());
		try {
			System.out.println(pe.getProcessEngineConfiguration().getDataSource().getConnection().getSchema());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(pe.getProcessEngineConfiguration().getDatabaseType());
		
		ProcessEngine pe2 = flowableService.getProcessEngineInstance();
		System.out.println(pe==pe2);
		
		
		pe.getRepositoryService().createDeployment().addClasspathResource("processes/holiday-request.bpmn20.xml").deploy();
	}
}
