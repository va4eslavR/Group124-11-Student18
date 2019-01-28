package com.company;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    //конвертация  изображений MNIST в массив int
    public static int[] conver(byte[] a, int Startpoint) {
        int[] imagesIntArray = new int[a.length - Startpoint];
        for (int i = 16; i < a.length - 1; i++
        ) {
            imagesIntArray[i - 16] = a[i] & 0xFF;
        }
        System.out.println(imagesIntArray.length);
        return imagesIntArray;
    }
    //конец метода

    //перегруженный метод заполнения коллекций ImageSolver
    public static ArrayList<ImageSolver> toImageSolverList(byte[]a,int[]b,int separator, int startOfA) {
        ArrayList<ImageSolver> imageSolverArrayList = new ArrayList<>();
        for (int i = 0; i < b.length /separator; i++) {

            int temp[] = new int[separator];
            for (int j = 0; j < separator; j++) {
                temp[j] = b[j + i * separator];
            }

            imageSolverArrayList.add(new ImageSolver(temp, a[i + startOfA]));
        }
        return imageSolverArrayList;

    }


    public static void main(String[] args) {
        try {


            byte[] images = IOUtils.toByteArray(new FileInputStream(new File("D:\\Java folder\\Image\\train-images.idx3-ubyte")));
            byte[] images1 = IOUtils.toByteArray(new FileInputStream(new File("D:\\Java folder\\Image\\t10k-images.idx3-ubyte")));
            int[] imagesIntLearn = conver(images, 16);
            int[] imagesIntTest = conver(images1, 16);
            byte[] labels = IOUtils.toByteArray(new FileInputStream(new File("D:\\Java folder\\Image\\train-labels.idx1-ubyte")));
            byte[] labelsTest = IOUtils.toByteArray(new FileInputStream(new File("D:\\Java folder\\Image\\t10k-labels.idx1-ubyte")));
            ArrayList<ImageSolver>Learning=toImageSolverList(labels,imagesIntLearn,784,8);
            ArrayList<ImageSolver>Checking=toImageSolverList(labelsTest,imagesIntTest,784,8);

            System.out.println(Learning.size());
            System.out.println(Checking.size());




            byte[]Neigh={3};

            /*Teacher one=new Teacher(Neigh);
            one.ProductiveNeighbors(Checking,Learning);*/


            combinedTeacher two=new combinedTeacher(Neigh);
            two.ProductiveNeighbors(Checking,Learning);



        } catch (IOException ioException) {
        }

    }

}
