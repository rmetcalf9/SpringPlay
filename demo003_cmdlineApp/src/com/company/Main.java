package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private String path;

    public Main(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }


    public void testZip() {
        List<String> a = Arrays.asList("a", "b", "c");
        List<String> b = Arrays.asList("x", "y", "z");

        List<String> c = IntStream
                .range(0,3)
                .boxed()
                .map(x -> a.get(x) + ":" + b.get(x))
                .collect(Collectors.toList());

        List<String> d = a.stream()
                .flatMap(str1 -> b.stream().map(str2 -> str1 + ":" + str2))
                .collect(Collectors.toList());

        System.out.print("a=");
        System.out.println(a.toString());
        System.out.print("b=");
        System.out.println(b.toString());
        System.out.print("c=");
        System.out.println(c.toString());
        System.out.print("d=");
        System.out.println(d.toString());
    }

    public void cd(String newPath) {
        //TODO Validate path

        if (newPath.startsWith("/")) {
            path = newPath;
            System.out.println(path);
            return;
        }

        //String[] curPath = path.split("/");
        //List<String> xx = new ArrayList<String>();
        //for (int c=0;c<curPath.length;c++) {
        //    xx.add(curPath[c]);
        //}

        List<String> xx = Arrays.stream(path.split("/")).map(s -> s).collect(Collectors.toList());

        String[] newPathList = newPath.split("/");
        for (int c=0;c<newPathList.length;c++) {
            String ccc = newPathList[c];
            if (ccc.equals("..")) {
                xx.remove(xx.size()-1);
            } else {
                xx.add(ccc);
            }
        }

        path = "";
        for (int c=0;c<xx.size();c++) {
            if (c != 0) path = path + "/";
            path = path + xx.get(c);
        }
    }

    public static void main(String[] args) {
        Main path = new Main("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
        System.out.println("---");
        path.testZip();
        System.out.println("---");
    }
}