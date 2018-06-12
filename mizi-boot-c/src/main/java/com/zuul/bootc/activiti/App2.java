package com.zuul.bootc.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricDetailQuery;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;

import java.util.List;

public class App2 {
    public static void main(String[] args){
        //System.out.println("xxxxxx");
        //DeploymentList();

        //startDeployment();
        //taskList();
        //complete();
        //historicProcessInstanceList();
        //historicDetailQuery();

        aaaa();
    }

    private static void aaaa(){
        System.out.println("xxxxxx-xxx");
    }

    private static void historicDetailQuery(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        List<HistoricDetail> list= processEngine.getHistoryService().createHistoricDetailQuery().list();
        list.forEach(x->{
            System.out.println(x.getTaskId());
            System.out.println(x.getExecutionId());

        });
    }


    private static void historicProcessInstanceList(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        List<HistoricProcessInstance> list= processEngine.getHistoryService().createHistoricProcessInstanceQuery().list();
        list.forEach(x->{
            System.out.println(x.getName());
            System.out.println(x.getBusinessKey());
            System.out.println(x.getId());

        });
    }


    private static void complete(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        processEngine.getTaskService().complete("32502");
    }

    private static void taskList(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        List<Task> list= processEngine.getTaskService().createTaskQuery().list();
        for (Task task: list) {
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getAssignee());
        }
    }

    private static void startDeployment(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        //processEngine.getRuntimeService().startProcessInstanceById("myProcess:4:22504");
       processEngine.getRuntimeService().startProcessInstanceByKey("myProcess");
        // processEngine.getRuntimeService().startProcessInstanceByKey()
    }

    private static void DeploymentList(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        List<Deployment> list= processEngine.getRepositoryService().createDeploymentQuery().list();
        list.forEach(d->{
            System.out.println(d.getId());
            System.out.println(d.getKey());
            System.out.println(d.getCategory());
            System.out.println(d.getName());
            System.out.println(d.getTenantId());
            System.out.println(d.getDeploymentTime());
            System.out.println("==============================");
        });
    }



}
