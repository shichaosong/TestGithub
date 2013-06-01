package com.design.patten.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class User implements Cloneable, Serializable {

	String password;
	Father f;

	public User(String password, Father f) {

		this.password = password;

		this.f = f;

	}

	public Object clone() throws CloneNotSupportedException {
		// return super.clone();

		ObjectOutputStream out = null;
		ObjectInputStream in = null;

		try {

			ByteArrayOutputStream bo = new ByteArrayOutputStream();

			out = new ObjectOutputStream(bo);
			out.writeObject(this);
			out.flush();
			byte[] bs = bo.toByteArray();

			ByteArrayInputStream bi = new ByteArrayInputStream(bs);
			in = new ObjectInputStream(bi);
			Object o = in.readObject();

			return o;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}