/*
 * Class to store distribution value of attributes. example: min, max, avg distribution
 */
package print;

public class DistPrintData {
	
	private double dataDeadPercent;
	private double dataElasticity;
	private double dataLivePercent;
	private double crosslinkDuration;
	private double crosslinkIntensity;
	private double pressureExtruder1;
	private double pressureExtruder2;
	private double layerHeight;
	private double layerNum;
	
	public DistPrintData(String type){
		if(type.equals("min")){
			this.dataDeadPercent = Double.MAX_VALUE;
			this.dataElasticity=Double.MAX_VALUE;
			this.dataLivePercent=Double.MAX_VALUE;
			this.crosslinkDuration=Double.MAX_VALUE;
			this.crosslinkIntensity=Double.MAX_VALUE;
			this.pressureExtruder1=Double.MAX_VALUE;
			this.pressureExtruder2=Double.MAX_VALUE;
			this.layerHeight=Double.MAX_VALUE;
			this.layerNum=Double.MAX_VALUE;
		} else if(type.equals("max")){
			this.dataDeadPercent = Double.MIN_VALUE;
			this.dataElasticity=Double.MIN_VALUE;
			this.dataLivePercent=Double.MIN_VALUE;
			this.crosslinkDuration=Double.MIN_VALUE;
			this.crosslinkIntensity=Double.MIN_VALUE;
			this.pressureExtruder1=Double.MIN_VALUE;
			this.pressureExtruder2=Double.MIN_VALUE;
			this.layerHeight=Double.MIN_VALUE;
			this.layerNum=Double.MIN_VALUE;
		} else {
			this.dataDeadPercent = 0;
			this.dataElasticity=0;
			this.dataLivePercent=0;
			this.crosslinkDuration=0;
			this.crosslinkIntensity=0;
			this.pressureExtruder1=0;
			this.pressureExtruder2=0;
			this.layerHeight=0;
			this.layerNum=0;
		}
	}
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
	public double getCrosslinkDuration() {
		return crosslinkDuration;
	}
	public void setCrosslinkDuration(double crosslinkDuration) {
		this.crosslinkDuration = crosslinkDuration;
	}
	public double getCrosslinkIntensity() {
		return crosslinkIntensity;
	}
	public void setCrosslinkIntensity(double crosslinkIntensity) {
		this.crosslinkIntensity = crosslinkIntensity;
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
	public double getLayerNum() {
		return layerNum;
	}
	public void setLayerNum(double layerNum) {
		this.layerNum = layerNum;
	}
}
