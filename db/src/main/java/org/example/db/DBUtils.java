package org.example.db;

import org.example.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static final String TABLE = "C:\\Users\\Redmi\\IdeaProjects\\SecondSemestr\\db\\src\\main\\java\\org\\example\\db/students.tbl";

    public static void appendObject(Student student){
        byte[] studentData = null;
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos)){
            oos.writeObject(student);
            studentData = bos.toByteArray();
        }catch(IOException e){
            throw new RuntimeException();
        }
        File file = new File(TABLE);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            dos.writeInt(student.getId());
            dos.writeByte(1);
            dos.writeInt(studentData.length);
            dos.write(studentData);
            dos.flush();
        }catch (IOException E){
            throw new RuntimeException();
        }

    }
    public static List<Student> readAll(){
        List<Student> result = new ArrayList<>();
        File file = new File(TABLE);
        if(!file.exists()){
            return null;
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            while(true){
                int id = dis.readInt();
                byte flag = dis.readByte();
                int size = dis.readInt();
                byte[] data = new byte[size];
                dis.read(data);
                if (flag == 1){
                    try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))){
                        Student student = (Student) ois.readObject();
                        result.add(student);
                    }
                }
            }
        }catch (EOFException e){}
        catch(IOException | ClassNotFoundException e){
            throw new RuntimeException();
        }


        return result;
    }
    public static void editStudent(Student student){

    }
    public static long findPosition(int id){
        long position = 0;
        File file = new File(TABLE);
        if(!file.exists()){
            return -1;
        }
        try(DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            while (true){
                int id = dis.readInt();
                byte flag = dis.readByte();
                int size = dis.readInt();
                dis.skipBytes(size);
                if (flag == 1 && id == serchId){
                    serchFlag = true;
                    break
                }
            }
        }
        return position;

    }
}
