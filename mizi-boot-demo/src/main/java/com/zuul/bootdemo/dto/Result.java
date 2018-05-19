package com.zuul.bootdemo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class Result<T> implements Serializable {

   private Integer code;
   private String msg;
   private T data;

}
