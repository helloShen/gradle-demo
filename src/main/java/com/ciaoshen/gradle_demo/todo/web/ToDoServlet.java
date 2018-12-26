package com.ciaoshen.gradle_demo.todo.web;

import com.ciaoshen.gradle_demo.another_todo.repository.InMemoryToDoRepository;
import com.ciaoshen.gradle_demo.todo.model.ToDoItem;
import com.ciaoshen.gradle_demo.todo.repository.InMemoryToDoReopository;
import com.ciaoshen.gradle_demo.todo.repository.ToDoRepository;

import javax.servlet.*;
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
            request.setAttribute("toDoItems", toDoItems);
            return "/jsp/todo-list.jsp";
        } else if (servletPath.equals("/delete") {
            List<ToDoItem> toDoItems = toDoRepository.delete(item);
            request.setAttribute("toDoItems", toDoItems);
            return "/jsp/todo-list-delete.jsp";
        } else {
            return "/all";
        }
    }

}