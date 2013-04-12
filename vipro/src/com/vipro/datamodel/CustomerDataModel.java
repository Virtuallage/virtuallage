package com.vipro.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.apache.commons.lang.StringUtils;
import org.primefaces.model.SelectableDataModel;

import com.vipro.data.Customer;

public class CustomerDataModel extends ListDataModel<Customer> implements
		SelectableDataModel<Customer> {

	public CustomerDataModel() {  
    }  
  
    public CustomerDataModel(List<Customer> data) {  
        super(data);  
    }  
	
	@Override
	public Customer getRowData(String customer) {
		 List<Customer> customerList = (List<Customer>) getWrappedData();  
         
	        for(Customer cust : customerList) {  
	            if(cust != null && StringUtils.equals(String.valueOf(cust.getCustomerId()), customer))  
	                return cust;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(Customer customer) {
		if (customer != null) {
			return customer.getCustomerId();
		}
		else {
			return null;
		}
	}

}
