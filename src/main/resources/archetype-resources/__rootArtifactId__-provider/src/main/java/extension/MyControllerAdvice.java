package ${package}.extension;

import com.deepexi.util.config.Payload;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by donh on 2018/11/6.
 * 全局异常统一处理
 */
@RestControllerAdvice
public class MyControllerAdvice {

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Payload errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 500);
        map.put("msg", ex.getMessage());
        return new Payload(map);
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    public Payload myErrorHandler(MyException ex) {
        Map map = new HashMap();
        map.put("code", ex.getCode());
        map.put("msg", ex.getMsg());
        return new Payload(map);
    }

}