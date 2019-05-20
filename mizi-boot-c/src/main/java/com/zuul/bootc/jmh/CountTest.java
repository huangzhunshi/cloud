//package com.zuul.bootc.jmh;
//
//import com.google.common.collect.Lists;
//import org.openjdk.jmh.annotations.*;
//
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
////@BenchmarkMode(Mode.Throughput)
//@BenchmarkMode({Mode.Throughput,Mode.AverageTime})
//@State(Scope.Thread)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Fork(1)
//@Warmup(iterations = 1)
//public class CountTest {
//    @Benchmark
//    @Warmup(iterations = 2)
//    @Measurement(iterations = 2)
//    public void serialLazyJDK() throws InterruptedException {
//       Thread.sleep(100);
//    }
//
//    @Benchmark
//    @Warmup(iterations = 2)
//    @Measurement(iterations = 2)
//    public void serialLazyGSC() {
//
//    }
//
//
//
//     Hashtable hashtable=new Hashtable();
//
//     HashMap hashMap=new HashMap();
//
//     List<UserModel> userModelList= Lists.newArrayList();
//
//
//     public  CountTest(){
//         loadData();
//     }
//
//
//
//    @Setup
//    public void loadData(){
//        for(Integer i=0;i<10000;i++){
//            hashtable.put(i.toString(),i.toString());
//            hashMap.put(i.toString(),i.toString());
//            userModelList.add(UserModel.builder().userId(i).sex(1).userName("user"+i).build());
//        }
//    }
//
//    @Benchmark
//    public void getUserModeByName2(){
//        userModelList.stream().filter(x->x.getUserName().equals("user9000"));
//    }
//
//    @Benchmark
//    public void getUserModeByName(){
//        //userModelList.stream()
//        for (UserModel userModel:userModelList) {
//            if(userModel.getUserName().equals("user1000")){
//                break;
//            }
//        }
//    }
//
//    @Benchmark
//    public void getMapKey(){
//        Object object= hashMap.get("9000");
//        //System.out.println(object);
//    }
//
//    @Benchmark
//    public void getHashKey(){
//        Object object=hashtable.get("9000");
//       // System.out.println(object);
//
//    }
//
//    public static void main(String[] args){
//       // userModelList.stream().filter(x->x.getUserName().equals("user9000"));
//        CountTest countTest=new CountTest();
//        countTest.loadData();
//        UserModel userModel= countTest.userModelList.stream().filter(x->x.getUserName().equals("user9000")).findFirst().orElse(null);
//        System.out.println(userModel.getUserName());
//    }
//
//}
//
//package com.zuul.bootc.jmh;
//
//import com.google.common.collect.Lists;
//import org.openjdk.jmh.annotations.*;
//
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
////@BenchmarkMode(Mode.Throughput)
//@BenchmarkMode({Mode.Throughput,Mode.AverageTime})
//@State(Scope.Thread)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Fork(1)
//@Warmup(iterations = 1)
//public class CountTest {
//    @Benchmark
//    @Warmup(iterations = 2)
//    @Measurement(iterations = 2)
//    public void serialLazyJDK() throws InterruptedException {
//       Thread.sleep(100);
//    }
//
//    @Benchmark
//    @Warmup(iterations = 2)
//    @Measurement(iterations = 2)
//    public void serialLazyGSC() {
//
//    }
//
//
//
//     Hashtable hashtable=new Hashtable();
//
//     HashMap hashMap=new HashMap();
//
//     List<UserModel> userModelList= Lists.newArrayList();
//
//
//     public  CountTest(){
//         loadData();
//     }
//
//
//
//    @Setup
//    public void loadData(){
//        for(Integer i=0;i<10000;i++){
//            hashtable.put(i.toString(),i.toString());
//            hashMap.put(i.toString(),i.toString());
//            userModelList.add(UserModel.builder().userId(i).sex(1).userName("user"+i).build());
//        }
//    }
//
//    @Benchmark
//    public void getUserModeByName2(){
//        userModelList.stream().filter(x->x.getUserName().equals("user9000"));
//    }
//
//    @Benchmark
//    public void getUserModeByName(){
//        //userModelList.stream()
//        for (UserModel userModel:userModelList) {
//            if(userModel.getUserName().equals("user1000")){
//                break;
//            }
//        }
//    }
//
//    @Benchmark
//    public void getMapKey(){
//        Object object= hashMap.get("9000");
//        //System.out.println(object);
//    }
//
//    @Benchmark
//    public void getHashKey(){
//        Object object=hashtable.get("9000");
//       // System.out.println(object);
//
//    }
//
//    public static void main(String[] args){
//       // userModelList.stream().filter(x->x.getUserName().equals("user9000"));
//        CountTest countTest=new CountTest();
//        countTest.loadData();
//        UserModel userModel= countTest.userModelList.stream().filter(x->x.getUserName().equals("user9000")).findFirst().orElse(null);
//        System.out.println(userModel.getUserName());
//    }
//
//}
//
