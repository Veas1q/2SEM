package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public static void main(String[] args) {
        new DataReader().readFile("C:\\Users\\Redmi\\IdeaProjects\\SecondSemestr\\med.csv");
    }

    public List<RawRow> readFile(String fileName) {
        List<RawRow> result = new ArrayList<>();
        File file = new File(fileName);
        if (!(file.exists() || file.isFile())) return result;


        try (
//                InputStream is = new FileInputStream(file);
//             Reader reader = new InputStreamReader(is);
//             BufferedReader bf = new BufferedReader(reader)
             BufferedReader bf = new BufferedReader(new FileReader(file));

        ) {
            while (bf.ready()) {
//                System.out.println((char) reader.read());
                System.out.println(bf.readLine());
                String[] data = bf.readLine().split(";");
                RawRow raw = new RawRow();
                raw.setRiskScoreCVRM(data[6]);
                raw.setMdrd(data[7]);
                raw.setGlucoseFasting(data[9]);
                raw.setTotalCholestirol(data[11]);
                raw.setSystolicBloodPressure(data[13]);
                raw.setDiastolicBloodPressure(data[14]);
                raw.setBmi(data[16]);
                raw.setPsCVRM(data[18]);
                raw.setSmokingStatus(data[19]);
                raw.setAge(data[22]);
                raw.setHypertention(data[23]);
                result.add(raw);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<Row> clearData(List<RawRow> raw){
        raw.stream().filter(r -> !r.badRecord()).map(r -> new Row()).toList();
    }
    public Row convertor (RawRow raw){
        Row r = new Row();
        r.setRiskScoreCVRM(Integer.parseInt(raw.getRiskScoreCVRM()));
        r.setMdrd(Integer.parseInt(raw.getMdrd()));
        return r;
    }

    public void tree() {
        Node root = new Node();
        Node[] tree = new Node[63];
        for (int i = 0; i < tree.length ; i++) {
            tree[i].setFunction(
                    r -> tree.
            );
        }
    }
}
