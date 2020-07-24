package com.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.entity.Store;


public class StoreConverter implements Converter<List<String>, Object> {
	
	  @Override
	    public List<Store> convert(List<String> source) {
	       List<Store> storelist=new ArrayList<>();
	       if(source.isEmpty()) {
	           return null;
	       }else{
	            source.forEach(e->storelist.add(new Store(Long.parseLong(e))));
	            return storelist;
	       }
	    }
	}


