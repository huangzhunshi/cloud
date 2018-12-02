package com.zuul.bootc.common;

import com.google.common.collect.Lists;

import java.util.List;

public class Opt {
    /**
     * 选项名称
     */
    private String optName;


    /**
     * 1-选择 2-填空 10-自定义处理
     */
    private Integer optType;


    /**
     * 是否填写备注
     */
    private boolean isRemark=false;

    /**
     * 是否上传图片
     */
    private boolean isUpload=false;




    /**
     * 选项下的子选项-扩展
     */
    private List<Opt> optExt= Lists.newArrayList();

}
