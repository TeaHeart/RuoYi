package com.ruoyi.ums.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生管理对象 ums_student
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
public class UmsStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Integer id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer age;

    /** 班级编号 */
    @Excel(name = "班级编号")
    private Integer classId;

    private UmsClass umsClass;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setAge(Integer age) 
    {
        this.age = age;
    }

    public Integer getAge() 
    {
        return age;
    }

    public void setClassId(Integer classId) 
    {
        this.classId = classId;
    }

    public Integer getClassId() 
    {
        return classId;
    }

    public UmsClass getUmsClass() {
        return umsClass;
    }

    public void setUmsClass(UmsClass umsClass) {
        this.umsClass = umsClass;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("age", getAge())
            .append("classId", getClassId())
            .append("umsClass", getUmsClass())
            .toString();
    }
}
