package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jingzhidematong
 * @date 2019/11/29
 */
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 供应商id
     */
    private String supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 付费类型
     */
    private String paymenttypeKey;

    /**
     * 公司地址
     */
    private String companyAddr;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 手机号
     */
    private String contactNumber;

    /**
     * 联系邮箱
     */
    private String contactEmail;

    /**
     * 合同开始时间
     */
    private String contractStarttime;

    /**
     * 合同结束时间
     */
    private String contractEndtime;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 供应商状态
     */
    private String status;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 插入时间
     */
    private Date inserttime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 逻辑删除
     */
    private Boolean isactive;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPaymenttypeKey() {
        return paymenttypeKey;
    }

    public void setPaymenttypeKey(String paymenttypeKey) {
        this.paymenttypeKey = paymenttypeKey;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContractStarttime() {
        return contractStarttime;
    }

    public void setContractStarttime(String contractStarttime) {
        this.contractStarttime = contractStarttime;
    }

    public String getContractEndtime() {
        return contractEndtime;
    }

    public void setContractEndtime(String contractEndtime) {
        this.contractEndtime = contractEndtime;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }


    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", paymenttypeKey='" + paymenttypeKey + '\'' +
                ", companyAddr='" + companyAddr + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contractStarttime='" + contractStarttime + '\'' +
                ", contractEndtime='" + contractEndtime + '\'' +
                ", contractCode='" + contractCode + '\'' +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                ", inserttime=" + inserttime +
                ", updatetime=" + updatetime +
                ", isactive=" + isactive +
                '}';
    }
}
