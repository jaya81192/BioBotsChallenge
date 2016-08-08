/*
 * Class to hold the print statistics
 */
package print;

public class PrintDataStatistic {
	private DistPrintData minValues;
	private DistPrintData maxValues;
	private DistPrintData avgValues;
	private int printCounts;
	private int countOfCrossLinkEnabled;
	public DistPrintData getMinValues() {
		return minValues;
	}
	public void setMinValues(DistPrintData minValues) {
		this.minValues = minValues;
	}
	public DistPrintData getMaxValues() {
		return maxValues;
	}
	public void setMaxValues(DistPrintData maxValues) {
		this.maxValues = maxValues;
	}
	public DistPrintData getAvgValues() {
		return avgValues;
	}
	public void setAvgValues(DistPrintData avgValues) {
		this.avgValues = avgValues;
	}
	public int getPrintCounts() {
		return printCounts;
	}
	public void setPrintCounts(int printCounts) {
		this.printCounts = printCounts;
	}
	public int getCountOfCrossLinkEnabled() {
		return countOfCrossLinkEnabled;
	}
	public void setCountOfCrossLinkEnabled(int countOfCrossLinkEnabled) {
		this.countOfCrossLinkEnabled = countOfCrossLinkEnabled;
	}
}
