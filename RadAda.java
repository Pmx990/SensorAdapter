import sensor.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RadAda implements SensorInter {
    private double val ;
    private String info;
    private String name;
    private RadiationSensor rs;
    RadAda(RadiationSensor rsi){
        rs = rsi;
    }
    /*
    For comments, please check TempAda.java
    The adapters have similar codes.
     */

    @Override
    public void uiPart(UiFunction uf){
        val = rs.getRadiationValue();
        info = rs.getStatusInfo();
        name = rs.getName();
        double lengthOfRad = val*100;

        JPanel  temperaturePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        temperaturePnl.setBorder(new TitledBorder(name));
        uf.setLayout(new GridLayout(3,1));

        JLabel jl = new JLabel();
        jl.setPreferredSize(new Dimension((int)(lengthOfRad), 100));
        jl.setOpaque(true);
        jl.setVisible(true);

        JLabel j2 = new JLabel();
        j2.setText(info + "  "+ val);

        if(val<3){
            jl.setBackground(Color.GREEN);

        }else if(val <= 4){
            jl.setBackground(Color.ORANGE);

        }else if (val >4){
            jl.setBackground(Color.RED);

        }

        temperaturePnl.add(jl);
        temperaturePnl.add(j2);
        uf.add(temperaturePnl);
    }

}
