#pragma once
#include "Patrat.h"
#include "Jucator.h"
#include <iostream>
#include <string>
using namespace std;

template<class Patrat, int x>
class Tabla {
public:
	static Tabla* getInstance() {
		if (!instance) {
			instance = new Tabla;
		}
		return instance;
	}
	~Tabla();
	void afisare();
	void Aseaza_Nave();
	void Joc();
private:
	static Tabla* instance;
	Tabla();
	Patrat matrix[x][x];
	Jucator P1;
	Jucator P2;
};

template<class Patrat, int x>
Tabla<Patrat, x>::Tabla() {
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < x; j++) {
			matrix[i][j].SetLinie(i);
			matrix[i][j].SetColoana(j);
		}
	}
	P1.Initializare_Nave();
	P2.Initializare_Nave();
}

template<class Patrat,int x>
Tabla<Patrat, x>* Tabla<Patrat, x>::instance = 0;


template<class Patrat, int x>
Tabla<Patrat, x>::~Tabla() {
}

template<class Patrat, int x>
void Tabla<Patrat, x>::afisare() {
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < x; j++) {
			this->matrix[i][j].afisare();
		}
	}
}

template<class Patrat, int x>
void Tabla<Patrat, x>::Aseaza_Nave() {
	int linie, coloana;
	string culoare_P1 = "rosu";
	string culoare_P2 = "albastru";
	cout << "Jucatorul 1 aseaza navele" << endl;
	for (int i = 0; i < P1.GetNrNave(); i++) {
		cout << "Introduceti linia:";
		cin >> linie;
		cout << "Introduceti coloana:";
		cin >> coloana;
		cout << endl;
		if (matrix[linie][coloana].GetStare() == false) {
			matrix[linie][coloana].Place(P1.GetNava(i));
			matrix[linie][coloana].SetCuloare(culoare_P1);
		}
		else {
			do {
				cout << "Patratul ales este ocupat" << endl;
				cout << "Reintroduceti linia:";
				cin >> linie;
				cout << "Reintroduceti coloana:";
				cin >> coloana;
				cout << endl;
			} while (matrix[linie][coloana].GetStare() == true);
			matrix[linie][coloana].Place(P1.GetNava(i));
			matrix[linie][coloana].SetCuloare(culoare_P1);
		}
	}
	cout << "\nJucatorul 2 aseaza navele" << endl;
	for (int i = 0; i < P2.GetNrNave(); i++) {
		cout << "Introduceti linia:";
		cin >> linie;
		cout << "Introduceti coloana:";
		cin >> coloana;
		cout << endl;
		if (matrix[linie][coloana].GetStare() == false) {
			matrix[linie][coloana].Place(P2.GetNava(i));
			matrix[linie][coloana].SetCuloare(culoare_P2);
		}
		else {
			do {
				cout << "Patratul ales este ocupat" << endl;
				cout << "Reintroduceti linia:";
				cin >> linie;
				cout << "Reintroduceti coloana:";
				cin >> coloana;
				cout << endl;
			} while (matrix[linie][coloana].GetStare() == true);
			matrix[linie][coloana].Place(P2.GetNava(i));
			matrix[linie][coloana].SetCuloare(culoare_P2);
		}
	}
}


template<class Patrat, int x>
void Tabla<Patrat, x>::Joc() {
	Aseaza_Nave();

	int linie, coloana;
	string culoare_P1 = "rosu";
	string culoare_P2 = "albastru";
	int Nave_P1 = P1.GetNrNave();
	int Nave_P2 = P2.GetNrNave();

	cout << "P1 ataca\n";
	do {
		cout << "Introduceti linie:";
		cin >> linie;
		cout << "Introduceti coloana:";
		cin >> coloana;

		if (matrix[linie][coloana].GetStare() == false) {
			cout << "Lovitura ratata--->-50p\n";
			P1.Decrementare_Puncte();
		}
		else if (matrix[linie][coloana].GetStare() == true && matrix[linie][coloana].GetCuloare() == culoare_P2) {
			cout << "Perfect hit!---->+100p\n";
			matrix[linie][coloana].RemoveNava();
			P1.Incrementatre_Puncte();
			Nave_P2--;
		}
		else {
			cout << "Lovitura ratata--->-50p\n";
			P1.Decrementare_Puncte();
		}
	} while (Nave_P2 > 0);

	cout << "P2 ataca\n";
	do {
		cout << "Introduceti linie:";
		cin >> linie;
		cout << "Introduceti coloana:";
		cin >> coloana;

		if (matrix[linie][coloana].GetStare() == false) {
			cout << "Lovitura ratata--->-50p\n";
			P2.Decrementare_Puncte();
		}
		else if (matrix[linie][coloana].GetStare() == true && matrix[linie][coloana].GetCuloare() == culoare_P1) {
			cout << "Perfect hit!---->+100p\n";
			matrix[linie][coloana].RemoveNava();
			P2.Incrementatre_Puncte();
			Nave_P1--;
		}
		else {
			cout << "Lovitura ratata--->-50p\n";
			P2.Decrementare_Puncte();
		}
	} while (Nave_P1 > 0);

	cout << "Punctele jucatorului 1 sunt:";
	P1.Show_puncte();
	cout << "Punctele jucatorului 2 sunt:";
	P2.Show_puncte();

}