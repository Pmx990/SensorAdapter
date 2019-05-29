import sensor.PressureSensor;
import sensor.RadiationSensor;
import sensor.TemperatureSensor;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
/*
* CS410
* Dr. Sara
* Junzhe Liang
*
*
* This program is designed to access three sensors with only api using adapter
* design pattern.
*
*
* The UiFunction.java provide the Ui of the program
*

*
*
*
* */


public class UiFunction extends JFrame {
    /*
    * generate the ui
    * provide the extended JFrame to the adapters.
    * */
    ArrayList<ArrayList> al = new ArrayList<>();
    public UiFunction() {
        setTitle("Sensor Tracker 2019 Prime Edition");

        setPreferredSize(new Dimension(600,600));
        //Set the windows size of the program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        UiFunction app = new UiFunction();
        TemperatureSensor ts = new TemperatureSensor();
        PressureSensor ps = new PressureSensor();
        RadiationSensor rs = new RadiationSensor();
        //initialize the apis

        //----------------------------------------------------------------------
        TempAda ta = new TempAda(ts);
        ta.uiPart(app);
        PresAda pa = new PresAda(ps);
        pa.uiPart(app);
        RadAda ra = new RadAda(rs);
        ra.uiPart(app);
        //apply the adapters.
        //-----------------------------------------------------------------------


        app.pack();
    }

}
