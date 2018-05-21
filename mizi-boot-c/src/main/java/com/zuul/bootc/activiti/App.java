package com.zuul.bootc.activiti;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class App {

    //驱动程序名
    static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    static String url = "jdbc:mysql://192.168.146.128:3306/canal_test";
    //MySQL配置时的用户名
    static String user = "root";
    //MySQL配置时的密码
    static String password = "222222";

    public static void main(String[] args) {
        //createActivitiTable();
        //fy_test();
        //startProcessInstance(); 25001
        //findTask();
        //completeTask();
        getTaskById();
    }

    /**
     * 获取流程下的任务
     */
    public static void getTaskById(){
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        //List<HistoricTaskInstance> list=processEngine.getHistoryService().createHistoricTaskInstanceQuery().list();

        List<Task> list= processEngine.getTaskService().createTaskQuery().taskId("25005").list();
//        List<ProcessInstance> list= processEngine.getRuntimeService().createProcessInstanceQuery()
//                .processDefinitionId("25005").list();
        if(list==null||list.size()==0){
            System.out.print("无数据");
            return;
        }
        list.stream().forEach(task -> {
            System.out.println(task.getName());
            System.out.println(task.getAssignee());
        });

    }

    /**
     * 处理任务
     */
    public static void completeTask(){
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        processEngine.getTaskService().complete("17502");
        System.out.println("完成任务");

    }

    /**
     * 查看任务列表
     */
    public static void findTask(){



        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        List<Task> list=processEngine.getTaskService().createTaskQuery()
                //.taskAssignee("张三")
                .list();


        if(list==null||list.size()==0){
            System.out.println("没有数据");
            return;
        }
        for (Task task:list) {
            System.out.println("任务id:"+task.getId());
            System.out.println("任务名称:"+task.getName());
            System.out.println("任务创建时间:"+task.getClaimTime());
            System.out.println("任务办理人:"+task.getAssignee());
            System.out.println("任务实例id:"+task.getProcessInstanceId());
            System.out.println("执行对象id:"+task.getExecutionId());
            System.out.println("流程定义id:"+task.getProcessDefinitionId());


        }
    }

    public static void startProcessInstance() {
        try {
            ProcessEngine processEngine = ProcessEngineConfiguration
                    .createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
            // 流程定义的key
            String processDefinitionKey = "myProcess";
            ProcessInstance pi = processEngine.getRuntimeService()// 与正在执行
                    // 的流程实例和执行对象相关的Service
                    .startProcessInstanceByKey(processDefinitionKey); // 使用流程定义的key启动流程实例,key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
            System.out.println("流程实例ID:" + pi.getId());
            System.out.println("流程定义ID:" + pi.getProcessDefinitionId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建流程
     */
    public static void fy_test(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        System.out.println("------processEngine:" + processEngine);

        //创建流程
//        Deployment deployment = processEngine.getRepositoryService().createDeployment().name("请假程序")
//                .addClasspathResource("activiti/MyProcess.bpmn").addClasspathResource("activiti/MyProcess.png").deploy();

        Deployment deployment = processEngine.getRepositoryService().createDeployment().name("请假程序")
                .addClasspathResource("process/MyProcess.bpmn").deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }

    /**
     * 创建工作流表
     */
    public static void createActivitiTable(){
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration();
        //连接数据库的配置
        processEngineConfiguration.setJdbcDriver(driver);
        processEngineConfiguration.setJdbcUrl(url);
        processEngineConfiguration.setJdbcUsername(user);
        processEngineConfiguration.setJdbcPassword(password);

        //三个配置
        //1.先删除表，再创建表：processEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP="create-drop"
        //2.不能自动创建表，需要表存在：processEngineConfiguration.DB_SCHEMA_UPDATE_FALSE="false"
        //3.如果表存在，就自动创建表：processEngineConfiguration.DB_SCHEMA_UPDATE_TRUE="true"
        processEngineConfiguration.setDatabaseSchema(processEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        //获取工作流的核心对象，ProcessEngine对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        System.out.println("processEngine:" + processEngine + "Create Success!!");
    }

    public void getMsSql(){
        //声明Connection对象
        Connection con;
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select top 10 * from sys_user";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            String name = "";
            while(rs.next()){
                //获取stuname这列数据
                name = rs.getString("name");
                //首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
                //输出结果
                System.out.println("name=" + name);
            }
            rs.close();
            con.close();
        } catch(Exception e) {
            //数据库驱动类异常处理
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
    }
}


