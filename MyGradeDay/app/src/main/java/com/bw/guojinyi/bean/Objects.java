package com.bw.guojinyi.bean;

import java.io.Serializable;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/26 17:13
 * @Description: 用途：完成特定功能
 */
public class Objects implements Serializable {
    private String masterPic;
    private String commodityName;

    public String getCommodityName() {
        return commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }
}
