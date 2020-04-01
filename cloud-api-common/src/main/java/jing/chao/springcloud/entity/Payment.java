package jing.chao.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author isi
 * @date 2020/4/1 14:58
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment implements Serializable {
    private static final long serialVersionUID = -4854207573793101813L;
    private Long id;
    private String serial;

}
