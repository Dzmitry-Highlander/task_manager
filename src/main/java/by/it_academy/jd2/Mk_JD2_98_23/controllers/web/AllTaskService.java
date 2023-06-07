package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.ITaskService;
import by.it_academy.jd2.Mk_JD2_98_23.service.enums.Sort;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/task/all")
public class AllTaskService extends HttpServlet {
    private final ITaskService taskService;
    private final ObjectMapper objectMapper;

    public AllTaskService() {
        this.taskService = TaskServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        List<TaskDTO> dtos = new ArrayList<>();
        PrintWriter writer = resp.getWriter();

        if (objectMapper.canSerialize(Sort.class)) {
            Integer sort = objectMapper.readValue(req.getInputStream(), Integer.class);

            dtos = taskService.getSorted(sort);
        } else {
            dtos = taskService.get();
        }

        writer.write(objectMapper.writeValueAsString(dtos));
    }
}
