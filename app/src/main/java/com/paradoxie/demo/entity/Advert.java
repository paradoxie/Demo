package com.paradoxie.demo.entity;/**
 * Created by xiehehe on 2016/10/16.
 */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * User: xiehehe
 * Date: 2016-10-16
 * Time: 22:39
 * FIXME 广告实体类
 */
@Entity
public class Advert {
    @Id
    private Long id;//主键id,必须Long型
    private String classify;//广告类型
    private String times;//广告次数
    private String time;//广告时长

    ////写完以上实体类属性后，编译，自动生成以下get、set内容以及com.paradoxie.demo.dao目录下三个文件////

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimes() {
        return this.times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getClassify() {
        return this.classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 129514472)
    public Advert(Long id, String classify, String times, String time) {
        this.id = id;
        this.classify = classify;
        this.times = times;
        this.time = time;
    }

    @Generated(hash = 1260794334)
    public Advert() {
    }
}
