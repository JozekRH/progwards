//Задача 1. Класс ClassInspector
package ru.progwards.java2.lessons.reflection;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TestClass1 {
    // массив с данными для процессинга результата теста
    // 0: идентификатор теста, - имя функции @Test
    // 1: имя теста словами, если == "", то возмется идентификатор
    // 2: баллы за эту часть теста
    // 3: * отмечены обязательные части теста
    private static String[][] testData = {
            // Первая строка [0] содержит данные о всем тесте.
            // Оценка отражает проходной балл
            //       - это информация для утилиты проверки

            {"task1", "Задача 1. Класс ClassInspector", "18", ""},
            {"test1", "Метод inspect(String clazz)", "18", "*"},
    };

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private String dir = TestClass1.class.getProtectionDomain().getCodeSource().getLocation().getPath()
            + "ru/progwards/java2/lessons/reflection/";

    private String filesDir = "/data/test_files/ru.progwards.java2.lessons.reflection/";
    private String pPrefix = "Person.";
    private String pClassName = "ru.progwards.java2.lessons.reflection.Person";




    // Если надо - инициализация и завершение теста
    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void done() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void test1() throws Exception {
        File fileSource = new File(filesDir + pPrefix + "java");
        File fileStruct = new File(filesDir + pPrefix + "struct");
        File fileFrom = new File(filesDir + pPrefix + "class");
        File fileTo = new File(dir + pPrefix + "class");

        String ss = "";
        String rs = "";
        String us = "";

        try {
            ss = FileUtils.readFileToString(fileSource);
            rs = FileUtils.readFileToString(fileStruct);
            Files.copy(fileFrom.toPath(), fileTo.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            Assert.assertTrue("Непредвиденная ошибка, обратитесь к администратору системы: " + e.getMessage(), false);
        }

        ClassInspector.inspect(pClassName);
        us = outContent.toString();
        while (us != null && us.endsWith("\r\n")){
            us = us.substring(0, us.length() - 2);
        }
        while (us != null && us.endsWith("\n")){
            us = us.substring(0, us.length() - 1);
        }

        Assert.assertTrue("Описан класс:\n" + ss +
                "\nМетод вызван с параметром: " + pClassName +
                "\nВыведено на консоль:\n" + us + "\nОжидалось:\n" + rs, rs.equals(us));
    }
}
