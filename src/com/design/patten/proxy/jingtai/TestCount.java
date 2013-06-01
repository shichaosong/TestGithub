package com.design.patten.proxy.jingtai;

public class TestCount {
	public static void main(String[] args) {
		CountImpl countImpl = new CountImpl();
		CountProxy countProxy = new CountProxy(countImpl);
		countProxy.updateCount();
		countProxy.queryCount();
	}
}