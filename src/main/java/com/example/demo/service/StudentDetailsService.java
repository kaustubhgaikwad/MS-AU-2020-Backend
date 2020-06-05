package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Location;
import com.example.demo.model.StudentDetails;
import com.example.demo.repository.StudentDetailsRepository;

@Service
public class StudentDetailsService {

	@Autowired
	StudentDetailsRepository repository;
	
	public List<StudentDetails> getAll(){
		return  (List<StudentDetails>) repository.findAll();
	}
	
	public List<List<Location>> getDetails(){
		List<StudentDetails> list = (List<StudentDetails>) repository.findAll();
		//List<?> record = new ArrayList<>();
		Map<String,Long> record = new HashMap<>();
		Map<String,Long> record2 = new HashMap<>();
		for(int i =0;i<list.size();i++) {
			if(list.get(i).getCourseId() == 1L) {
				Long count = record.getOrDefault(list.get(i).getLocation(), (long) 0);
				record.put(list.get(i).getLocation(), count+1);
			}else if(list.get(i).getCourseId() == 2L) {
				Long count = record2.getOrDefault(list.get(i).getLocation(), (long) 0);
				record2.put(list.get(i).getLocation(), count+1);
			}
		}
		List<Map<String,Long>> data = new ArrayList<>();
		List<Location> responseData1 = new ArrayList<>();
		List<Location> responseData2 = new ArrayList<>();
		for (Map.Entry mapElement :record.entrySet()) { 
			
            String key = (String)mapElement.getKey(); 
            Long value = (Long) mapElement.getValue(); 
            responseData1.add(new Location(key,value));

            //System.out.println(key + " : " + value); 
        }
		for (Map.Entry mapElement :record2.entrySet()) { 
			
            String key = (String)mapElement.getKey(); 
            Long value = (Long) mapElement.getValue(); 
            responseData2.add(new Location(key,value));

            //System.out.println(key + " : " + value); 
        }
		List<List<Location>> result = new ArrayList<>();
		result.add(responseData1);
		result.add(responseData2);
//		Map<String,List> result = new HashMap();
//		List<Location> responseData1 = new ArrayList<>();
//		for(int i=0;i<record.size();i++) {
//			responseData1.add(new Location(record.));
//		}
//		data.add(record);
//		data.add(record2);
		//return data;
		return result;
		
	}

}
