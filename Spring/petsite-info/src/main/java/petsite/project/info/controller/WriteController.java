package petsite.project.info.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import petsite.project.info.domain.InfoList;
import petsite.project.info.domain.InfoSave;
import petsite.project.info.service.WriteService;

@RestController
@CrossOrigin
@RequestMapping("/write")
public class WriteController {

	@Autowired
	private WriteService writeService;
	
	@GetMapping()
	public String WriteForm() {
	
		return "겟~하겠어요";
	}
	
	@PostMapping
	public ResponseEntity<String> Write(
			InfoList infolist,
			HttpServletRequest request) {
		System.out.println(infolist.toString());
		
		int rCnt = writeService.write(infolist,request);
		
		System.out.println(rCnt);
		
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
	}
	
}
