package com.bw.guojinyi.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/26 16:43
 * @Description: 用途：完成特定功能
 */
public class ResultBean implements Serializable {
    private String imageUrl;
    private List<RxxpBean> rxxp;

    public String getImageUrl() {
        return imageUrl;
    }

    public List<RxxpBean> getRxxp() {
        return rxxp;
    }
}
