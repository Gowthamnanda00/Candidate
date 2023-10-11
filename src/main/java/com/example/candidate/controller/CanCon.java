package com.example.candidate.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidate.entity.Candidate;
import com.example.candidate.pdfexport.Excel;
import com.example.candidate.service.CanSer;

@RestController
@RequestMapping("/testing")
public class CanCon {
	@Autowired
	CanSer canser;
	@GetMapping("/home")
	public String welcome()
	{
		return "welcome";
	}
	@PostMapping("/adding")
	public Candidate addCan(@RequestBody Candidate candidate)
	{
		return canser.addCan(candidate);
	}
	@DeleteMapping("/deleting/{id}")
	public String deleteCan(@PathVariable int  id)
	{
		return canser.deleteCan(id);
	}
	@PutMapping("/updating/{id}/{salary}")
	public String updateSal(@PathVariable int id,@PathVariable int salary)
	{
		return canser.updateSal(id,salary);
	}
	@GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Employee_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Candidate> listUsers = canser.listAllExcel();

        Excel excelExporter = new Excel(listUsers);

        excelExporter.export(response);    
    }

}
