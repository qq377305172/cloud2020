package jing.chao.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author isi
 * @date 2020/4/1 15:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 2325529428514783868L;
    private Integer code;
    private String message;
    private T data;

//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public CommonResult(Integer code, String message, T data) {
//        this.code = code;
//        this.message = message;
//        this.data = data;
//    }
//
//    public CommonResult() {
//    }
//
//    @Override
//    public String toString() {
//        return "CommonResult{" +
//                "code=" + code +
//                ", message='" + message + '\'' +
//                ", data=" + data +
//                '}';
//    }


    public CommonResult<T> success(T data) {
        return new CommonResult<T>(200, "成功", data);
    }

    public CommonResult<T> fail(String message) {
        return new CommonResult<T>(500, message, null);
    }

}
