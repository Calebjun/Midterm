package sheridan.junc.midterm;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(StudentRepository repository) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/students.json");
            Map<String, List<Student>> wrapper = mapper.readValue(
                    inputStream, new TypeReference<Map<String, List<Student>>>() {});
            List<Student> students = wrapper.get("students");
            repository.saveAll(students);
            System.out.println("Loaded " + students.size() + " students into the database.");
        };
    }
}
