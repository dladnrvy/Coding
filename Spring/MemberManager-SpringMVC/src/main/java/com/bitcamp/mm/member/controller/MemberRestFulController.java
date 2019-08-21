package com.bitcamp.mm.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberEdit;
import com.bitcamp.mm.member.domain.RequestMemberRegist;
import com.bitcamp.mm.member.service.MemberDeleteService;
import com.bitcamp.mm.member.service.MemberListService;
import com.bitcamp.mm.member.service.MemberRegService;
import com.bitcamp.mm.member.service.MemberUpdateService;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;

@RestController // @Responsebody 생략
@RequestMapping("/rest/members")
public class MemberRestFulController {

	@Autowired
	private MemberListService listService;
	
	@Autowired
	private MemberDeleteService deleteService;
	
	@Autowired
	private MemberRegService regService;
	
	@Autowired
	private MemberUpdateService updateService;
	
	//@RequestMapping(method = RequestMethod.GET) getmapping으로 대신
	//@ResponseBody
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<List<MemberInfo>> getAllList(){
		
		List<MemberInfo> list = listService.getAllList();
		
		ResponseEntity<List<MemberInfo>> entity = 
				new ResponseEntity<List<MemberInfo>>(list, HttpStatus.OK);
		
		//HttpStatus.OK -> 200
		//HttpStatus.NOT_FOUND -> 404
		//HttpStatus.INTERNAL_SERVER_ERROR -> 500
		
		return entity;
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}") // /rest/members/12
	public ResponseEntity<String> deleteMember(
			@PathVariable("id") int idx
			){ 
		 
		 
		return new ResponseEntity<String>(deleteService.memberDelete(idx)>0?"seccess":"fail",HttpStatus.OK);
	}
	
	//@RequestMapping(method = HttpMethod.POST)
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> regMember(
			RequestMemberRegist regRequest,
			HttpServletRequest request
			) {
		
		System.out.println("check : " +regRequest);
		
		int cnt = regService.memberInsert(request, regRequest);
		
		return new ResponseEntity<String>(cnt>0?"success":"fail",HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}") 
	public ResponseEntity<MemberInfo> getMember(
			  @PathVariable("id") int idx
			  ){
		  MemberInfo cnt = null;
	  cnt = updateService.getEditFormData(idx);
	  
	  System.out.println(cnt);
	  
		return new ResponseEntity<MemberInfo>(cnt,HttpStatus.OK); 
	  }
	
	
	@CrossOrigin
	  @PutMapping("/{id}") 
	  public ResponseEntity<String> updateMember(
			  @RequestBody RequestMemberEdit regRequest,
			  @PathVariable("id") int idx,
			  HttpServletRequest request 
			  ){
	  regRequest.setIdx(idx);
		  
	  System.out.println(regRequest);
	  
	  int cnt= updateService.edit(regRequest, "", request);
	  
	  
	  
	  return new ResponseEntity<String>(cnt>0?"success":"fail",HttpStatus.OK); 
	  }
	 
	
	
	
	
	
}
