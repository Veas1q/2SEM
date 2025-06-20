package org.example.db;

import org.example.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class DBUtils {
    public static final String TABLE = "db/student.tbl";
    private static final TreeMap<Integer, Long> idToPosition = new TreeMap<>();
    static {
        loadIndex(); // Загружаем индекс при старте
    }

    // Загрузка индекса из файла
    private static void loadIndex() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("student.idx"))) {
            while (dis.available() > 0) {
                idToPosition.put(dis.readInt(), dis.readLong());
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения индекса", e);
        }
    }

    // Сохранение индекса в файл
    public static void saveIndex() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.idx"))) {
            for (Map.Entry<Integer, Long> entry : idToPosition.entrySet()) {
                dos.writeInt(entry.getKey());
                dos.writeLong(entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка сохранения индекса", e);
        }
    }

    public static void updateStudent(Student student){
        if (idToPosition.containsKey(student.getId())){
            deleteStudent(student.getId());
        }
        appendObject(student);

    }

    public static void deleteStudent(int id)  {
        if (!idToPosition.containsKey(id)){
            return;
        }
        long pos = idToPosition.get(id);
        File file = new File(TABLE);
        try(RandomAccessFile raf = new RandomAccessFile(file, "rw")){
            raf.seek(pos + 4);
            raf.write(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        idToPosition.remove(id);
        saveIndex();
    }

    public static Student getStudent(int id){
        if (!idToPosition.containsKey(id)){
            return null;
        }
        long pos = idToPosition.get(id);
        File file = new File(TABLE);
        Student student;
        try(RandomAccessFile raf = new RandomAccessFile(file, "r")){
            raf.seek(pos);
            raf.skipBytes(4 + 1);
            int size = raf.readInt();
            byte[] data = new byte[size];
            raf.read(data);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
             student = (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    private static void setTreeMap(){
        File file = new File(TABLE);
        if (!file.exists()){
            return;
        }
        long position = 0;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (dis.available() > 0) {
                int nowId = dis.readInt();
                byte flag = dis.readByte();
                int size = dis.readInt();
                dis.skipBytes(size);
                if (flag == 1){
                    idToPosition.put(nowId, position);
                }
                position += 4 + 1 + 4 + size;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void appendObject(Student student) {

        if (!idToPosition.containsKey(student.getId())) {

            // сериализация student
            byte[] studentData = null;

            try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 ObjectOutputStream oos = new ObjectOutputStream(bos)) {
                oos.writeObject(student);
                studentData = bos.toByteArray();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            File file = new File(TABLE);
            long position = file.length();
            try (DataOutputStream dos =
                         new DataOutputStream(new FileOutputStream(file, true))) {
                dos.writeInt(student.getId());
                dos.writeByte(1);
                dos.writeInt(studentData.length);
                dos.write(studentData);
                dos.flush();
                idToPosition.put(student.getId(), position);
            } catch (IOException e) {
                throw new RuntimeException("Не удалось записать данные");
            }
            saveIndex();
        }else{
            System.out.println("Уже существует студент с таким ID");

        }

    }

    public static List<Student> readAll() {
        List<Student> result = new ArrayList<>();
        File file = new File(TABLE);
        if (!file.exists()) {
            return null;
        }
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(file))) {
            while (true) {
                int id = dis.readInt();
                byte flag = dis.readByte();
                int size = dis.readInt();
                byte[] data = new byte[size];
                dis.read(data);
                if (flag == 1) {
                    try (ObjectInputStream ois = new ObjectInputStream(
                            new ByteArrayInputStream(data)
                    )) {
                        Student student = (Student) ois.readObject();
                        result.add(student);
                    }
                }
            }
        } catch (EOFException e) {}
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

//    public static long findPosition(int searchId) {
//        long position = 0;
//        boolean searchFlag = false;
//        // читаем файл, пока не найдем нужный id
//        File file = new File(TABLE);
//        if (!file.exists()) {
//            return -1;
//        }
//        try (DataInputStream dis = new DataInputStream(
//                new FileInputStream(file))) {
//            while (true) {
//                int id = dis.readInt();
//                byte flag = dis.readByte();
//                int size = dis.readInt();
//                dis.skipBytes(size);
//                if (flag == 1 && id == searchId) {
//                    searchFlag = true;
//                    break;
//                }
//                position += 4 + 1 + 4 + size;
//            }
//        } catch (EOFException e) {}
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        if (searchFlag)
//            return position;
//        else
//            return -1;
//    }

    public static void saveHtmlFile() {
        try (PrintWriter writer = new PrintWriter("students.html")) {
            // Записываем весь HTML одним куском
            String html = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head><meta charset='UTF-8'></head>\n" +
                    "<body>\n" +
                    "<h1>Список студентов</h1>\n" +
                    "<table border='1'>\n" +
                    "<tr><th>ID</th><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>Группа</th></tr>\n";

            // Добавляем строки таблицы
            List<Student> students = readAll();
            if (students != null) {
                for (Student student : students) {
                    html += "<tr>" +
                            "<td>" + student.getId() + "</td>" +
                            "<td>" + student.getLastName() + "</td>" +
                            "<td>" + student.getName() + "</td>" +
                            "<td>" + student.getFatherName() + "</td>" +
                            "<td>" + student.getGroup() + "</td>" +
                            "</tr>\n";
                }
            }

            // Закрываем HTML-теги
            html += "</table>\n" +
                    "</body>\n" +
                    "</html>";

            // Записываем весь HTML в файл
            writer.print(html);

        } catch (IOException e) {
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }



    public static void editStudent(Student student) {
        long position = idToPosition.get(student.getId());
        // Меняем 1 байт в файле
        File file = new File(TABLE);
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(position + 4);
            raf.write(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        appendObject(student);
    }

}