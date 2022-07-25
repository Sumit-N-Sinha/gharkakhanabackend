package com.Gharkakhana.service;

import java.util.List;
import java.util.Optional;

import com.Gharkakhana.dto.VendorDTO;
import com.Gharkakhana.exception.VendorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.Gharkakhana.entity.Vendor;
import com.Gharkakhana.repository.VendorRepository;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService{
	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public void createVendor(VendorDTO vendorDTO) {
		Vendor v = new Vendor();
		v.setName(vendorDTO.getName());
		v.setStatus(vendorDTO.getStatus());
		v.setOrderId(vendorDTO.getOrderId());
		vendorRepository.save(v);
		
		
	}
	public void setStatusByVendor(int vendorId, VendorDTO vendorDTO) {
		Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new VendorNotFoundException("No vendor found with id" + vendorId));
	    if(vendorDTO.getStatus()!=null) {
			vendor.setStatus(vendorDTO.getStatus());
		}
		vendorRepository.save(vendor);
	}

	@Override
	public List<Vendor> getAllVendor() {
		return vendorRepository.findAll();
	}

	@Override
	public void deleteVendorBYId(int id) {
		Optional<Vendor> optional = vendorRepository.findById(id);
		if (optional.isPresent()) {
			vendorRepository.deleteById(id);

		} else {
			throw new VendorNotFoundException("No vendor found with id " + id);
		}
		
		
	}

	@Override
	public void updateVendor(VendorDTO vendorDTO, int id) {
		Optional<Vendor> optionalVendor = vendorRepository.findById(id);
		if(optionalVendor.isPresent()) {
			Vendor vendor = optionalVendor.get();
			vendor.setName(vendorDTO.getName());
			vendor.setStatus(vendorDTO.getStatus());
			vendor.setOrderId(vendorDTO.getOrderId());
			vendorRepository.save(vendor);
		}
		else {
			throw new VendorNotFoundException("No vendor found to update with id: " + id);
		}

	}

	@Override
	public Vendor getVendorById(int id) {
		Optional<Vendor> optionalVendor = vendorRepository.findById(id);
		if (optionalVendor.isPresent()) {
			return optionalVendor.get();

		} else {
			throw new VendorNotFoundException("No vendor found with id " + id);
		}
	}

}
