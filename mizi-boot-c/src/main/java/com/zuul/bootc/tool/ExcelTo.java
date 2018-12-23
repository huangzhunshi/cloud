package com.zuul.bootc.tool;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.Map;

public class ExcelTo {
    public static void main(String[] args){
        ExcelReader reader= ExcelUtil.getReader("/mywork/tmp/mizi/mizi-boot-c/src/main/java/com/zuul/bootc/tool/全国直营圣诞溢价门店.xlsx");


        List<Map<String,Object>> readAll = reader.readAll();

        for (Map map: readAll) {
            System.out.println(map.get("shop_id"));
        }

        reader.close();

    }
}
