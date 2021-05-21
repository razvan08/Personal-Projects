#pragma once
#include "CAnimalIerbivor.h"
class Caprioara:public CAnimalIerbivor
{public:
	Caprioara();
	Caprioara(string& nume, int data, int greutate, string& hrana, int cantitate,int nr_pui);
	~Caprioara();
	void citire(ifstream& f)override;
	void afisare(ofstream& g)const override;
private:
	int m_nr_pui;
};

