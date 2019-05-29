import sensor.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;


public class TempAda implements SensorInter {
    private double val ;  //the value of temp
    private String info;  //the
    private String name;
    private TemperatureSensor ts; //init the api
    TempAda(TemperatureSensor tsi){
    ts = tsi;
    }


    @Override
    public void uiPart(UiFunction uf){
        /*
        * Get the info from the sensors,
        *
        * and print them to the UI.
        * */
    val = ts.senseTemperature(); //get the temp from the api
    info = ts.getTempReport();
    name = ts.getSensorType();

    double lengthOfTemp = val*1.4;
    /*
    how long the rectangle that represent the temp, not a meaningful number.

    only use to draw the rectangle.
     */



        JPanel  temperaturePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        temperaturePnl.setBorder(new TitledBorder(name));
        uf.setLayout(new GridLayout(3,1));
        /*the area for temp*/

        JLabel jl = new JLabel();
        jl.setPreferredSize(new Dimension((int)(lengthOfTemp), 100));
        jl.setOpaque(true);
        jl.setVisible(true);
        /*draw the rectangle that represent the temp*/
        JLabel j2 = new JLabel();
        j2.setText(info + "  "+ val);

        if(val<235){    //different colors with different level
            jl.setBackground(Color.GREEN);
        }else if(val <= 300){
            jl.setBackground(Color.ORANGE);

        }else if (val >300){
            jl.setBackground(Color.RED);

        }

        temperaturePnl.add(jl); //add everything to the ui.
        temperaturePnl.add(j2);
        uf.add(temperaturePnl);

    }

}
