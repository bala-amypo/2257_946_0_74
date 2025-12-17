import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepository repo;
    @Override
    public Student createData(Student stu){
        return repo.save(stu);
    }
    @Override
    public List<Student>fetchRecord(){
        return repo.findAll();
    }
}