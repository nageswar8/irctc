package com.cts.irctc.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.irctc.exception.ApplicationException;
import com.cts.irctc.model.TicketBooking;
import com.cts.irctc.model.TrainInfo;
import com.cts.irctc.service.IrctcService;

@Controller
public class IrctcController {
	
	@Autowired
	private IrctcService service;

	
	@Autowired
	public IrctcController(IrctcService service) {
		super();
		this.service = service;
	}
	
	@Autowired
	private TicketBooking ticketBooking;

	@RequestMapping(value="/showTicketBookingForm" , method=RequestMethod.GET)
	public String showTicketBookingForm(@ModelAttribute("ticketBooking") TicketBooking ticketBooking) {
		
		//Add code here..
		ticketBooking = new TicketBooking();
		return "ticketBooking"; // TODO, modify this value
	}
	
	@RequestMapping(value="/getTicketBookingResultPage", method=RequestMethod.POST)
	public String getCarSearchResultForm(@Valid @ModelAttribute("ticketBooking") TicketBooking ticketBooking,BindingResult result,ModelMap map) throws ApplicationException {
		
		//Add code here..
		if(result.hasErrors()) {
			return "ticketBooking";
		}
		 // TODO, modify this value
		TrainInfo ti = service.getTicketBookingResult(ticketBooking);
		if(ti==null) {
			return "trainNotAvailable";
		}
		else {
			String pnr= service.getPNRNumber(ticketBooking);
			String completePNR= ti.getTrainNumber().substring(0,3).concat(pnr);
			map.addAttribute("pnr",completePNR);
			map.addAttribute("tno", ti.getTrainNumber());
			map.addAttribute("tname", ti.getTrainName());
			map.addAttribute("dot", ticketBooking.getDateOfTravel());
			map.addAttribute("dept",ti.getDeparture());
			map.addAttribute("duration", ti.getDuration());
			map.addAttribute("a", ti.getArrival());
			map.addAttribute("price", ti.getFarePerPassenger() * ticketBooking.getNoOfTickets());
			
		}
		return "ticketBookingResult";
	}
	
	@ModelAttribute("fromCity")
	public List<String> populateFromCities() {
		List<String> fromCities = new ArrayList<String>();

		 fromCities.add("Chennai"); 
		  fromCities.add("Delhi"); 
		  fromCities.add("Bangalore"); 
		  fromCities.add("Pune");
				
		return fromCities;
	}
	
	@ModelAttribute("toCity")
	public List<String> populateToCities() {
		List<String> toCities = new ArrayList<String>();
		 
		  toCities.add("Chennai"); 
		  toCities.add("Delhi");
		  toCities.add("Bangalore"); 
		  toCities.add("Pune");		 	
		
		return toCities;
	}
	
	@ModelAttribute("travelClass")
	public List<String> populateClassType() {
		List<String> classTypes = new ArrayList<String>();
		  
		 classTypes.add("AC First Class (1A)");
		  classTypes.add("AC 2 Tier (2A)"); 
		  classTypes.add("AC 3 Tier (3A)");
		  classTypes.add("Sleeper (SL)"); 
		  classTypes.add("Second Sitting (2S)"); 
		  
			
		return classTypes;
	}
	
	
}
