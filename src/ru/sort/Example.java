package ru.sort;


import java.io.*;

public class Example {

   static private void merge() throws IOException{

        String[] f = new String[Config.files.size()+1];
        BufferedWriter out = new BufferedWriter(new FileWriter("../files/"+Config.outFile));
        BufferedReader[] in = new BufferedReader[Config.files.size()+1];
        FileInputStream file;
        for(int i=0;i<Config.files.size();i++) {
            file = new FileInputStream("../files/" + Config.files.get(i));
            in[i] = new BufferedReader(new InputStreamReader(file));
            f[i]=in[i].readLine();
        }

        while (true)
        {
            if (f[0]==null) {
                out.write(f[1]);
                f[1]=in[1].readLine();
            }
            else if (f[1]==null){
                out.write(f[0]);
                f[0]=in[0].readLine();
            }
            else if (Integer.parseInt(f[0])<Integer.parseInt(f[1]))
            {
                out.write(f[0]);
                f[0]=in[0].readLine();
            }else {
                out.write(f[1]);
                f[1]=in[1].readLine();
            }

            if((f[0]==null) && (f[1]==null)) {
                break;
            }
            out.write("\n");
        }

        for(int i=0;i<Config.files.size();i++)
            in[i].close();
        out.close();
    }

    public static void main(String[] args) throws IOException {

//        sort-it.exe -i -a out.txt in.txt (для целых чисел по возрастанию)
//        sort-it.exe -s out.txt in1.txt in2.txt in3.txt (для строк по возрастанию)
//        sort-it.exe -d -s out.txt in1.txt in2.txt (для строк по убыванию)
//        1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
//        2. тип данных (-s или -i), обязательный;
//        3. имя выходного файла, обязательное;
//        4. остальные параметры – имена входных файлов, не менее одного.

        switch (args.length){
            case 0,1,2:
                System.out.println("Error!");
                return;
            case 3,4,5: {
                Config.init(args);
                try {
                    merge();
                }catch (Exception e){

                }

                break;
            }
            default: break;
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

        System.out.println(Config.isAscending);
        System.out.println(Config.isNumber);
        System.out.println(Config.outFile);
        for(String s:Config.files){
            System.out.println(s);
        }
    }
}

