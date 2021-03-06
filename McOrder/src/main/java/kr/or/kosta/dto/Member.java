package kr.or.kosta.dto;

import java.sql.Date;

public class Member {

   private String id;
   private String password;
   private String name;
   private String email;
   private String sample2_address;
   private String address2;
   private String address;
   private String phoneNum;
   private String grade;
   private Date lastLogin;
   private String birth;

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getSample2_address() {
      return sample2_address;
   }

   public void setSample2_address(String sample2_address) {
      this.sample2_address = sample2_address;
   }

   public String getAddress2() {
      return address2;
   }

   public void setAddress2(String address2) {
      this.address2 = address2;
   }

   public String getBirth() {
      return birth;
   }

   public void setBirth(String birth) {
      this.birth = birth;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhoneNum() {
      return phoneNum;
   }

   public void setPhoneNum(String phoneNum) {
      this.phoneNum = phoneNum;
   }

   public String getGrade() {
      return grade;
   }

   public void setGrade(String grade) {
      this.grade = grade;
   }

   public Date getLastLogin() {
      return lastLogin;
   }

   public void setLastLogin(Date lastLogin) {
      this.lastLogin = lastLogin;
   }

   @Override
   public String toString() {
      return "Member [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", address="
            + ", phoneNum=" + phoneNum + ", grade=" + grade + ", lastLogin=" + lastLogin + "]";
   }

}