import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Naman G
 * @date 6/16/18
 * 
 * Creates the data editing dialog	
 */
public class InputDataDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	//Constructor- creates all the text feilds and buttons
	public InputDataDialog(Appliance appl) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JFormattedTextField frmtdtxtfldApplianceName = new JFormattedTextField();
		frmtdtxtfldApplianceName.setToolTipText("Appliance's name");
		frmtdtxtfldApplianceName.setText("Appliance Name:");
		frmtdtxtfldApplianceName.setBounds(27, 11, 107, 20);
		contentPanel.add(frmtdtxtfldApplianceName);
		
			JFormattedTextField name = new JFormattedTextField();
			name.setEditable(true);
			name.setText(appl.getName());
			name.setBounds(148, 11, 150, 20);
			contentPanel.add(name);
		
			JFormattedTextField hourlyConsumption = new JFormattedTextField();
			hourlyConsumption.setToolTipText("The measured Wattage of the appliance");
			hourlyConsumption.setText("Wattage");
			hourlyConsumption.setBounds(27, 42, 107, 20);
			contentPanel.add(hourlyConsumption);
		
			JFormattedTextField Consumption = new JFormattedTextField();
			Consumption.setEditable(true);
			Consumption.setText(""+appl.getHourlyConsumption());
			Consumption.setBounds(148, 42, 150, 20);
			contentPanel.add(Consumption);
		
			JFormattedTextField frmtdtxtfldQuantity = new JFormattedTextField();
			frmtdtxtfldQuantity.setToolTipText("Quantity of Appliance");
			frmtdtxtfldQuantity.setText("Quantity");
			frmtdtxtfldQuantity.setBounds(27, 73, 107, 20);
			contentPanel.add(frmtdtxtfldQuantity);
		
			JFormattedTextField qty = new JFormattedTextField();
			qty.setText(appl.getQuantity()+"");
			qty.setEditable(true);
			qty.setBounds(148, 73, 150, 20);
			contentPanel.add(qty);
		
			JFormattedTextField TimeOn = new JFormattedTextField();
			TimeOn.setToolTipText("The number of hours the appliance is on in the day");
			TimeOn.setText("Time On");
			TimeOn.setBounds(27, 104, 107, 20);
			contentPanel.add(TimeOn);
		
			JFormattedTextField time = new JFormattedTextField();
			time.setText(appl.getTimeOn()+"");
			time.setEditable(true);
			time.setBounds(148, 104, 150, 20);
			contentPanel.add(time);
		
			JFormattedTextField Type = new JFormattedTextField();
			Type.setToolTipText("Type of Appliance");
			Type.setText("Type");
			Type.setBounds(27, 135, 107, 20);
			contentPanel.add(Type);
		
			JFormattedTextField type = new JFormattedTextField();
			type.setText(appl.getType());
			type.setEditable(true);
			type.setBounds(148, 135, 150, 20);
			contentPanel.add(type);
			
					
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			


				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						appl.setName(name.getText());
						appl.setHourlyConsumption(Double.parseDouble(Consumption.getText()));
						appl.setQuantity(Integer.parseInt(qty.getText()));
						appl.setTimeOn(Double.parseDouble(time.getText()));
						appl.setType(type.getText());
						ClassroomInfoDisplay.indicator=true;
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ClassroomInfoDisplay.indicator=true;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
		
	}
}
