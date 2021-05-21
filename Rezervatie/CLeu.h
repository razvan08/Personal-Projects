#pragma once
#include "CAnimalCarnivor.h"

class CLeu :public CAnimalCarnivor
{public:
	CLeu();
	CLeu(string& nume, int data, int greutate, string& hrana, int cantitate, int temperatura, string& tara);
	~CLeu();
	void citire(ifstream& f)override;
	void afisare(ofstream& g)const override;
 private:
	 int m_temperatura_min;
	 string m_tara;
};

