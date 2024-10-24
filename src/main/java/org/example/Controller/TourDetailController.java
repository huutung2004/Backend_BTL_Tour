package org.example.Controller;

import org.example.Modal.TourDetail;
import org.example.Service.TourDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TourDetail")
public class TourDetailController {
    @Autowired
    private TourDetailService tourDetailService;

    @GetMapping("/ListAllTourDetail")
    public ResponseEntity<List<TourDetail>> listTourDetail() {
        List<TourDetail> tourDetails = tourDetailService.getAllTourDetail();
        return new ResponseEntity<>(tourDetails, HttpStatus.OK);
    }

    @GetMapping("/TourDetailByTourID/{tourId}")
    public ResponseEntity<TourDetail> tourDetailById(@PathVariable String tourId) {
        TourDetail tourDetail = tourDetailService.findTourDetailByTourId(tourId);
        if (tourDetail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tourDetail, HttpStatus.OK);
    }

    @PostMapping("/addNewTourDetail") // Thêm dấu /
    public ResponseEntity<TourDetail> addNewTourDetail(@RequestBody TourDetail tourDetail) {
        TourDetail newTourDetail = tourDetailService.createNewTourDetail(tourDetail);
        return new ResponseEntity<>(newTourDetail, HttpStatus.CREATED);
    }
}
