package by.it_academy.jd2.Mk_JD2_98_23.controllers.web;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/api/task/executor")
public class TaskExecutorServlet extends HttpServlet {
    private final IExecutorService executorService;
    private final ObjectMapper objectMapper;

    public TaskExecutorServlet(IExecutorService executorService) {
        this.executorService = executorService;
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        InputStream stream = req.getInputStream();
        String string = "";

        try (stream) {
            char[] tmp = new char[4096];
            StringBuilder sb = new StringBuilder(Math.max(16, stream.available()));
            InputStreamReader reader = new InputStreamReader(stream);

            for (int cnt; (cnt = reader.read(tmp)) > 0;) {
                sb.append(tmp, 0, cnt);
            }

            string = sb.toString();
        }

        ExecutorDTO executorDTO = objectMapper.readValue(string, ExecutorDTO.class);
        TaskDTO taskDTO = objectMapper.readValue(string, TaskDTO.class);

        executorService.signExecutor(executorDTO, taskDTO);
        writer.write("Исполнитель добавлен");
    }
}
