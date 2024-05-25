package com.example.demo.unitests.mapper;



import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.demo.data.model.Person;
import com.example.demo.data.model.Vo.PersonVo;
import com.example.demo.mapper.dozerMapper;
import com.example.demo.unitests.mapper.mocks.MockPerson;
import com.github.dozermapper.core.DozerConverter;

//import com.github.dozermapper.core.DozerConverter;

public class DozerConverterTest {
	
	MockPerson inputObject;

    @BeforeEach
    public void setUp() {
    	  inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVo output = dozerMapper.parseObject(inputObject.mockEntity(), PersonVo.class);
        Assertions.assertEquals(Long.valueOf(0L), output.getId());
        Assertions.assertEquals("First Name Test0", output.getFirstName());
        Assertions.assertEquals("Last Name Test0", output.getLastName());
        Assertions.assertEquals("Addres Test0", output.getAddress());
        Assertions.assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVo> outputList = dozerMapper.parseListObject(inputObject.mockEntityList(), PersonVo.class);
        PersonVo outputZero = outputList.getFirst();
        
        Assertions.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assertions.assertEquals("First Name Test0", outputZero.getFirstName());
        Assertions.assertEquals("Last Name Test0", outputZero.getLastName());
        Assertions.assertEquals("Addres Test0", outputZero.getAddress());
        Assertions.assertEquals("Male", outputZero.getGender());
        
        PersonVo outputSeven = outputList.get(7);
        
        Assertions.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assertions.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assertions.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assertions.assertEquals("Addres Test7", outputSeven.getAddress());
        Assertions.assertEquals("Female", outputSeven.getGender());
        
        PersonVo outputTwelve = outputList.get(12);
        
        Assertions.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assertions.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assertions.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assertions.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assertions.assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = dozerMapper.parseObject(inputObject.mockVO(), Person.class);
        Assertions.assertEquals(Long.valueOf(0L), output.getId());
        Assertions.assertEquals("First Name Test0", output.getFirstName());
        Assertions.assertEquals("Last Name Test0", output.getLastName());
        Assertions.assertEquals("Addres Test0", output.getAddress());
        Assertions.assertEquals("Male", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = dozerMapper.parseListObject(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.getFirst();
        
        Assertions.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assertions.assertEquals("First Name Test0", outputZero.getFirstName());
        Assertions.assertEquals("Last Name Test0", outputZero.getLastName());
        Assertions.assertEquals("Addres Test0", outputZero.getAddress());
        Assertions.assertEquals("Male", outputZero.getGender());
        
        Person outputSeven = outputList.get(7);
        
        Assertions.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assertions.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assertions.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assertions.assertEquals("Addres Test7", outputSeven.getAddress());
        Assertions.assertEquals("Female", outputSeven.getGender());
        
        Person outputTwelve = outputList.get(12);
        
        Assertions.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assertions.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assertions.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assertions.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assertions.assertEquals("Male", outputTwelve.getGender());
    }

}
