/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Presentacio;

/**
 *
 * @author wenqi
 */
public class Presentacio {
    private static CtrlPresentacio presentacio;
    
    public static void main(String[] args) {
        presentacio = new CtrlPresentacio();
        CtrlPresentacio.iniPresentacion();
    }
}
