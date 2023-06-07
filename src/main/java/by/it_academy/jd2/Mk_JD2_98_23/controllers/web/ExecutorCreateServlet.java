package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
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

@WebServlet("/api/executor/create")
public class ExecutorCreateServlet extends HttpServlet {
    private final IExecutorService executorService;
    private final ObjectMapper objectMapper;

    public ExecutorCreateServlet() {
        this.executorService = ExecutorServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        ExecutorCreateDTO dto = objectMapper.readValue(req.getInputStream(), ExecutorCreateDTO.class);

        executorService.save(dto);
        writer.write(objectMapper.writeValueAsString(dto));
    }
}
