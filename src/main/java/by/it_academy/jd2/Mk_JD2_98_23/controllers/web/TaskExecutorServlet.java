package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.service.api.ITaskService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.TaskServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/task/executor")
public class TaskExecutorServlet extends HttpServlet {
    private static final String EXECUTOR = "executor_id";
    private static final String TASK = "task_id";
    private final ITaskService taskService;

    public TaskExecutorServlet() {
        this.taskService = TaskServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String executorID = req.getParameter(EXECUTOR);
        String taskID = req.getParameter(TASK);

        if (true) {
            int executorIDParser = Integer.parseInt(executorID);
            int taskIDParser = Integer.parseInt(taskID);

            taskService.signExecutor(executorIDParser);
        }
    }
}
