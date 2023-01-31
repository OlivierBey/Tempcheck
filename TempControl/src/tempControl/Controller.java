package tempControl;



import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controller {
	String input ;
	Double inputDouble,c,f,k;
	int jumper = 0;
	
	 @FXML
	    void ConvertClick(ActionEvent event) {
		 try {
			 input= txtTemp.getText();
			 inputDouble= Double.parseDouble(input);
			 
			 switch (jumper){
				case 1: {
					setCel();
					break;
					}
				case 2:{
					System.out.println("stap2");
					setFar();
					break;
				}
				case 3:{
					setKel();
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + jumpRadiobutton);
				}
			 
			 
		} catch (Exception e) {
			txtTemp.setText("");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Enkel getallen toegelaten!");
			alert.setTitle("Verkeerde input");
			alert.showAndWait();
			}
		}

    private void setKel() {
		System.out.println("kelvin");

    	k= inputDouble;
		c= k-273.15;
		f= c*1.8+32;
		printlabel(c,f,k);
	}

	private void printlabel(Double c2, Double f2, Double k2) {
		System.out.println("stap4");
		System.out.println(c2+"  "+f2+"  "+k2);
		DecimalFormat decfor = new DecimalFormat("0.0");
		lblCelsius.setText(decfor.format(c2)+" °C");
		lblFahrenheit.setText(decfor.format(f2)+" °F");
		lblKelvin.setText(decfor.format(k2)+" °K");
		
	}

	private void setFar() {
		System.out.println("stap3  "+f);
		f= inputDouble;
		System.out.println("stap3  "+f);
		c=(f-32)/1.8;
		k = c+273.15;
		printlabel(c,f,k);
	}

	private void setCel() {
		System.out.println("celsius");

		c= inputDouble;
		f=c*1.8+32;
		k=c+273.15;
		printlabel(c,f,k);
	}

	@FXML
    private Button btnConvert;

    @FXML
    private ToggleGroup jumpRadiobutton;

    @FXML
    private Label lblCelsius;

    @FXML
    private Label lblFahrenheit;

    @FXML
    private Label lblKelvin;

    @FXML
    private RadioButton rbCelsius;

    @FXML
    private RadioButton rbFahrenheit;

    @FXML
    private RadioButton rbKelvin;

    @FXML
    private TextField txtTemp;

    @FXML
    void CelsiusClick(ActionEvent event) {
    	jumper = 1;
    }

    @FXML
    void FahrenheitClick(ActionEvent event) {
    	jumper = 2;
    }

    @FXML
    void KelvinClick(ActionEvent event) {
    	jumper =3;
    }

}
