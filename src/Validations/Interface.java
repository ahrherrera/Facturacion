package Validations;

import java.util.List;

/*@author Jairo Martinez
 */
public interface Interface {
    
    void ClearFields();
    void EnableFields(boolean option);
    void LoadTable();
    void LoadFields();
    void Reset();
    void EnableButtoms(boolean option);
    
    boolean isValidate();
    
    
}
