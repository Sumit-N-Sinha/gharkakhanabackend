package com.Gharkakhana.Controller;

import com.Gharkakhana.dto.VendorDTO;
import com.Gharkakhana.entity.Vendor;
import com.Gharkakhana.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class VendorController {
    @Autowired
    private VendorService vendorService;
    @PostMapping("/create")
    public ResponseEntity<String> createAVendor(@Valid @RequestBody VendorDTO vendorDTO) {
        vendorService.createVendor(vendorDTO);
        return new ResponseEntity<>("Vendor created successfully", HttpStatus.OK);

    }
    @GetMapping("/all")
    public List<Vendor> fetchAllVendors() {
        return vendorService.getAllVendor();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Vendor> fetchVendorById(@PathVariable int id) {
        Vendor vendor=vendorService.getVendorById(id);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<String > updateAVendor(@RequestBody VendorDTO vendorDTO, @PathVariable int id) {
        vendorService.updateVendor(vendorDTO, id);
        return new ResponseEntity<>("Vendor with id " + id + "updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAVendor(@PathVariable int id) {
        vendorService.deleteVendorBYId(id);
        return new ResponseEntity<>("Vendor with id " + id + "deleted successfully", HttpStatus.OK);
    }
    @PatchMapping("/status/{vendorId}")
    public ResponseEntity<String> statusOfOrder(@PathVariable int vendorId, @RequestBody VendorDTO vendorDTO) {
        vendorService.setStatusByVendor(vendorId, vendorDTO);
        return new ResponseEntity<>("status updated successfully", HttpStatus.OK);
    }
}
