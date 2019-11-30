package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author jingzhidematong
 * @date 2019/11/29
 */
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String gradeName;
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public List<Student> getSuppliers() {
        return students;
    }

    public void setSuppliers(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                ", students=" + students +
                '}';
    }
}
