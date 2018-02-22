package com.ab.view;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.ab.Handler;
import com.ab.ModelAndView;
import com.ab.annoation.View;
import com.ab.annoation.ViewAction;
import com.ab.components.RoomAirStandard;
import com.ab.components.RoomHumidity;
import com.ab.components.RoomPressure;
import com.ab.components.RoomTemperature;
import com.ab.components.RoomVOC;

@View(name = "CommUpdateView")
public class CommUpdateView {

	private static CommUpdateView instance;
	
	public synchronized static CommUpdateView getInstance() {
		if(instance == null) {
			instance = new CommUpdateView();
		}
		
		return instance;
	}
	
	private CommUpdateView() {}
	
	@SuppressWarnings({ "unchecked" })
	@ViewAction(action = "updateData")
	public void updateData(ModelAndView modelAndView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		System.out.println("UpdateData");
		Map<String, List<Byte>> dataSet = (Map<String, List<Byte>>) modelAndView.getModel();
		for(String key : dataSet.keySet()) {
			String dataStr = "";
			for(Byte b : dataSet.get(key)) {
				dataStr += Character.toString ((char) ((int)b));;
			}
			ModelAndView data = new ModelAndView(key, dataStr);
			System.out.println("Key = " + key + " --- Data =" + dataStr);
			Handler.handleView("CommUpdateView." + key, data);
		}
	}
	
	@ViewAction(action = "c1")
	public void loadC1(ModelAndView modelAndView) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
		RoomTemperature roomTemperature = RoomTemperature.getInstance();
		roomTemperature.updateValue((String)((ModelAndView)modelAndView.getModel()).getModel());
	}
	
	@ViewAction(action = "c2")
	public void loadC2(ModelAndView modelAndView) {
		RoomHumidity roomHumidity = RoomHumidity.getInstance();
		roomHumidity.updateValue((String)((ModelAndView)modelAndView.getModel()).getModel());
	}
	
	@ViewAction(action = "c3")
	public void loadC3(ModelAndView modelAndView) {
		RoomVOC roomVOC = RoomVOC.getInstance();
		roomVOC.updateValue((String)((ModelAndView)modelAndView.getModel()).getModel());
	}
	
	@ViewAction(action = "c4")
	public void loadC4(ModelAndView modelAndView) {
		RoomAirStandard roomAirStandard = RoomAirStandard.getInstance();
		roomAirStandard.updateValue((String)((ModelAndView)modelAndView.getModel()).getModel());
	}
	
	@ViewAction(action = "c5")
	public void loadB1(ModelAndView modelAndView) {
		RoomPressure roomPressure = RoomPressure.getInstance();
		roomPressure.updateValue((String)((ModelAndView)modelAndView.getModel()).getModel());
	}
}
