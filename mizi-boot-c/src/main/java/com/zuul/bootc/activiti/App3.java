package com.zuul.bootc.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App3 {
    public static void main(String[] args){
//        deployProcess();
//        startProcess();
      //  taskList();
//        completeTask();

//        deleteProcess();

 //       completehi2();

    //-----------------------------------------

//        deployhi2();
  //      starthi2();
    }

    public static void completehi2(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
//        processEngine.getTaskService().setVariable("97505","审批意见","同意,支持");
        processEngine.getTaskService().setVariableLocal("97505","意见","不知道怎么写");

        processEngine.getTaskService().complete("97505");
    }


    /**
     * 开始hi2流程
     */
    public static void starthi2(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        ProcessInstance processInstance= processEngine.getRuntimeService().startProcessInstanceByKey("hi2");
        System.out.println(processInstance.getDeploymentId());
        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getId());
    }

    /**
     * 发布hi2流程
     */
    public static void deployhi2(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();


        Deployment deployment = processEngine.getRepositoryService().createDeployment().name("hi2流程").key("hi2")
                .addClasspathResource("process/hi2.bpmn").deploy();
    }



    /**
     * 删除流程
     */
    public static void deleteProcess(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();


        processEngine.getRuntimeService().deleteProcessInstance("42501","bmp修改");
        processEngine.getRuntimeService().deleteProcessInstance("45001","bmp修改");

    }

    /**
     * 处理任务
     */
    public static void completeTask(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("yes",1);
        processEngine.getTaskService().complete("85005",variables);
    }

    /**
     * 审批任务列表
     */
    public static void taskList(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        List<Task> list= processEngine.getTaskService().createTaskQuery().taskAssignee("huangzhun").list();
        for (Task task: list) {
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getAssignee());
            System.out.println("流程id--"+task.getProcessInstanceId());

            System.out.println(task.getParentTaskId());

        }
    }


    /**
     * 启动流程
     */
    public static void startProcess(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        ProcessInstance processInstance= processEngine.getRuntimeService().startProcessInstanceByKey("bossp");
        System.out.println(processInstance.getDeploymentId());
        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getId());

    }

    /**
     * 发布流程
     */
    public static void deployProcess(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();


        Deployment deployment = processEngine.getRepositoryService().createDeployment().name("老板审批").key("bossp")
                .addClasspathResource("process/hi.bpmn").deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getKey());
        System.out.println(deployment.getName());
    }



}
