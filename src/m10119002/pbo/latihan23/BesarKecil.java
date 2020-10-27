/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m10119002.pbo.latihan23;

import java.util.Scanner;

/**
 *
 * @author
 * NAMA     : Firman Sahita
 * KELAS    : IF-1
 * NIM      : 10119002
 * Deskripsi Program : Program ini berisi program nilai terbesar dan terkecil
 * 
 * 
 */
public class BesarKecil {
    private final Scanner scanner;
    public BesarKecil() {scanner = new Scanner(System.in);}
    
    private String getInput() {return scanner.nextLine();}
    
    private Integer getInteger(String test) {
        Integer temp;
        try {
            temp = Integer.parseInt(test);
        } catch (NumberFormatException ex) {
            System.err.println("Gagal proses, pastikan tidak ada titik, koma"
                    + ", apalagi huruf atau simbol!");
            return null;
        } catch (Exception ex) {
            System.err.println("Gagal proses!");
            return null;
        }
        return temp;
    }
    
    // variables
    private String namaPetugas;
    private int banyakMhs;
    private int[] dataMhs;
    private int terbesar;
    private int terkecil;
    
    
    private boolean inputDataPetugas() {
        String input;
        System.out.println("=====Program Nilai Terbesar dan Terkecil Nilai Mahasiswa=====");
        System.out.print("Masukkan Nama Petugas : ");
        input = getInput();
        namaPetugas = input;
        System.out.print("Masukkan Banyaknya Nilai Mahasiswa : ");
        input = getInput();
        if(getInteger(input)!=null) banyakMhs = getInteger(input);
        else return false;
        return true;
    }
    
    private boolean inputDataMahasiswa() {
        String input;
        dataMhs = new int[banyakMhs];
        
        for (int i=0; i<banyakMhs; i++) {
            System.out.print("Masukkan Nilai Mahasiswa Ke-".
                    concat(Integer.toString(i+1)).concat(" = "));
            input = getInput();
            if(getInteger(input)!=null) dataMhs[i] = getInteger(input);
            else return false;
        }
        System.out.println("");
        return true;
    }
    
    private boolean tampilHasil() {
        terbesar = dataMhs[1];
        terkecil = dataMhs[1];
        
        System.out.println("=====Hasil Nilai Mahasiswa=====");
        for (int i=0; i<banyakMhs; i++) {
            System.out.println("Nilai Mahasiswa Ke-".
                    concat(Integer.toString(i+1)).concat(" = ").
                    concat(Integer.toString(dataMhs[i])));
            if(dataMhs[i] > terbesar) terbesar = dataMhs[i];
            if(dataMhs[i] < terkecil) terkecil = dataMhs[i];
        }
        System.out.println("");
        
        System.out.println("Nilai Terbesar adalah ".
                concat(Integer.toString(terbesar)));
        System.out.println("Nilai Terkecil adalah ".
                concat(Integer.toString(terkecil)));
        System.out.println("");
        
        System.out.println("Petugas : ".concat(namaPetugas));
        return true;
    }
    
    private int start() {
        if(!inputDataPetugas()) return -1;
        if(!inputDataMahasiswa()) return -1;
        if(!tampilHasil()) return -1;
        
        return 0;
    }
    
    public static void main(String[] args) {
        BesarKecil program = new BesarKecil();
        program.start();
    }
}
