package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.ITaskService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.ObjectMapperFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.TaskServiceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/api/task/create")
public class TaskCreateServlet extends HttpServlet {
    private static final String HEADER = "header";
    private static final String DESCRIPTION = "description";
    private static final String DEADLINE = "deadline";
    private static final String STATUS  = "status";
    private static final String EXECUTOR = "executor";
    private final ITaskService taskService;
    private final ObjectMapper objectMapper;

    public TaskCreateServlet() {
        this.taskService = TaskServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String header = req.getParameter(HEADER);
        String description = req.getParameter(DESCRIPTION);
        String deadline = req.getParameter(DEADLINE);
        String status = req.getParameter(STATUS);
        String executor = req.getParameter(EXECUTOR);

        if (true) {
            LocalDate deadlineParsed = LocalDate.parse(deadline);
            int statusParsed = Integer.parseInt(status);

            TaskCreateDTO dto = new TaskCreateDTO(header, description, deadlineParsed, statusParsed);

            taskService.save(dto);
            writer.write(objectMapper.writeValueAsString(dto));
        }
    }
}
