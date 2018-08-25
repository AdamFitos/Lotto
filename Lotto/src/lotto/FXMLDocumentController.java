package lotto;

//import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Ádám
 */
import javafx.scene.layout.Pane;


public class FXMLDocumentController implements Initializable {

    //<editor-fold defaultstate="collapsed" desc="class variable">
    
    private final String WIN =("Sajnos nem nyertél semmit!") ;
    private final String WIN1 =("Egy találatosod volt!") ;
    private final String WIN2 =("Két találalatosod volt a lottón!") ;
    private final String WIN3 =("3 találalatosod volt a lottón!") ;
    private final String WIN4 =("4 találalatosod volt a lottón!") ;
    private final String WIN5 =("5 találalatosod volt a lottón!") ;
    private final int MAX = 90;
    private final int MIN = 1;
    private int genNum1 = 0;
    private int genNum2 = 0;
    private int genNum3 = 0;
    private int genNum4 = 0;
    private int genNum5 = 0;
    private int setNum1 = 0;
    private int setNum2 = 0;
    private int setNum3 = 0;
    private int setNum4 = 0;
    private int setNum5 = 0;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="fxml-ek">
    @FXML
    private Label label1;

    @FXML
    private Button alertButton;

    @FXML
    private Label alertText;

    @FXML
    private Pane alertPane;

    @FXML
    private Pane basePane;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField input1;

    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;
//</editor-fold>

 public void generate(){
        genNum1 = 0;
        genNum2 = 0;
        genNum3 = 0;
        genNum4 = 0;
        genNum5 = 0;
        genNum1 = getRandomNumber();
        genNum2 = getRandomNumber();
        genNum3 = getRandomNumber();
        genNum4 = getRandomNumber();
        genNum5 = getRandomNumber();
        
        
 }   
    @FXML
    private void handleAlertButton(ActionEvent event) {

        
        basePane.setDisable(false);
        basePane.setOpacity(1);
        alertPane.setVisible(false);

   }
//    @FXML
//    public void alertEnter(KeyEvent e){
//     
//        if(e.getCode().equals(KeyCode.ENTER)|| basePane.isDisable()==false)
//     
//           basePane.setDisable(false);
//           basePane.setOpacity(1);
//           alertPane.setVisible(false);
//     }
    @FXML
  public void onEnterr(KeyEvent e){
  if(e.getCode().equals(KeyCode.ENTER)){
       generate();
       calculate();
       
  
           
 
  
  }}
      @FXML
  public void onEnterAlert(KeyEvent e){
  if(e.getCode().equals(KeyCode.ENTER)){
  
        basePane.setDisable(false);
        basePane.setOpacity(1);
        alertPane.setVisible(false);
      
  
  
  }}
    @FXML
    private void handleButtonAction(ActionEvent event) {

//        genNum1 = 0;
//        genNum2 = 0;
//        genNum3 = 0;
//        genNum4 = 0;
//        genNum5 = 0;
//        genNum1 = getRandomNumber();
//        genNum2 = getRandomNumber();
//        genNum3 = getRandomNumber();
//        genNum4 = getRandomNumber();
//        genNum5 = getRandomNumber();
        generate();
        calculate();
        
    }

    private void calculate() {
        //Are they numbers?
        try {
            setNum1 = Integer.parseInt(input1.getText());
            setNum2 = Integer.parseInt(input2.getText());
            setNum3 = Integer.parseInt(input3.getText());
            setNum4 = Integer.parseInt(input4.getText());
            setNum5 = Integer.parseInt(input5.getText());
        } catch (Exception a) {

            alert("Nem jó számot adtál meg! ");
            return ;

        }
// Are they between 1 and 99?
//        if (setNum1 < 1 || setNum1 > 99 || setNum2 < 1 || setNum2 > 99 || setNum3 < 1 || setNum3 > 99
//                || setNum4 < 1 || setNum4 > 99 || setNum5 < 1 || setNum5 > 99) {
//
//            alert("A számnak 1 és 99 között kell lennie. ");
//            return "";
//
//        }

        HashSet<Integer> selectedNumber = new HashSet<>();
        selectedNumber.add(setNum1);
        selectedNumber.add(setNum2);
        selectedNumber.add(setNum3);
        selectedNumber.add(setNum4);
        selectedNumber.add(setNum5);
        
        if (selectedNumber.size() < 5) {

            alert("A számoknak különbözőnek kell lenniük.");
            return ;

            }
        
        ArrayList<Integer>userNumbers = new ArrayList<>(selectedNumber);
        
        
        for(Integer number:userNumbers){
            
        if(number<MIN || number > MAX){
           
             alert("A számnak 1 és 90 között kell lennie. ");
            return ;

        }}
        label1.setText(String.valueOf(genNum1));
        label2.setText(String.valueOf(genNum2));
        label3.setText(String.valueOf(genNum3));
        label4.setText(String.valueOf(genNum4));
        label5.setText(String.valueOf(genNum5));
        
// Are they different numbers?
        
        

        resultCheck(userNumbers);
//        System.out.println(userNumbers);
    }
private void resultCheck(ArrayList<Integer>userNumbers){
        resultLabel.setText(WIN);
        int result = 0;

        for (int i = 0; i < userNumbers.size(); i++) {

            if (userNumbers.get(i) == genNum1 || userNumbers.get(i) == genNum2 || userNumbers.get(i) == genNum3
                    || userNumbers.get(i) == genNum4 || userNumbers.get(i) == genNum5) 
                result++;
            }
            switch (result) {

                case 0:
                    resultLabel.setText(WIN);
                    
                    break;
                case 1:
                    resultLabel.setText(WIN1);
                    System.out.println("lefut");
                    break;
                case 2:
                    resultLabel.setText(WIN2);
                    break;
                case 3:
                    resultLabel.setText(WIN3);
                    break;
                case 4:
                    resultLabel.setText(WIN4);
                    break;
                case 5:
                    resultLabel.setText(WIN5);
                    break;

            }
       




}
    private void alert(String text) {
        basePane.setDisable(true);
        basePane.setOpacity(0.3);
        alertPane.setVisible(true);
        alertText.setText(text);

        
    return;}

    private int getRandomNumber() {

        int random = (int) (Math.random() * MAX) + MIN;

//    Random randm = new Random();
//    int max = 100;
//    int min = 1;
//    int randomNum = randm.nextInt((max-min)+1)+min ;
//    
        if (random == genNum1 || random == genNum2 || random == genNum3 || random == genNum4 || random == genNum5) {

            return getRandomNumber();
        }
        return random;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
