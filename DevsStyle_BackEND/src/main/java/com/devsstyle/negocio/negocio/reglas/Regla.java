package com.devsstyle.negocio.negocio.reglas;

public interface Regla<T> {

	void ejecutar(T... datos);
}