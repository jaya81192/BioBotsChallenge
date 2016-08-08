/*
 * Class to hold data for a single print 
 */
package print;

public class PrintData {
	private long userSerial;
	private double dataDeadPercent;
	private double dataElasticity;
	private double dataLivePercent;
	private long crosslinkDuration;
	private boolean crosslinkEnabled;
	private long crosslinkIntensity;
	private String inputFileName;
	private String outputFileName;
	private double pressureExtruder1;
	private double pressureExtruder2;
	private double layerHeight;
	private long layerNum;
	private long wellplate;
	
	public double getDataDeadPercent() {
		return dataDeadPercent;
	}
	public void setDataDeadPercent(double dataDeadPercent) {
		this.dataDeadPercent = dataDeadPercent;
	}
	public double getDataElasticity() {
		return dataElasticity;
	}
	public void setDataElasticity(double dataElasticity) {
		this.dataElasticity = dataElasticity;
	}
	public double getDataLivePercent() {
		return dataLivePercent;
	}
	public void setDataLivePercent(double dataLivePercent) {
		this.dataLivePercent = dataLivePercent;
	}
	public long getCrosslinkDuration() {
		return crosslinkDuration;
	}
	public void setCrosslinkDuration(long crosslinkDuration) {
		this.crosslinkDuration = crosslinkDuration;
	}
	public boolean isCrosslinkEnabled() {
		return crosslinkEnabled;
	}
	public void setCrosslinkEnabled(boolean crosslinkEnabled) {
		this.crosslinkEnabled = crosslinkEnabled;
	}
	public long getCrosslinkIntensity() {
		return crosslinkIntensity;
	}
	public void setCrosslinkIntensity(long crosslinkIntensity) {
		this.crosslinkIntensity = crosslinkIntensity;
	}
	public String getInputFileName() {
		return inputFileName;
	}
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	public String getOutputFileName() {
		return outputFileName;
	}
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	public double getPressureExtruder1() {
		return pressureExtruder1;
	}
	public void setPressureExtruder1(double pressureExtruder1) {
		this.pressureExtruder1 = pressureExtruder1;
	}
	public double getPressureExtruder2() {
		return pressureExtruder2;
	}
	public void setPressureExtruder2(double pressureExtruder2) {
		this.pressureExtruder2 = pressureExtruder2;
	}
	public double getLayerHeight() {
		return layerHeight;
	}
	public void setLayerHeight(double layerHeight) {
		this.layerHeight = layerHeight;
	}
	public long getLayerNum() {
		return layerNum;
	}
	public void setLayerNum(long layerNum) {
		this.layerNum = layerNum;
	}
	public long getWellplate() {
		return wellplate;
	}
	public void setWellplate(long wellplate) {
		this.wellplate = wellplate;
	}
	public long getUserSerial() {
		return userSerial;
	}
	public void setUserSerial(long userSerial) {
		this.userSerial = userSerial;
	}
}
