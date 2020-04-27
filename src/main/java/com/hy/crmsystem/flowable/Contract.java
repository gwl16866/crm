package com.hy.crmsystem.flowable;

import org.flowable.engine.*;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contract {
   private static ProcessEngine processEngine;
   private static TaskService taskService;



    public static void main(String[] args) {
        //创建流程引擎对象
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://127.0.0.1:3306/flowable")
                .setJdbcUsername("root")
                .setJdbcPassword("root")
                .setJdbcDriver("com.mysql.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        //发布流程
       /* RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("Contract.bpmn20.xml")
                .deploy();*/

        //测试流程是不是成功
      /*  ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName());*/


        //启动流程实例
        /*RuntimeService runtimeService = processEngine.getRuntimeService();

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", "李四");
        variables.put("cid", 5);
        variables.put("cname", "腾讯合作项目");
        variables.put("firstManager","一级");
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("contract", variables);*/

        //查询待办任务





        TaskService taskService = processEngine.getTaskService();
        List<Task> list=taskService.createTaskQuery().taskCandidateOrAssigned("审批人2").list();
        System.out.println(list.size());

        Task task=list.get(0);
        Map<String, Object> processVariables = taskService.getVariables(task.getId());
        System.out.println(processVariables.get("employee") + "想审批" +
          processVariables.get("cid") + "←← 编号-----合同名字 →→"+processVariables.get("cname")+"审批人"+processVariables.get("secondManager"));



        //执行审批
        /*Map<String, Object> variables1 = new HashMap<String, Object>();
        variables1.put("approved",true);
        variables1.put("secondManager","审批人2");
        taskService.complete(task.getId(), variables1);*/

    }





}

