package com.zuul.bootc.jmh;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


public class App {
    public static void main(String[] args) throws IOException {

 ClassWriter classWriter = new ClassWriter(0);
        String className = "com/sunchao/asm/HelloWorld";
        classWriter.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC, className, null,
                "java/lang/Object", null);


        MethodVisitor initVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>",
                "()V", null, null);
        initVisitor.visitCode();
        initVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        initVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>",
                "V()");
        initVisitor.visitInsn(Opcodes.RETURN);
        initVisitor.visitMaxs(1, 1);
        initVisitor.visitEnd();

        MethodVisitor helloVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "sayHello",
                "()V;", null, null);
        helloVisitor.visitCode();
        helloVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out",
                "Ljava/io/PrintStream;");
        helloVisitor.visitLdcInsn("hello world!");
        helloVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream",
                "println", "(Ljava/lang/String;)V");
        helloVisitor.visitInsn(Opcodes.RETURN);
        helloVisitor.visitMaxs(1, 1);
        helloVisitor.visitEnd();

        classWriter.visitEnd();
//        byte[] code = classWriter.toByteArray();
//        File file = new File("D:\\HelloWorld.class");
//        FileOutputStream output = new FileOutputStream(file);
//        output.write(code);
//        output.close();
    }



    /**
     * 动态扩容
     */
    private static void kuorong(){

        UserModel[] aaa=new UserModel[]{
                UserModel.builder().sex(1).userId(1).userName("huangz").build(),
                UserModel.builder().sex(1).userId(2).userName("yih").build(),
                UserModel.builder().sex(1).userId(3).userName("huangjl").build()
        };
        UserModel [] target=new UserModel[4];//新建一个目标对象数组
        System.arraycopy(aaa, 0, target, 0, aaa.length);//实现复制


        for (UserModel u:target
                ) {
            if(u==null){
                System.out.println("null");
            }else {
                System.out.println(u.getUserName());
            }
        }
    }
}
