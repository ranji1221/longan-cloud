package org.ranji.lemon.jersey.test.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

public class HolidayRequest {
	public static void main(String[] args) {
		
		//-- 第一大步：准备工作（部署流程、查询到流程定义即可）
		
		//-- 1. 依靠配置对象构造流程引擎
		ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
				.setJdbcUrl("jdbc:mysql://localhost:3306/longan?useUnicode=true&characterEncoding=UTF-8")
				.setJdbcUsername("root")
				.setJdbcPassword("123456")
				.setJdbcDriver("com.mysql.jdbc.Driver")
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

		ProcessEngine processEngine = cfg.buildProcessEngine();
		System.out.println(processEngine.getProcessEngineConfiguration().getJdbcDriver());
		//-- 2. 利用流程引擎对象获取仓库服务对象
		RepositoryService repositoryService = processEngine.getRepositoryService();
		
		Deployment deployment = repositoryService.createDeployment()
		  .addClasspathResource("proecesses/holiday-request.bpmn20.xml")
		  .deploy();
		
		System.out.println(deployment.getId());
		//-- 2. 流程定义查询
		ProcessDefinition processDefinition = 
				repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
		System.out.println("Found process definition : " + processDefinition.getDeploymentId()+":"+processDefinition.getId());
		
		//-- 模拟用户行为，并执行Holiday休假流程
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Who are you?");
		String employee = scanner.nextLine();
		
		System.out.println("How many holidays do you want to request?");
		Integer nrOfHolidays = Integer.valueOf(scanner.nextLine());
		
		System.out.println("Why do you need them?");
		String description = scanner.nextLine();
		
		//-- 3. 利用流程引擎获取运行时服务，并根据用户提交的学生申请休假的信息启动一个流程实例
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		Map<String, Object> variables = new HashMap<String, Object>();
		
		variables.put("employee", employee);
		variables.put("nrOfHolidays", nrOfHolidays);
		variables.put("description", description);
		
		ProcessInstance processInstance = 
				runtimeService.startProcessInstanceByKey("holidayRequest", variables);
		runtimeService.startProcessInstanceById(processDefinition.getId(), variables);
		
		//-- 4. 经理收到任务列表，选择要处理的任务
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskCandidateGroup("managers").list();
		System.out.println("You have " + tasks.size() + " tasks:");
		for (int i=0; i<tasks.size(); i++) {
		  System.out.println((i+1) + ") " + tasks.get(i).getName() + tasks.get(i).getProcessDefinitionId());
		}
		
		System.out.println("Which task would you like to complete?");
		int taskIndex = Integer.valueOf(scanner.nextLine());
		Task task = tasks.get(taskIndex - 1);
		Map<String, Object> processVariables = taskService.getVariables(task.getId());
		System.out.println(processVariables.get("employee") + " wants " +
		    processVariables.get("nrOfHolidays") + " of holidays. Do you approve this?");
		
		//-- 5. 经理给出处理的结果
		boolean approved = scanner.nextLine().toLowerCase().equals("y");
		variables = new HashMap<String, Object>();
		variables.put("approved", approved);
		taskService.complete(task.getId(), variables);	
		
		scanner.close();
	}
}
