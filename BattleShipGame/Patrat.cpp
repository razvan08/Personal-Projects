#include "Patrat.h"
#include <iostream>
using namespace std;


Patrat::Patrat() :m_linie(0), m_coloana(0), m_culoare(""), m_stare(false) {

}

Patrat::Patrat(int linie, int coloana, string& culoare, bool stare) :
	m_linie(linie), m_coloana(coloana), m_culoare(culoare), m_stare(stare) {

}

Patrat::~Patrat() {
	if (m_stare == true) {
		delete Tip;
	}
}

void Patrat::show_stare() {
	if (m_stare == false) {
		cout << "Patrat neocupat" << endl;
	}
	else {
		cout << "Patrat ocupat" << endl;
	}
}

void Patrat::afisare() {
	cout << "\nLinia:" << m_linie << endl;
	cout << "Coloana:" << m_coloana << endl;
	cout << "Culoarea:" << m_culoare << endl;
	if (m_stare == true) {
		cout << "Exista o nava aici";
	}
	else {
		cout << "Nu exista nicio nava aici";
	}
}

void Patrat::Place(Nava* T) {
	Tip = T;
	SetStare();
}

void Patrat::RemoveNava() {
	if (m_stare == true) {
		delete Tip;
		ResetStare();
	}
	else {
		cout << "Patratul nu are o nava" << endl;
	}
}