package com.bw.guojinyi.bean;

import java.io.Serializable;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/6 16:32
 * @Description: 用途：完成特定功能
 */
public class PayBean implements Serializable {

    /**
     * message : 该订单已支付
     * status : 1001
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
