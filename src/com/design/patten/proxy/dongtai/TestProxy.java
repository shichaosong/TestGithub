package com.design.patten.proxy.dongtai;

import com.design.patten.proxy.jingtai.Count;
import com.design.patten.proxy.jingtai.CountImpl;
 
public class TestProxy {

	public static void main(String[] args) {
		BookFacadeProxy proxy = new BookFacadeProxy();
		
		BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
		bookProxy.addBook();
		
		Count countProxy = (Count) proxy.bind(new CountImpl());
		countProxy.updateCount();
		
	}

}
