package org.dj.javatest;

public class Animal {
	protected String name = "animal";
	public void eat() {
		System.err.println(name + " eat food.");
	}
	
	public void eat(String food) {
		System.out.println(name + " eat " + food);
	}
	
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.eat();
		Animal animal2 = new Cat();
		animal2.eat();
	}
}

class Dog extends Animal {
	public Dog() {
		this.name = "dog";
	}
	
	@Override
	public void eat() {
		System.err.println(name + " eat food.");
	}
}

class Cat extends Animal {
	public Cat() {
		this.name = "cat";
	}
	
	@Override
	public void eat() {
		super.eat();
	}
}
