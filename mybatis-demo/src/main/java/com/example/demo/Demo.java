package demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Address;
import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.entity.Supplier;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.GradeMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.SupplierMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author jingzhidematong
 * @date 2019/11/29
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        String resource = "com/example/demo/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SupplierMapper supplierMapper = sqlSession.getMapper(SupplierMapper.class);
        Supplier supplier = supplierMapper.selectSupplier("SUceffc22f2fd840bdb2ccbc4f9713a5f0");
        System.out.println("********************8 : " + JSONObject.toJSONString(supplier));

        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        Address address = addressMapper.findById(1);
        System.out.println("address : " + address.toString());

        GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);
        Grade grade = gradeMapper.findById(2);
        System.out.println("grade : " + JSONObject.toJSONString(grade));

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = studentMapper.find();
        System.out.println("list : " + JSONObject.toJSONString(list));
        Student student = studentMapper.findStudentWithAddress(2);
        System.out.println("student : " + JSONObject.toJSONString(student));
        Student student1 = studentMapper.findByGradeId(1);
        System.out.println("student1 : " + JSONObject.toJSONString(student1));
        Student student2 = studentMapper.findById(3);
        System.out.println("student2 : " + JSONObject.toJSONString(student2));
    }
}
