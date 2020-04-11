package jing.chao.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import jing.chao.springcloud.entity.CommonResult;

/**
 * @author zzyy
 * @version 1.0
 * @create 2020/03/06
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult().fail("客户自定义，global handlerException---1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult().fail("客户自定义，global handlerException---2");
    }
}
