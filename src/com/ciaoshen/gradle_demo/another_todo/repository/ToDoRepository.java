/**
 * Interface of repository of ToDoItem
 */
package com.ciaoshen.gradle_demo.another_todo.repository;

import com.ciaoshen.gradle_demo.another_todo.model.ToDoItem;
import java.util.List;

public interface ToDoRepository {
	List<ToDoItem> findAll();
	ToDoItem findById(Long id);
	Long insert(ToDoItem item);
	void update(ToDoItem item);
	void delete(ToDoItem item);
}

