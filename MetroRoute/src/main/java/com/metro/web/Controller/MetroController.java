package com.metro.web.Controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class MetroController {
	
 
	@RequestMapping(value = "/metro_Result", method = RequestMethod.POST)
	public String metroPost(Model model, @RequestParam("Start") String start,
			@RequestParam("End") String end, @RequestParam("startLine") String startLine,
			@RequestParam("endLine") String endLine, @RequestParam("dev") String dev){
		System.out.println(startLine+ start +" "+endLine+ end);
		System.out.println(dev);
		String cmd = startLine+"a"+start+"a"+endLine+"a"+end;
		String[] devArr = dev.split("_");
		String result = "";
		
		String PYTHON_PATH = "C:\\Users\\jeomn\\AppData\\Local\\Programs\\Python\\Python36-32\\python.exe";
		String PATH_TO_SCRIPT = "C:\\Users\\jeomn\\sts_workspace\\MetroRoute\\src\\main\\resources\\static\\";
		if (devArr[0].equals("Jisoon")) {
			if (devArr[1].equals("Dijkstra")) {
				System.out.println(devArr[1]);
			} else {
				System.out.println(devArr[1]);
			}
		}
		else {
			if (devArr[1].equals("Dijkstra")) {
				ProcessBuilder pb = new ProcessBuilder(PYTHON_PATH, PATH_TO_SCRIPT+"Dijkstra_Searching_SubwayRoute.py", cmd);
				Process process;
				
				try {
					process = pb.start();
					BufferedReader bfr = new BufferedReader(new InputStreamReader(process.getInputStream(), "euc-kr"));
					result = "";
					result = bfr.readLine();		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				ProcessBuilder pb = new ProcessBuilder(PYTHON_PATH, PATH_TO_SCRIPT+"SPFA_Searching_SubwayRoute.py", cmd);
				Process process;
				
				try {
					process = pb.start();
					BufferedReader bfr = new BufferedReader(new InputStreamReader(process.getInputStream(), "euc-kr"));
					result = "";
					result = bfr.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(result);
		String[] result_token = result.split("a");
		//returnResult(result_token);
		for (String string: result_token) {
			System.out.println(string);
		}
		
		model.addAttribute("start", startLine+"호선 "+start+"역");
		model.addAttribute("end", endLine+"호선 "+end+"역");
		model.addAttribute("dev", devArr[0]);
		model.addAttribute("algorithms", devArr[1]);
		model.addAttribute("route", result_token[0]);
		model.addAttribute("distance", result_token[1]);
		model.addAttribute("transfer", result_token[2]);
		
		return "metro_Result";

	}
	
}
