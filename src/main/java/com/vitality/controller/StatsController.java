package com.vitality.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vitality.utillity.*;

@RestController
public class StatsController {

	@GetMapping("/")
    public ResponseEntity<String> getListStats(@RequestParam("list") String listParam) {
        try {
            List<Integer> list = Utils.parseList(listParam);
            if (list.size() > 10) {
                return new ResponseEntity<>("The list cannot have more than 10 values.", HttpStatus.BAD_REQUEST);
            }

            double median = Utils.calculateMedian(list);
            Integer mode = Utils.calculateMode(list);
            String modeRes = "";
            if(mode == null){
                modeRes = "No mode found as All values appear only once";
            }
            else{
                modeRes = String.valueOf(mode);
            }


            return ResponseEntity.ok("Median: " + median + ", Mode: " + modeRes);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid list format.", HttpStatus.BAD_REQUEST);
        }
    }
}
