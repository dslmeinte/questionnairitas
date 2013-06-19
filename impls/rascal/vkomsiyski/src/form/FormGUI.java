/*
 * DO NOT EDIT THIS FILE
 * THIS FILE IS AUTOMATICALLY GENERATED
 */
 
package form;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import org.json.simple.*;
import java.util.*;
import java.io.*;

public class FormGUI extends QWidget {

	List<QLabel> labels = new ArrayList<QLabel>();
 	Map<QLabel, Boolean> visibilityMap = new HashMap<QLabel, Boolean>();
	QLabel hasBoughtHouseLabel = new QLabel("Did you by a house in 2010?");
	QCheckBox hasBoughtHouseWidget = new QCheckBox();
	QLabel valueResidueLabel = new QLabel("Value residue:");
	QDoubleSpinBox valueResidueWidget = new QDoubleSpinBox();
	QLabel sellingPriceLabel = new QLabel("Price the house was sold for:");
	QSpinBox sellingPriceWidget = new QSpinBox();
	QLabel dummyLabel = new QLabel("heyyo");
	QSpinBox dummyWidget = new QSpinBox();
	QLabel privateDebtLabel = new QLabel("Private debts for the sold house:");
	QDoubleSpinBox privateDebtWidget = new QDoubleSpinBox();
	QLabel overLabel = new QLabel("You are at least 18 yo");
	QCheckBox overWidget = new QCheckBox();
	QLabel DateQLabel = new QLabel("Enter your birthday:");
	QDateEdit DateQWidget = new QDateEdit();
	QLabel hasSoldHouseLabel = new QLabel("Did you sell a house in 2010?");
	QCheckBox hasSoldHouseWidget = new QCheckBox();
	QLabel hasMaintLoanLabel = new QLabel("Did you enter a loan for maintenance/reconstruction?");
	QCheckBox hasMaintLoanWidget = new QCheckBox();

	public static void main(String args[]) {
		QApplication.initialize(args);
	    FormGUI formGUI = new FormGUI();
	    formGUI.move(200, 200);
	    formGUI.show();
	    //formGUI.setFixedWidth(formGUI.width());
	    QApplication.exec();
	}	

	public FormGUI() {
	 	QGridLayout layout = new QGridLayout();
	 	setLayout(layout);
	 	QPushButton submitButton = new QPushButton("Submit");
	 	submitButton.clicked.connect(this, "onClicked()");

		setWindowTitle("asst1");
		hasSoldHouseWidget.setChecked(false);
		hasSoldHouseWidget.toggled.connect(this, "onChanged(boolean)");
		hasSoldHouseLabel.setBuddy(hasSoldHouseWidget);
		labels.add(hasSoldHouseLabel);
		hasSoldHouseWidget.setEnabled(true);
		visibilityMap.put(hasSoldHouseLabel, (true));
		hasBoughtHouseWidget.setChecked(false);
		hasBoughtHouseWidget.toggled.connect(this, "onChanged(boolean)");
		hasBoughtHouseLabel.setBuddy(hasBoughtHouseWidget);
		labels.add(hasBoughtHouseLabel);
		hasBoughtHouseWidget.setEnabled(true);
		visibilityMap.put(hasBoughtHouseLabel, (true));
		hasMaintLoanWidget.setChecked(false);
		hasMaintLoanWidget.toggled.connect(this, "onChanged(boolean)");
		hasMaintLoanLabel.setBuddy(hasMaintLoanWidget);
		labels.add(hasMaintLoanLabel);
		hasMaintLoanWidget.setEnabled(true);
		visibilityMap.put(hasMaintLoanLabel, (true));
		dummyWidget.setValue(0);
		dummyWidget.valueChanged.connect(this, "onChanged(int)");
		dummyLabel.setBuddy(dummyWidget);
		labels.add(dummyLabel);
		dummyWidget.setEnabled(true);
		visibilityMap.put(dummyLabel, (true));
		sellingPriceWidget.setValue(0);
		sellingPriceWidget.valueChanged.connect(this, "onChanged(int)");
		sellingPriceLabel.setBuddy(sellingPriceWidget);
		labels.add(sellingPriceLabel);
		sellingPriceWidget.setEnabled(true);
		visibilityMap.put(sellingPriceLabel, ((true)&&(hasSoldHouseWidget.isChecked())));
		privateDebtWidget.setValue(0.0);
		privateDebtWidget.valueChanged.connect(this, "onChanged(double)");
		privateDebtLabel.setBuddy(privateDebtWidget);
		labels.add(privateDebtLabel);
		privateDebtWidget.setEnabled(true);
		visibilityMap.put(privateDebtLabel, ((true)&&(hasSoldHouseWidget.isChecked())));
		valueResidueWidget.setValue(((sellingPriceWidget.value())-(privateDebtWidget.value())));
		valueResidueWidget.valueChanged.connect(this, "onChanged(double)");
		valueResidueLabel.setBuddy(valueResidueWidget);
		labels.add(valueResidueLabel);
		valueResidueWidget.setEnabled(false);
		visibilityMap.put(valueResidueLabel, ((true)&&(hasSoldHouseWidget.isChecked())));
		DateQWidget.setDate(new QDate(2000, 1, 1));
		DateQWidget.setDisplayFormat("d MMMM yyyy"); 
		DateQWidget.setCalendarPopup(true); 
		DateQWidget.dateChanged.connect(this, "onChanged(QDate)");
		DateQLabel.setBuddy(DateQWidget);
		labels.add(DateQLabel);
		DateQWidget.setEnabled(true);
		visibilityMap.put(DateQLabel, (true));
		overWidget.setChecked(((DateQWidget.date()).daysTo(new QDate(1994, 1, 28))>=0));
		overWidget.toggled.connect(this, "onChanged(boolean)");
		overLabel.setBuddy(overWidget);
		labels.add(overLabel);
		overWidget.setEnabled(false);
		visibilityMap.put(overLabel, (true));	 
		int labelMinWidth = 0, widgetMinWidth = 0;	
	 	for (int i = 0; i < labels.size(); i++) {
	 		labels.get(i).setVisible(true);
			labels.get(i).buddy().setVisible(true);
	 		layout.addWidget(labels.get(i), i, 0,  Qt.AlignmentFlag.AlignRight);
	 		layout.addWidget(labels.get(i).buddy(), i, 1);
			if (labels.get(i).width() > labelMinWidth) 
	 			labelMinWidth = labels.get(i).width();
	 		if (labels.get(i).buddy().width() > widgetMinWidth)
	 			widgetMinWidth = labels.get(i).buddy().width();
	 	}
		layout.setColumnMinimumWidth(0, labelMinWidth);
		layout.setColumnMinimumWidth(1, widgetMinWidth);

	 	updateVisibility();
	 	layout.addWidget(submitButton, labels.size(), 0, 1, 2, Qt.AlignmentFlag.AlignCenter);
	}
	
	private void updateVisibility() {
		for (int i = 0; i < labels.size(); i++) {
			labels.get(i).setVisible(visibilityMap.get(labels.get(i)));
			labels.get(i).buddy().setVisible(visibilityMap.get(labels.get(i)));
		}
	}
	
	private void onChanged() {

		valueResidueWidget.setValue(((sellingPriceWidget.value())-(privateDebtWidget.value())));
		overWidget.setChecked(((DateQWidget.date()).daysTo(new QDate(1994, 1, 28))>=0));
		visibilityMap.put(hasSoldHouseLabel, (true));
		visibilityMap.put(hasBoughtHouseLabel, (true));
		visibilityMap.put(hasMaintLoanLabel, (true));
		visibilityMap.put(dummyLabel, (true));
		visibilityMap.put(sellingPriceLabel, ((true)&&(hasSoldHouseWidget.isChecked())));
		visibilityMap.put(privateDebtLabel, ((true)&&(hasSoldHouseWidget.isChecked())));
		visibilityMap.put(valueResidueLabel, ((true)&&(hasSoldHouseWidget.isChecked())));
		visibilityMap.put(DateQLabel, (true));
		visibilityMap.put(overLabel, (true));
		updateVisibility();
	}
	 	
	private void onChanged(boolean value) {
		onChanged();
	}
	private void onChanged(int value) {
		onChanged();
	}
	private void onChanged(String value) {
		onChanged();
	}
	private void onChanged(double value) {
		onChanged();
	}
	private void onChanged(QDate value) {
		onChanged();
	}

	private void onClicked() {
		JSONObject obj=new JSONObject();

		if (hasSoldHouseWidget.isVisible())
			obj.put("hasSoldHouse", (hasSoldHouseWidget.isChecked()));

		if (hasBoughtHouseWidget.isVisible())
			obj.put("hasBoughtHouse", (hasBoughtHouseWidget.isChecked()));

		if (hasMaintLoanWidget.isVisible())
			obj.put("hasMaintLoan", (hasMaintLoanWidget.isChecked()));

		if (dummyWidget.isVisible())
			obj.put("dummy", (dummyWidget.value()));

		if (sellingPriceWidget.isVisible())
			obj.put("sellingPrice", (sellingPriceWidget.value()));

		if (privateDebtWidget.isVisible())
			obj.put("privateDebt", (privateDebtWidget.value()));

		if (valueResidueWidget.isVisible())
			obj.put("valueResidue", (valueResidueWidget.value()));

		if (DateQWidget.isVisible())
			obj.put("DateQ", (DateQWidget.date()));

		if (overWidget.isVisible())
			obj.put("over", (overWidget.isChecked()));
	
		System.out.println(obj);
		PrintWriter out = null;
		try{
			out = new PrintWriter(new FileWriter("form.answers")); 
  			out.println(obj);
  		} catch (Exception e) {
  			System.err.println("Error: " + e.getMessage());
  		} finally {
			out.close();
		}
		QApplication.quit();
	}
}