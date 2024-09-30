package com.deyvisson.bookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErro extends StandardError {

	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationErro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationErro(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErros(String fieldName, String message) {
		this.erros.add(new FieldMessage(fieldName, message));
	}

}
