package com.converter;

import java.util.Collection;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import com.entity.Store;

import lombok.SneakyThrows;

public class StoreFormatter extends CustomCollectionEditor {
	
	 public StoreFormatter(Class<? extends Collection> collectionType ) {
	        super(collectionType);
	    }
	 
	 @SneakyThrows
	    @Override
	    protected Object convertElement(Object element) {
	        if(!element.equals(null)) {
	            Store store =  new Store(Long.parseLong(String.valueOf(element)));
	            return store;
	        }else{
	            return null;
	        }
	    }

}
