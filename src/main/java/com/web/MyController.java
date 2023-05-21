package com.web;
import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	//http://localhost:1111/req1
	@RequestMapping("/req1")
	@ResponseBody
	public String home()
	{
		return "Welcome To SpringBoot Web Appn";
	}
	
	//http://localhost:1111/req2/bhavani
	@RequestMapping("/req2/{name}")
	@ResponseBody
	public String single(@PathVariable String name)
	{
		return "Your Name is :"+name;
	}
	
	//http://localhost:1111/req3/10/sankar/java/87666.00
	@RequestMapping("/req3/{id}/{name}/{course}/{fee}")
	@ResponseBody
	public String multiple(@PathVariable int id,@PathVariable String name,
			@PathVariable String course,
			@PathVariable double fee)
	{
		return "Person Details are : "+id+","+name+","+course+","+fee;
	}
	
	//http://localhost:1111/req4/red,green,yellow/banana,apple
	@RequestMapping("/req4/{colorNames}/{fruitNames}")
	@ResponseBody
	public String handler(@PathVariable String[] colorNames,
			@PathVariable List<String> fruitNames) {
		
		return "Fruit Names : "+fruitNames+"Color Names : "+Arrays.asList(colorNames);
		
	}
	
	//http://localhost:1111/req5/{chanti}/{30}/{pullayapalem}/{ameerpet}/{hyd}/{500018}/{saving}/{sbi}/{981776}	
	@RequestMapping("/req5/{name}/{age}/{address}/{street}/{city}/{zip}/{account}/{bankName}/{accountNumber}")
	@ResponseBody
	public String mapObject(@PathVariable Map<String,String> params) {
		
		StringBuilder sb=new StringBuilder();
		
		for(Map.Entry<String, String> e:params.entrySet())
		{
			sb.append(e.getKey()+":"+e.getValue());
		}
		
		return sb.toString();
	}
	
	//http://localhost:1111/req6/2022-01-01/12:30:00
	@RequestMapping("/req6/{date}/{time}")
	@ResponseBody
	public String dateAndTime(
			@DateTimeFormat(pattern="yyyy-MM-dd")
			@PathVariable("date") LocalDate date,
			@DateTimeFormat(pattern="HH:mm:ss")
			@PathVariable("time") LocalTime time)
	{
		
		return "Date & Time ="+date+":"+time;
	}
}
