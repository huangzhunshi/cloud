package com.zuul.bootc.proxy.zrl;

public class Zongjingli extends Lingdao {
    private final String name = "总经理";
    private final int level = 0;//最大
    @Override
    void chuli(Files file) {
        if (this.level > file.getLevel()) {
            System.out.println(name + "未处理文件《" + file.getFileName() + "》");
            getNextLingdao().chuli(file);
        } else {
            System.out.println(name + "处理了文件《" + file.getFileName() + "》");
        }
    }
}
