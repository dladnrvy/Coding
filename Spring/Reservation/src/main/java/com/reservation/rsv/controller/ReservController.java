package com.reservation.rsv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reservation.rsv.domain.FirstReserve;
import com.reservation.rsv.service.ReserveService;

@Controller
public class ReservController {

	@Autowired
	ReserveService reservService;
	
	@RequestMapping("/reserve/seat")
	public String rv(FirstReserve rv, Model model) {
	
		int rCnt = reservService.insert(rv);
		model.addAttribute("resultCnt", rCnt);
		
		
		return "reserved/seat";	
	}
	
	
	
}
