package ru.sort;


import java.io.*;

public class Example {


    static private BufferedReader[] getReaders() throws IOException {
        BufferedReader[] in = new BufferedReader[Config.files.size()];
        FileInputStream file;
        for (int i = 0; i < Config.files.size(); i++) {
            file = new FileInputStream("./files/" + Config.files.get(i));
            in[i] = new BufferedReader(new InputStreamReader(file));
        }
        return in;
    }

    static private boolean isNumeric(String str) {

        try {
            return str.matches("-?\\d+(\\.\\d+)?");
        }
        catch (NullPointerException e){
            return true;
        }
    }



    static private void merge(BufferedReader[] in, BufferedWriter out) throws IOException {

        String[] f = new String[Config.files.size()];
        for (int i = 0; i < Config.files.size(); i++) {
            f[i] = in[i].readLine();
        }

        while (true) {


            if(!isNumeric(f[0])) {
                f[0]=in[0].readLine();
                continue;
            }
            if(!isNumeric(f[1])) {
                f[1]=in[1].readLine();
                continue;
            }

            if (f[0] == null) {
                out.write(f[1]);
                f[1] = in[1].readLine();
            } else if (f[1] == null) {
                out.write(f[0]);
                f[0] = in[0].readLine();
            } else if (Integer.parseInt(f[0]) < Integer.parseInt(f[1])) {
                out.write(f[0]);
                f[0] = in[0].readLine();
            } else {
                out.write(f[1]);
                f[1] = in[1].readLine();
            }

            if ((f[0] == null) && (f[1] == null)) {
                break;
            }
            out.write("\n");
        }

        for (int i = 0; i < Config.files.size(); i++) {
            in[i].close();
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {

        args = new String[5];
        args[0] = "-i";
        args[1] = "-a";
        args[2] = "out.txt";
        args[3] = "file1.txt";
        args[4] = "file2.txt";

        System.out.println("vot");
        System.out.println(isNumeric("242"));
        System.out.println(isNumeric("22./442f"));

//        sort-it.exe -i -a out.txt in.txt (для целых чисел по возрастанию)
//        sort-it.exe -s out.txt in1.txt in2.txt in3.txt (для строк по возрастанию)
//        sort-it.exe -d -s out.txt in1.txt in2.txt (для строк по убыванию)
//        1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
//        2. тип данных (-s или -i), обязательный;
//        3. имя выходного файла, обязательное;
//        4. остальные параметры – имена входных файлов, не менее одного.
            switch (args.length) {
                case 0, 1, 2:
                    System.out.println("Error!");
                    return;
                case 3, 4, 5: {
                    Config.init(args);
                    BufferedWriter out = new BufferedWriter(new FileWriter("./files/"+Config.outFile));
                    BufferedReader[] in = getReaders();
                    merge(in,out);
                    break;
                }
                default:
                    break;
            }


//        while (true)
//        {
//            if (f1==null) {
//                out.write(f2);
//                f2=in2.readLine();
//            }
//            else if (f2==null){
//                out.write(f1);
//                f1=in1.readLine();
//            }
//            else if (Integer.parseInt(f1)<Integer.parseInt(f2))
//            {
//                out.write(f1);
//                f1=in1.readLine();
//            }else {
//                out.write(f2);
//                f2=in2.readLine();
//            }
//
//            if((f1==null) && (f2==null)) {
//                break;
//            }
//            out.write("\n");
//        }

//        System.out.println(Config.isAscending);
//        System.out.println(Config.isNumber);
//        System.out.println(Config.outFile);
//        for(String s:Config.files){
//            System.out.println(s);
//        }
        }
    }


