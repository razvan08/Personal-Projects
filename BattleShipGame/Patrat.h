#pragma once
#include <iostream>
#include "Nava.h"
#include "Nava_Tip1.h"
#include "Nava_Tip2.h"
#include "Nava_Tip3.h"
#include "Nava_Tip4.h"
#include "Nava_Tip5.h"
#include "Nava_Tip6.h"
#include <string>
using namespace std;

class Patrat {
public:
	Patrat();
	Patrat(int linie, int coloana, string& culoare, bool stare);
	void SetStare() {
		m_stare = true;
	}
	void ResetStare() {
		m_stare = false;
	}
	void SetCuloare(string& culoare) {
		m_culoare = culoare;
	}
	void SetLinie(int linie) {
		m_linie = linie;
	}
	void SetColoana(int coloana) {
		m_coloana = coloana;
	}
	bool GetStare()const {
		return m_stare;
	}
	void show_stare();
	string GetCuloare()const {
		return m_culoare;
	}
	void afisare();
	void Place(Nava* T);
	void RemoveNava();
	~Patrat();
private:
	string m_culoare;
	int m_linie;
	int m_coloana;
	bool m_stare;
	Nava* Tip;
};