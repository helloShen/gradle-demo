/**
 * An item in to-do list.
 * It is a POJO.
 */
package com.ciaoshen.gradle_demo.chapter3.todo.model;

public class ToDoItem implements Comparable<ToDoItem> {
	
	private Long id;
	private String name;
	private boolean completed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int compareTo(ToDoItem item) {
		return (int) (this.id - item.id);
	}

	public String toString() {
		return "Item[" + id + "] = " + name;
	}

}
