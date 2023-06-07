package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorTaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorTaskService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.ExecutorTaskServiceFactory;
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
public class ExecutorTaskCreateServlet extends HttpServlet {
    private final IExecutorTaskService executorTaskService ;
    private final ObjectMapper objectMapper;

    public ExecutorTaskCreateServlet() {
        this.executorTaskService = ExecutorTaskServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        ExecutorTaskCreateDTO dto = objectMapper.readValue(req.getInputStream(), ExecutorTaskCreateDTO.class);

        executorTaskService.save(dto);
        writer.write((objectMapper.writeValueAsString(dto)));
    }
}
