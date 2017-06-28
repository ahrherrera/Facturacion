
package Validations;

import java.awt.event.KeyEvent;

/*@author Jairo Martinez*/
public class ValidateText {
    
    public static void Letters(KeyEvent a)
    {
        char c = a.getKeyChar();    
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c!=(char)KeyEvent.VK_SPACE))
        {
            a.consume();
        }
    }
    //KeyTyped = KeyEvent se genera cuando se valida un codigo para luego ser inicializado o utilizado.
    // regitra y recive eventos usando componentes como ¨addKeyListener¨
    
    public static void Numbers(KeyEvent evt){
        char c = evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
    }
    
    public static void Decimals(KeyEvent evt){
        char c = evt.getKeyChar();
        if(((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)&& (c !='.')){
        /*ya existe el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
        }
    }
    
    public static void taza(KeyEvent evt, String s)
    {
        char car = evt.getKeyChar();
        if(s.length()>=2){
            evt.consume();
        }
        if((car<'0' || car>'9')){
            evt.consume();
        }
    }
}
