package com.techlabs.streamsAssignment;

public class Country {
	private String CountryID;
	private String CountryName;
	private int RegionID;
	
	public Country() {}

	public Country(String countryID, String countryName, int regionID) {
		CountryID = countryID;
		CountryName = countryName;
		RegionID = regionID;
	}

	public String getCountryID() {
		return CountryID;
	}

	public void setCountryID(String countryID) {
		CountryID = countryID;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public int getRegionID() {
		return RegionID;
	}

	public void setRegionID(int regionID) {
		RegionID = regionID;
	}

	@Override
	public String toString() {
		return "Country [CountryID=" + CountryID + ", CountryName=" + CountryName + ", RegionID=" + RegionID + "]";
	}
	
}
