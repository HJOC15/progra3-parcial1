package com.umg.parcial;
import java.util.Scanner;

public class Arboles {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		ArbolBinario bt = new ArbolBinario();

		int opcion = 0;
		System.out.println("1. MOSTRAR");
		System.out.println("2. GUARDAR");
		System.out.println("0. SALIR");
		do {
			System.out.println("INGRESE OPCION");
			opcion = sc.nextInt();
			if (opcion == 1) {
				//Invocar método mostrar
				bt.mostrar();
			}else if (opcion == 2) {
				//Invocar método mostrar
				bt.agregar(sc);
			}

		}while(opcion>0);
		System.out.println("FIN");

	}

}

class ArbolBinario {
	Nodo raiz;

	public ArbolBinario() {
		Nodo nodo2 = new Nodo(2,null,null);
		Nodo nodo5 = new Nodo(5,null,null);
		Nodo nodo4 = new Nodo(4,nodo2,nodo5);
		Nodo nodo9 = new Nodo(9,null,null);
		Nodo nodo7 = new Nodo(7,null,null);
		Nodo nodo8 = new Nodo(8,nodo7,nodo9);
		raiz = new Nodo(6,nodo4,nodo8);
	}

	private Nodo agregarnuevo(Nodo nodoActual, int value) {

		if (null == nodoActual) {
			return new Nodo(value);
		}

		if (value < nodoActual.value) {
			nodoActual.izq = agregarnuevo(nodoActual.izq, value);
		} else if (value > nodoActual.value) {
			nodoActual.der = agregarnuevo(nodoActual.der, value);
		} else {
			return nodoActual;
		}

		return nodoActual;

	}

	public void anadir(int value) {
		raiz = agregarnuevo(raiz, value);
	}

	public void agregar(Scanner sc) {
		System.out.println("INGRESE VALOR");

		anadir(sc.nextInt());
	}



	public void orden(Nodo node) {
		if (node != null) {
			orden(node.izq);
			orden(node.der);
			System.out.println(node.value);
		}
	}

	public void mostrar() {
		orden(raiz);
	}
}

class Nodo{
	//NO MODIFICAR
	int value;
	public Nodo izq;
	public Nodo der;
	public Nodo(int value, Nodo izq, Nodo der) {
		this.value = value;
		this.izq = izq;
		this.der = der;
	}
	public Nodo(int value) {
		System.out.println("guardar "+value);
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Nodo getIzq() {
		return izq;
	}
	public void setIzq(Nodo izq) {
		this.izq = izq;
	}
	public Nodo getDer() {

		return der;
	}
	public void setDer(Nodo der) {
		this.der = der;
	}

}