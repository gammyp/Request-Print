/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintShop;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author Lenovo
 */
public class Test {

    public static void main(String args[]) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringTokenizer stk = new StringTokenizer(sdf.format(date), "-");
        
        AddBookToManageBook addbook = new AddBookToManageBook();
        System.out.println(""+addbook.monthSpinner.getValue());
        System.out.println(addbook.getMonth());
    }

}
