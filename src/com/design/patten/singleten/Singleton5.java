package com.design.patten.singleten;

//Works with acquire/release semantics for volatile
//Broken under current semantics for volatile
class Foo {
	private volatile Foo helper = null;

	public Foo getHelper() {
		if (helper == null) {
			synchronized (this) {
				if (helper == null){
					helper = new Foo();
				}
			}
		}
		return helper;
	}
}
