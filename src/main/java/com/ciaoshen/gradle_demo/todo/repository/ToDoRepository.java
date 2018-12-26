/**
 * Interface of repository of ToDoItem
 */
package com.ciaoshen.gradle_demo.todo.repository;

import com.ciaoshen.gradle_demo.todo.model.ToDoItem;
import java.util.List;

public interface ToDoRepository {
	List<ToDoItem> findAll();
	ToDoItem findById(Long id);
	Long insert(ToDoItem item);
	void update(ToDoItem item);
	void delete(ToDoItem item);
}

