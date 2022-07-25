package com.Gharkakhana.service;

import java.util.List;

import com.Gharkakhana.dto.VendorDTO;
import com.Gharkakhana.entity.Vendor;

public interface VendorService {
	public void createVendor(VendorDTO vendorDTO);
	public List<Vendor> getAllVendor();
	public void deleteVendorBYId(int id);
	public void updateVendor(VendorDTO vendorDTO, int id);
	public Vendor getVendorById(int id);
	public void setStatusByVendor(int vendorId, VendorDTO vendorDTO);

}
