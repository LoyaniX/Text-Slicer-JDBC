package com.loyanix.textslicer.jdbc;

import com.loyanix.textslicer.jdbc.Services.FileInfo;
import com.loyanix.textslicer.jdbc.Services.LineInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FileInfoTest{

    public List<LineInfo> lineInfoList = new ArrayList<>();
    public List<String> lineInfoList1 = new ArrayList<>();
    String string = "Создадим в нашем классе приватный объект списка пользователей";
    String string1 = "Создадим класс (и реализуем в нем шаблон Singleton) в пакете model";
    String string2 = "аз уж вы слышали про singleton, значит возможно слышали и про другой шаблон проектирования — MVC";

    @Before
    public void setup(){
        lineInfoList.add(new LineInfo(string));
        lineInfoList.add(new LineInfo(string1));
        lineInfoList.add(new LineInfo(string2));
        lineInfoList1.add(string);
        lineInfoList1.add(string1);
        lineInfoList1.add(string2);
    }

    @Test
    public void findLongestWordTest(){
        Assert.assertEquals("проектирования", new FileInfo(lineInfoList, "test",null).getLongestWord());
        Assert.assertEquals("проектирования", new FileInfo(lineInfoList1, "test").getLongestWord());
    }

    @Test
    public void findLengthOfLongestWordTest(){
        Assert.assertEquals(14, new FileInfo(lineInfoList1, "test").getLengthOfLongestWord());
    }

    @Test
    public void getFileNameTest(){
        Assert.assertEquals("test", new FileInfo(lineInfoList1, "test").getFileName());
    }




}
