/**
 * 
 */
package controller;

import java.io.Serializable;

/**
 * 
 * @author wentao
 */
public class Foo implements Serializable {
	
	private int age;
	private String name;
	private Double price;
	
	
	/**
	 * 
	 */
	public Foo() {
	
	}


	/**
	 * @param age
	 * @param name
	 * @param price
	 */
	public Foo(int age, String name, Double price) {
		super();
		this.age = age;
		this.name = name;
		this.price = price;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Foo [age=" + age + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
