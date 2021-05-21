#include "CAnimal.h"
#include <iostream>
#include <string>
#include <fstream>
using namespace std;

CAnimal::CAnimal() :m_nume(""), m_data(0), m_greutate(0), m_hrana_preferata(""), m_cantitate_zi(0) {}

CAnimal::CAnimal(string& nume, int data, int greutate, string& hrana, int cantitate) :
	m_nume(nume), m_data(data), m_greutate(greutate), m_hrana_preferata(hrana), m_cantitate_zi(cantitate) {}

CAnimal::~CAnimal() {
}

void CAnimal::citire(ifstream& f) {
	f >> m_nume;
	f >> m_data;
	f >> m_greutate;
	f >> m_hrana_preferata;
	f >> m_cantitate_zi;
}

void CAnimal::afisare(ofstream& g)const {
	g << "Numele animalului: " << m_nume << endl;
	g << "Luna in care a fost adus: " << m_data << endl;
	g << "Greutatea: " << m_greutate << endl;
	g << "Hrana preferata: " << m_hrana_preferata << endl;
	g << "Cantitatea de mancare zilnica: " << m_cantitate_zi << endl;
}