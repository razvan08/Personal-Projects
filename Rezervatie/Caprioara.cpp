#include "Caprioara.h"
#include <iostream>
#include <fstream>
using namespace std;

Caprioara::Caprioara() :
	CAnimalIerbivor(), m_nr_pui(0) {}

Caprioara::Caprioara(string& nume, int data, int greutate, string& hrana, int cantitate,int nr_pui):
	CAnimalIerbivor(nume,data,greutate,hrana,cantitate),m_nr_pui(nr_pui){}

Caprioara::~Caprioara(){
	
}

void Caprioara::citire(ifstream& f) {
	CAnimalIerbivor::citire(f);
	f >> m_nr_pui;
}

void Caprioara::afisare(ofstream& g)const {
	CAnimalIerbivor::afisare(g);
	g << "Numarul de pui: " << m_nr_pui << endl;
}