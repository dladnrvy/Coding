package com.reservation.rsv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reservation.rsv.domain.FirstReserve;
import com.reservation.rsv.domain.SecondReserve;
import com.reservation.rsv.domain.ThirdReserve;
import com.reservation.rsv.service.ReserveService;

@Controller
@RequestMapping("/reserve/seat")
public class ReservController {

	@Autowired
	ReserveService reservService;
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/{choice}", method = RequestMethod.POST)
	public String frv(FirstReserve rv, Model model) {
	
		int rCnt = reservService.firstInsert(rv);
		model.addAttribute("resultCnt", rCnt);
			
		return "reserved/seat";	
	}
	
	@RequestMapping("/reserve/seat")
	public String srv(SecondReserve rv, Model model) {
	
		int rCnt = reservService.secondInsert(rv);
		model.addAttribute("resultCnt", rCnt);
				
		return "reserved/seat";	
	}
	
	@RequestMapping("/reserve/seat")
	public String trv(ThirdReserve rv, Model model) {
	
		int rCnt = reservService.thirdInsert(rv);
		model.addAttribute("resultCnt", rCnt);
				
		return "reserved/seat";	
	}
	
	
	
}
