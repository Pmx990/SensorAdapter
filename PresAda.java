import sensor.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PresAda implements SensorInter {
    private double val ;
    private String info;
    private String name;
    private PressureSensor ps;
    PresAda(PressureSensor psi){
        ps = psi;
    }
    /*
    For comments, please check TempAda.java
    The adapters have similar codes.
     */

    @Override
    public void uiPart(UiFunction uf){
        val = ps.readValue();
        info = ps.getReport();
        name = ps.getSensorName();
        double lengthOfPre = val*60;


        JPanel  temperaturePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        temperaturePnl.setBorder(new TitledBorder(name));
        uf.setLayout(new GridLayout(3,1));

        JLabel jl = new JLabel();
        jl.setPreferredSize(new Dimension((int)(lengthOfPre), 100));
        jl.setOpaque(true);
        jl.setVisible(true);

        JLabel j2 = new JLabel();
        j2.setText(info + "  "+ val);

        if(val<5){
            jl.setBackground(Color.GREEN);

        }else if(val <= 6.58){
            jl.setBackground(Color.ORANGE);

        }else if (val >6.58){
            jl.setBackground(Color.RED);
        }

        temperaturePnl.add(jl);
        temperaturePnl.add(j2);
        uf.add(temperaturePnl);

    }

}
