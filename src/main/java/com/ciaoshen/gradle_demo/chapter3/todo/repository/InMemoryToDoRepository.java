/**
 * In Memory database
 */
package com.ciaoshen.gradle_demo.chapter3.todo.repository;

import com.ciaoshen.gradle_demo.chapter3.todo.model.ToDoItem;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryToDoRepository implements ToDoRepository {

	// id is destributed by repository
	private AtomicLong currentId = new AtomicLong();
	// main container
	private ConcurrentMap<Long, ToDoItem> toDos = new ConcurrentHashMap<>();

	@Override
	public List<ToDoItem> findAll() {
		List<ToDoItem> toDoItems = new ArrayList<>(toDos.values());
		Collections.sort(toDoItems);
		return toDoItems;
	}

	@Override
	public ToDoItem findById(Long id) {
		return toDos.get(id);
	}

	@Override
	public Long insert(ToDoItem item) {
		Long id = currentId.incrementAndGet();
		item.setId(id);
		toDos.putIfAbsent(id, item);
		return id;
	}

	@Override
	public void update(ToDoItem item) {
		toDos.replace(item.getId(), item);
	}

	@Override
	public void delete(ToDoItem item) {
		toDos.remove(item.getId());
	}
}

