package com.imooc.exception;

import com.imooc.utils.JsonResult;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * 统一异常拦截处理
 * 可以针对异常自定义去捕获，返回指定的类型（json类型）到前端
 * */
@ControllerAdvice
public class GraceExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    @ExceptionHandler(FileSizeLimitExceededException.class)
    @ResponseBody
    public JsonResult returnMaxFileSizeLimit(MaxUploadSizeExceededException e) {
        return JsonResult.errorMsg("文件大小不能超过 500KB");
    }

    @ExceptionHandler(MyCustomException.class)
    @ResponseBody
    public JsonResult returnMyCustomException(MyCustomException e) {
        return JsonResult.errorMsg(e.getMessage());
    }

}
