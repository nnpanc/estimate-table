package com.example.demo;

import com.example.demo.model.TimeModel;
import com.example.demo.service.EstimateTableService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	private static EstimateTableService estimateTableService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		estimateTableService = new EstimateTableService();
		Integer totalTable = estimateTableService.estimate(getInputList());
		System.out.println("at least : " + totalTable);
	}

	private static List<TimeModel> getInputList() {
		List<TimeModel> inputList = new LinkedList<>();

//		#2
//		inputList.add(new TimeModel("10:00", "12:00"));
//		inputList.add(new TimeModel("09:00", "11:00"));
//		inputList.add(new TimeModel("08:00", "10:00"));

//		#3
//        inputList.add(new TimeModel("10:00", "12:00"));
//        inputList.add(new TimeModel("09:00", "11:00"));
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("11:00", "13:00"));

//		#2
//        inputList.add(new TimeModel("10:00", "12:00"));
//        inputList.add(new TimeModel("11:00", "12:00"));
//        inputList.add(new TimeModel("14:00", "16:00"));
//        inputList.add(new TimeModel("13:00", "15:00"));

//		#3
//        inputList.add(new TimeModel("10:00", "12:00"));
//        inputList.add(new TimeModel("11:00", "12:00"));
//        inputList.add(new TimeModel("14:00", "16:00"));
//        inputList.add(new TimeModel("13:00", "15:00"));
//        inputList.add(new TimeModel("13:00", "16:00"));

//		#3
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("09:00", "11:00"));
//        inputList.add(new TimeModel("11:00", "13:00"));
//        inputList.add(new TimeModel("10:00", "12:00"));
//        inputList.add(new TimeModel("10:30", "11:30"));

//		#10
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("09:00", "10:00"));
//        inputList.add(new TimeModel("09:00", "10:00"));

//		#5
        inputList.add(new TimeModel("08:00", "10:00"));
        inputList.add(new TimeModel("09:00", "10:00"));
        inputList.add(new TimeModel("10:00", "11:00"));
        inputList.add(new TimeModel("10:00", "12:00"));
        inputList.add(new TimeModel("16:00", "17:00"));
        inputList.add(new TimeModel("15:00", "16:00"));
        inputList.add(new TimeModel("11:00", "14:00"));
        inputList.add(new TimeModel("14:00", "15:00"));
        inputList.add(new TimeModel("09:00", "12:00"));
        inputList.add(new TimeModel("08:00", "17:00"));
        inputList.add(new TimeModel("09:00", "11:00"));

		return inputList;
	}
}
