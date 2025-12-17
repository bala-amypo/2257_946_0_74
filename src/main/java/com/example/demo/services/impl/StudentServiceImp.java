import com.example.demo.entity



import org.springframework.stereotype.Service;
@service
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