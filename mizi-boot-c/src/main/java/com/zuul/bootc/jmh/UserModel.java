package com.zuul.bootc.jmh;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private Integer userId;
    private String userName;
    private Integer sex;

}
