package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.ExecutorServiceFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/executor_task/create")
public class ExecutorTaskServlet extends HttpServlet {
    private final String EXECUTOR_ID = "executorID";
    private final String TASK_ID = "taskID";
    private final IExecutorService executorService;
    private final ObjectMapper objectMapper;

    public ExecutorTaskServlet() {
        this.executorService = ExecutorServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String executorID = req.getParameter(EXECUTOR_ID);
        String taskID = req.getParameter(TASK_ID);
        PrintWriter writer = resp.getWriter();


    }
}
