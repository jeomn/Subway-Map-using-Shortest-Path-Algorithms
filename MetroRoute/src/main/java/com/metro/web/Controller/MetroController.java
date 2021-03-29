package com.metro.web.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
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
		
		//Set Your Path
		//If you "don't want" to use Anaconda Python Path, you can use it. But in that case, you should Change set_SubwayRoute.py
		//Also, you should change developer2's python code(line 72, line 88)
		//String PYTHON_PATH = "User's Python Path" or "python"; //The both works, so you can choose one.
		//String PATH_TO_SCRIPT = "User's STS worspace Path" +"\\MetroRoute\\src\\main\\resources\\static\\";
		
		//If you "want" to use Anaconda Python environmnet
		//Developer1's codes are only work in Anaconda Python environment
		String PYTHON_PATH = "User's Anaconda Python Path";
		String PATH_TO_SCRIPT = "User's STS worspace Path" +"\\MetroRoute\\src\\main\\resources\\static\\pyAnaconda\\";
		
		
		if (devArr[0].equals("dev1")) {
			if (devArr[1].equals("Dijkstra")) {
				ProcessBuilder pb = new ProcessBuilder(PYTHON_PATH, PATH_TO_SCRIPT+"Developer1\\Dijkstra_Subway.py", cmd);
				Process process;
				
				try {
					process = pb.start();
					BufferedReader bfr = new BufferedReader(new InputStreamReader(process.getInputStream()));
					result = "";
					result = bfr.readLine();		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				ProcessBuilder pb = new ProcessBuilder(PYTHON_PATH, PATH_TO_SCRIPT+"Developer1\\FloydWarshall_Subway.py", cmd);
				Process process;
				
				try {
					process = pb.start();
					BufferedReader bfr = new BufferedReader(new InputStreamReader(process.getInputStream()));
					result = "";
					result = bfr.readLine();		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			if (devArr[1].equals("Dijkstra")) {
				//If you "do not want" work in Anaconda, change PYTHON_PATH, PATH_TO_SCRIPT, and additional python code path
				//"Developer2\\Dijkstra_Searchin_SubwayRoute.py" to "Dijkstra_Searching_Subway.py"
				ProcessBuilder pb = new ProcessBuilder(PYTHON_PATH, PATH_TO_SCRIPT+"Developer2\\Dijkstra_Searching_SubwayRoute.py", cmd);
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
				//If you want work not in Anaconda, change PYTHON_PATH, PATH_TO_SCRIPT, and python code path
				//"Developer2\\SPFA_Searchin_SubwayRoute.py" to "SPFA_Searching_Subway.py"
				ProcessBuilder pb = new ProcessBuilder(PYTHON_PATH, PATH_TO_SCRIPT+"Developer2\\SPFA_Searching_SubwayRoute.py", cmd);
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
