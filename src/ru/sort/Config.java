package ru.sort;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Config {
    static boolean isNumber;
    static boolean isAscending=true;
    static String outFile=null;
    static final List<String> files=new LinkedList<>();

    public static void init(String[] args){

        for (int i=0;i<args.length;i++) {

            if (args[i].equals("-a")) ru.sort.Config.isAscending=true;
            if (args[i].equals("-d")) Config.isAscending=false;

            if(args[i].equals("-s")) Config.isNumber=false;
            if(args[i].equals(("-i"))) Config.isNumber=true;

            if(args[i].contains(".txt") && Config.outFile==null){
                Config.outFile=args[i];
            }else if (args[i].contains(".txt")){
                Config.files.add(args[i]);
            }
        }

    }

}
