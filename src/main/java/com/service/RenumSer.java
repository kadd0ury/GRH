package com.service;

import java.util.List;
import com.entity.Renum;



public interface RenumSer {
	
	public List < Renum > getRenum();

    public void saveRenum(Renum theRenum);

    public Renum getRenum(long theId);

    public void deleteRenum(long theId);
	

}
