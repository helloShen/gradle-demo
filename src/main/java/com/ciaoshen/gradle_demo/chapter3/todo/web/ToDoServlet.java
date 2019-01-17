/**
 * Servlet that do the job
 */
package com.ciaoshen.gradle_demo.chapter3.todo.web;

import com.ciaoshen.gradle_demo.chapter3.todo.model.ToDoItem;
import com.ciaoshen.gradle_demo.chapter3.todo.repository.ToDoRepository;
import com.ciaoshen.gradle_demo.chapter3.todo.repository.InMemoryToDoRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ToDoServlet extends HttpServlet {
    private ToDoRepository toDoRepository = new InMemoryToDoRepository();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String view = processRequest(servletPath, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    private String processRequest(String servletPath, HttpServletRequest request) {
        if (servletPath.equals("/all")) {
            List<ToDoItem> toDoItems = toDoRepository.findAll();
            //add some events to test
            ToDoItem[] newItems = testcases(5);
            for (ToDoItem item : newItems) toDoItems.add(item);
            request.setAttribute("toDoItems", toDoItems);
            // List<ToDoItem> itemsGetFromRequest = (List<ToDoItem>) request.getAttribute("toDoItems");
            // for (ToDoItem item : itemsGetFromRequest) System.out.println(item);
            return "/jsp/todo-list.jsp";
        } else {
            return "/error";
        }
    }

    private ToDoItem[] testcases(int size) {
        ToDoItem[] items = new ToDoItem[size];
        for (int i = 0; i < size; i++) {
            items[i] = new ToDoItem();
            items[i].setId((long)i);
            items[i].setName("Item[" + i + "]");
        }
        return items;
    }

}