/*
 * Class that accesses data, sends to servlet, checks for a valid printer serial, computes stats for prints
 */
package print;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON {

	public ReadJSON(){
		
	}
	
	public static boolean checkIfAValidUser(String serial){
		JSONParser parser = new JSONParser();
		JSONArray bioPrints;
		try {
			bioPrints = (JSONArray) parser.parse(new FileReader("C:\\Users\\jayal\\workspaceSecond\\PrintDataApp\\bioprint-data.json.txt"));
			for(Object bP: bioPrints){
				JSONObject bioPrint = (JSONObject) bP;
				JSONObject user = (JSONObject) bioPrint.get("user_info");
				if(user.get("serial").equals(Long.parseLong(serial))){
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static ArrayList<PrintData> getData(long serial){
		JSONParser parser = new JSONParser();
		ArrayList<PrintData> listOfRows = new ArrayList<PrintData>();
		try { 
			JSONArray bioPrints = (JSONArray) parser.parse(new FileReader("C:\\Users\\jayal\\workspaceSecond\\PrintDataApp\\bioprint-data.json.txt"));
			for(Object bP: bioPrints){
				JSONObject bioPrint = (JSONObject) bP;
				JSONObject user = (JSONObject) bioPrint.get("user_info");
				if((long)user.get("serial")==serial){
					PrintData pD = new PrintData();
					pD.setUserSerial(serial);
					JSONObject print_data = (JSONObject) bioPrint.get("print_data");
					JSONObject print_info = (JSONObject) bioPrint.get("print_info");
					pD.setDataDeadPercent((double) print_data.get("deadPercent"));
					pD.setDataElasticity((double) print_data.get("elasticity"));
					pD.setDataLivePercent((double) print_data.get("livePercent"));
					
					JSONObject crosslinking = (JSONObject) print_info.get("crosslinking");
					pD.setCrosslinkDuration((long) crosslinking.get("cl_duration"));
					pD.setCrosslinkEnabled((boolean) crosslinking.get("cl_enabled"));
					pD.setCrosslinkIntensity((long) crosslinking.get("cl_intensity"));
					
					JSONObject files = (JSONObject) print_info.get("files");
					pD.setInputFileName((String) files.get("input"));
					pD.setOutputFileName((String) files.get("output"));
					
					JSONObject pressure = (JSONObject) print_info.get("pressure");
					pD.setPressureExtruder1((double) pressure.get("extruder1"));
					pD.setPressureExtruder2((double) pressure.get("extruder2"));
					
					JSONObject resolution = (JSONObject) print_info.get("resolution");	
					pD.setLayerHeight((double) resolution.get("layerHeight"));
					pD.setLayerNum((long) resolution.get("layerNum"));
					pD.setWellplate((long) print_info.get("wellplate"));
					listOfRows.add(pD);					
				}
			}
			return listOfRows;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public static PrintDataStatistic getStatistics(long serial){
		PrintDataStatistic stats = new PrintDataStatistic();
		ArrayList<PrintData> listOfRows = getData(serial);
		DistPrintData minValues = new DistPrintData("min");
		DistPrintData maxValues = new DistPrintData("max");
		DistPrintData avgValues = new DistPrintData("avg");
		
		int countOfCrosslinkPrint = 0;
		
		for(PrintData pD: listOfRows){
			avgValues.setDataDeadPercent(avgValues.getDataDeadPercent() + pD.getDataDeadPercent());
			if(pD.getDataDeadPercent() < minValues.getDataDeadPercent()){
				minValues.setDataDeadPercent(pD.getDataDeadPercent());
			}
			if(pD.getDataDeadPercent() > maxValues.getDataDeadPercent()){
				maxValues.setDataDeadPercent(pD.getDataDeadPercent());
			}
			
			avgValues.setDataLivePercent(avgValues.getDataLivePercent() + pD.getDataLivePercent());
			if(pD.getDataLivePercent() < minValues.getDataLivePercent()){
				minValues.setDataLivePercent(pD.getDataLivePercent());
			}
			if(pD.getDataLivePercent() > maxValues.getDataLivePercent()){
				maxValues.setDataLivePercent(pD.getDataLivePercent());
			}
			
			avgValues.setDataElasticity(avgValues.getDataElasticity() + pD.getDataElasticity());
			if(pD.getDataElasticity() < minValues.getDataElasticity()){
				minValues.setDataElasticity(pD.getDataElasticity());
			}
			if(pD.getDataElasticity() > maxValues.getDataElasticity()){
				maxValues.setDataElasticity(pD.getDataElasticity());
			}
			
			avgValues.setPressureExtruder1(avgValues.getPressureExtruder1() + pD.getPressureExtruder1());
			if(pD.getPressureExtruder1() < minValues.getPressureExtruder1()){
				minValues.setPressureExtruder1(pD.getPressureExtruder1());
			}
			if(pD.getPressureExtruder1() > maxValues.getPressureExtruder1()){
				maxValues.setPressureExtruder1(pD.getPressureExtruder1());
			}
			
			avgValues.setPressureExtruder2(avgValues.getPressureExtruder2() + pD.getPressureExtruder2());
			if(pD.getPressureExtruder2() < minValues.getPressureExtruder2()){
				minValues.setPressureExtruder2(pD.getPressureExtruder2());
			}
			if(pD.getPressureExtruder2() > maxValues.getPressureExtruder2()){
				maxValues.setPressureExtruder2(pD.getPressureExtruder2());
			}
			
			avgValues.setLayerHeight(avgValues.getLayerHeight() + pD.getLayerHeight());
			if(pD.getLayerHeight() < minValues.getLayerHeight()){
				minValues.setLayerHeight(pD.getLayerHeight());
			}
			if(pD.getLayerHeight() > maxValues.getLayerHeight()){
				maxValues.setLayerHeight(pD.getLayerHeight());
			}
			
			avgValues.setLayerNum(avgValues.getLayerNum() + pD.getLayerNum());
			if(pD.getLayerNum() < minValues.getLayerNum()){
				minValues.setLayerNum(pD.getLayerNum());
			}
			if(pD.getLayerNum() > maxValues.getLayerNum()){
				maxValues.setLayerNum(pD.getLayerNum());
			}
			
			if(pD.isCrosslinkEnabled()){
				countOfCrosslinkPrint++;
				avgValues.setCrosslinkDuration(avgValues.getCrosslinkDuration() + pD.getCrosslinkDuration());
				if(pD.getCrosslinkDuration() < minValues.getCrosslinkDuration()){
					minValues.setCrosslinkDuration(pD.getCrosslinkDuration());
				}
				if(pD.getCrosslinkDuration() > maxValues.getCrosslinkDuration()){
					maxValues.setCrosslinkDuration(pD.getCrosslinkDuration());
				}
				
				avgValues.setCrosslinkIntensity(avgValues.getCrosslinkIntensity() + pD.getCrosslinkIntensity());
				if(pD.getCrosslinkIntensity() < minValues.getCrosslinkIntensity()){
					minValues.setCrosslinkIntensity(pD.getCrosslinkIntensity());
				}
				if(pD.getCrosslinkIntensity() > maxValues.getCrosslinkIntensity()){
					maxValues.setCrosslinkIntensity(pD.getCrosslinkIntensity());
				}
			}
		}
		avgValues.setDataDeadPercent(avgValues.getDataDeadPercent()/listOfRows.size());
		avgValues.setDataElasticity(avgValues.getDataElasticity()/listOfRows.size());
		avgValues.setDataLivePercent(avgValues.getDataLivePercent()/listOfRows.size());
		avgValues.setLayerHeight(avgValues.getLayerHeight()/listOfRows.size());
		avgValues.setLayerNum(avgValues.getLayerNum()/listOfRows.size());
		avgValues.setPressureExtruder1(avgValues.getPressureExtruder1()/listOfRows.size());
		avgValues.setPressureExtruder2(avgValues.getPressureExtruder2()/listOfRows.size());
		avgValues.setCrosslinkDuration(avgValues.getCrosslinkDuration()/countOfCrosslinkPrint);
		avgValues.setCrosslinkIntensity(avgValues.getCrosslinkIntensity()/countOfCrosslinkPrint);
		stats.setMinValues(minValues);
		stats.setMaxValues(maxValues);
		stats.setAvgValues(avgValues);
		stats.setCountOfCrossLinkEnabled(countOfCrosslinkPrint);
		stats.setPrintCounts(listOfRows.size());
		return stats;
	}
}
