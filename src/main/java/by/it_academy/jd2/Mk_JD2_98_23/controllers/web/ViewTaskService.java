package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;
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
import java.util.LinkedHashMap;
import java.util.Objects;

@WebServlet("/api/task/view")
public class ViewTaskService extends HttpServlet {
    private static final String SORT = "sort";
    private static final String FILTER_HEADER = "header";
    private final ITaskService taskService;
    private final ObjectMapper objectMapper;

    public ViewTaskService() {
        this.taskService = TaskServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String sort = null;
        String header = null;

        if (req.getParameter(SORT).isEmpty()) {
            sort = req.getParameter(SORT);
        } else if (req.getParameter(FILTER_HEADER).isEmpty()) {
            header = req.getParameter(FILTER_HEADER);
        }
        PrintWriter writer = resp.getWriter();
        LinkedHashMap<Long, TaskDTO> dtos;

        assert sort != null;
        int sortParsed = Integer.parseInt(sort);

        dtos = taskService.getSorted(sortParsed);

        writer.write(objectMapper.writeValueAsString(dtos.values()));
    }
}
