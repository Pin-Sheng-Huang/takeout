package com.sky.handler;

import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * *处理SQL异常
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler (SQLIntegrityConstraintViolationException ex){
        //Duplicate entry 'qqqq' for key 'employee.idx_username'
        String msg = ex.getMessage();
        log.error("-------SQL入库异常---------");
        if(msg.contains("Duplicate entry")){
            String[] split = msg.split(" ");//已扣隔座划分
            String username = split[2];
            String alreadyExists = MessageConstant.ALREADY_EXISTS;
            String msgg = username+ alreadyExists;
            log.error(msgg);
            log.error(msg);
        }
            return Result.error(MessageConstant.UNKNOWN_ERROR);

    }

}
