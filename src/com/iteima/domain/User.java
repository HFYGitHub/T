package com.iteima.domain;

public class User {
private Integer id;
private String name;
private String password;
private String email;
private Integer permission;
private String nickname;
private String sex;
private String academy;
private String declaration;
private Integer qq;
private String wechat;
private Integer phone;
private String image;

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getPermission() {
	return permission;
}
public void setPermission(Integer permission) {
	this.permission = permission;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAcademy() {
	return academy;
}
public void setAcademy(String academy) {
	this.academy = academy;
}
public String getDeclaration() {
	return declaration;
}
public void setDeclaration(String declaration) {
	this.declaration = declaration;
}
public Integer getQq() {
	return qq;
}
public void setQq(Integer qq) {
	this.qq = qq;
}
public String getWechat() {
	return wechat;
}
public void setWechat(String wechat) {
	this.wechat = wechat;
}
public Integer getPhone() {
	return phone;
}
public void setPhone(Integer phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", permission="
			+ permission + ", nickname=" + nickname + ", sex=" + sex + ", academy=" + academy + ", declaration="
			+ declaration + ", qq=" + qq + ", wechat=" + wechat + ", phone=" + phone + ", image=" + image + "]";
}



}
